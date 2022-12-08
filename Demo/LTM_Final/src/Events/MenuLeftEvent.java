package Events;

import Client.User_Account;
import java.util.List;

public interface MenuLeftEvent {
    
    public void newUser(List<User_Account> users);
    
    public void userConnect(int userID);

    public void userDisconnect(int userID);
}
