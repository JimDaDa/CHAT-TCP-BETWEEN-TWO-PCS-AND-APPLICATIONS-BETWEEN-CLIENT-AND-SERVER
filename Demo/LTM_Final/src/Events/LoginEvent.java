package Events;

import Client.Model_Login;
import Client.Model_Register;

public interface LoginEvent {
    public void login(Model_Login data);
    
    public void goLogin();
    
    public void goRegister();

    public void register(Model_Register data, MessageEvent messageEvent);
}
