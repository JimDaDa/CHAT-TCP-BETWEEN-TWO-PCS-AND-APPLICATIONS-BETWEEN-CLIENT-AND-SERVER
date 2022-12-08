package Server;

import com.corundumstudio.socketio.SocketIOClient;

public class ModelClient {

    private SocketIOClient client;
    private UserAccount user;
    
    public SocketIOClient getClient() {
        return client;
    }

    public void setClient(SocketIOClient client) {
        this.client = client;
    }

    public UserAccount getUser() {
        return user;
    }

    public void setUser(UserAccount user) {
        this.user = user;
    }

    public ModelClient(SocketIOClient client, UserAccount user) {
        this.client = client;
        this.user = user;
    }

    public ModelClient() {
    }

}