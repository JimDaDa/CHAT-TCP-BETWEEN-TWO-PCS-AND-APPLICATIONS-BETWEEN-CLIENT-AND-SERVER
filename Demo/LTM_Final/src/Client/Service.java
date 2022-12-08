package Client;

import Client.Receive_Message;
import Events.PublicEvent;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class Service {
   private static Service instance;
    private Socket client;
    private final int PORT_NUMBER = 50;
    private final String IP = "localhost";
    private User_Account user;
    private List<Send_File> fileSender;

    public static Service getInstance() {
        if (instance == null) {
            instance = new Service();
        }
        return instance;
    }

    private Service() {
        fileSender = new ArrayList<>();
        
        
    }

    public void startServer() {
        try {
            client = IO.socket("http://" + IP + ":" + PORT_NUMBER);
            client.on("list_user", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    //  list user
                    List<User_Account> users = new ArrayList<>();
                    for (Object o : os) {
                        User_Account u = new User_Account(o);
                        if (u.getID() != user.getID()) {
                            users.add(u);
                        }
                    }
                    PublicEvent.getInstance().getMenuLeftEvent().newUser(users);
                }
            });
            
            client.on("user_status", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    int userID = (Integer) os[0];
                    boolean status = (Boolean) os[1];
                    if (status) {
                        //  connect
                        PublicEvent.getInstance().getMenuLeftEvent().userConnect(userID);
                    } else {
                        //  disconnect
                        PublicEvent.getInstance().getMenuLeftEvent().userDisconnect(userID);
                    }
                }
            });
            
            client.on("receive_ms", new Emitter.Listener() {
                @Override
                public void call(Object... os) {
                    Receive_Message message = new Receive_Message(os[0]);
                    PublicEvent.getInstance().getChatEvent().receiveMsg(message);
                }
            });
            client.open();
        } catch (URISyntaxException e) {
            error(e);
        }
    }

    public Send_File addFile(File file, Send_Message message) throws IOException {
        Send_File data = new Send_File(file, client, message);
        message.setFile(data);
        fileSender.add(data);
        //  For send file one by one
        if (fileSender.size() == 1) {
            data.initSend();
        }
        return data;
    }

    public void fileSendFinish(Send_File data) throws IOException {
        fileSender.remove(data);
        if (!fileSender.isEmpty()) {
            //  Start send new file when old file sending finish
            fileSender.get(0).initSend();
        }
    }
    
    public Socket getClient() {
        return client;
    }

    public User_Account getUser() {
        return user;
    }

    public void setUser(User_Account user) {
        this.user = user;
    }

    private void error(Exception e) {
        System.err.println(e);
    }
}