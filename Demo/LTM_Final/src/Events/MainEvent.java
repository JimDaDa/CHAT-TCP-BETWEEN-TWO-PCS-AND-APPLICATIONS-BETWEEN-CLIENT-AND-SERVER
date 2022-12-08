package Events;

import Client.User_Account;

public interface MainEvent {
    
    public void initChat();
    
    public void selectUser(User_Account user);

    public void updateUser(User_Account user);
}
