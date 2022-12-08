package Server;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;
import java.util.List;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JTextArea;

public class Service {
    private static Service instance;
    private SocketIOServer server;
    private ServiceUser serviceUser;
    private JTextArea textArea;
    private List<ModelClient> listClient;
    private final int PORT_NUMBER = 50;

    public static Service getInstance(JTextArea textArea) {
        if (instance == null) {
            instance = new Service(textArea);
        }
        return instance;
    }

    private Service(JTextArea textArea) {
        this.textArea = textArea;
        serviceUser = new ServiceUser();
        listClient = new ArrayList<>();
    }

    public void startServer() {
        Configuration config = new Configuration();
        config.setPort(PORT_NUMBER);
        server = new SocketIOServer(config);
        
        server.addConnectListener(new ConnectListener() {
            @Override
            public void onConnect(SocketIOClient sioc) {
                textArea.append("Có một máy khách đã kết nối.\n");
            }
        });
        
        server.addEventListener("register", ModelRegister.class, new DataListener<ModelRegister>() {
            @Override
            public void onData(SocketIOClient sioc, ModelRegister t, AckRequest ar) throws Exception {
                ModelMessage message = new ServiceUser().register(t);
                ar.sendAckData(message.isAction(), message.getMessage(), message.getData());
                if (message.isAction()) {
                    textArea.append("Người dùng đã đăng ký Username:" + t.getUsername() + ", Password:" + t.getPassword() + "\n");
                    server.getBroadcastOperations().sendEvent("list_user", (UserAccount) message.getData());
                    addClient(sioc, (UserAccount) message.getData());
                
                }
            }
        });
        
        server.addEventListener("login", ModelLogin.class, new DataListener<ModelLogin>() {
            @Override
            public void onData(SocketIOClient sioc, ModelLogin t, AckRequest ar) throws Exception {
                UserAccount login = serviceUser.login(t);
                if (login != null) {
                    ar.sendAckData(true, login);
                    addClient(sioc, login);
                    userConnect(login.getID());
                } else {
                    ar.sendAckData(false);
                }
            }
        });
        
        server.addEventListener("list_user", Integer.class, new DataListener<Integer>() {
            @Override
            public void onData(SocketIOClient sioc, Integer userID, AckRequest ar) throws Exception {
                try {
                    List<UserAccount> list = serviceUser.getUser(userID);
                    sioc.sendEvent("list_user", list.toArray());
                } catch (SQLException e) {
                    System.err.println(e);
                }
            }
        });
        
        server.addEventListener("send_to_user", SendMessage.class, new DataListener<SendMessage>() {
            @Override
            public void onData(SocketIOClient sioc, SendMessage t, AckRequest ar) throws Exception {
                sendToClient(t);
            }
        });
        
        server.addDisconnectListener(new DisconnectListener() {
            @Override
            public void onDisconnect(SocketIOClient sioc) {
                int userID = removeClient(sioc);
                if (userID != 0) {
                    //  removed
                    userDisconnect(userID);
                }
            }
        });
        
        server.start();
        textArea.append("Server đã khởi động với cổng " + PORT_NUMBER + ".\n");
    }
    
    private void userConnect(int userID) {
        server.getBroadcastOperations().sendEvent("user_status", userID, true);
    }

    private void userDisconnect(int userID) {
        server.getBroadcastOperations().sendEvent("user_status", userID, false);
    }

    private void addClient(SocketIOClient client, UserAccount user) {
        listClient.add(new ModelClient(client, user));
    }
    
    private void sendToClient(SendMessage data) {
        for (ModelClient c : listClient) {
            if (c.getUser().getID() == data.getToUserID()) {
                c.getClient().sendEvent("receive_ms", new ReceiveMessage(data.getMessageType(), data.getFromUserID(), data.getText()));
                break;
            }
        }
    }

    public int removeClient(SocketIOClient client) {
        for (ModelClient d : listClient) {
            if (d.getClient() == client) {
                listClient.remove(d);
                return d.getUser().getID();
            }
        }
        return 0;
    }

    public List<ModelClient> getListClient() {
        return listClient;
    }
}
