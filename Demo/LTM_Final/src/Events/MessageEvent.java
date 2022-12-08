package Events;

import Client.Model_Message;

public interface MessageEvent {
    
    public void callMessage(Model_Message message);
}
