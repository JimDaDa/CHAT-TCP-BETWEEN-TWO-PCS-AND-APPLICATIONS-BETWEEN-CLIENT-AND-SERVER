package Events;


import Client.Receive_Message;
import Client.Send_Message;
import javax.swing.Icon;

public interface ChatEvent {
    
    public void sendMsg(Send_Message data);

    public void receiveMsg(Receive_Message data);
}
