package Form;

import Client.Receive_Message;
import Client.Send_Message;
import Client.User_Account;
import Component.ChatBody;
import Component.ChatBottom;
import Component.ChatTitle;
import Events.ChatEvent;
import Events.PublicEvent;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author HOAI THU
 */
public class Chat extends javax.swing.JPanel {
    
    public Chat() {
        initComponents();
     
        init();
    }
    
    private void init() {
        setLayout(new MigLayout("fillx", "0[fill]0", "0[]0[100%, bottom]0[shrink 0]0"));
//        chatTitle = new ChatTitle();
//        chatBody = new ChatBody();
//        chatBottom = new ChatBottom();
        PublicEvent.getInstance().addChatEvent(new ChatEvent() {
           
            @Override
            public void sendMsg(Send_Message data) {
                chatBody.addItemChatRight(data);
            }

            @Override
            public void receiveMsg(Receive_Message data) {
                if (chatTitle.getUser().getID() == data.getFromUserID()) {
                    chatBody.addItemChatLeft(data);
                }
            }
        });
        add(chatTitle, "wrap");
        add(chatBody, "wrap");
        add(chatBottom, "h ::50%");
    }

    public void setUser(User_Account user) {
        chatTitle.setUserName(user);
        chatBottom.setUser(user);
        chatBody.clearChat();
    }

    public void updateUser(User_Account user) {
        chatTitle.updateUser(user);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chatTitle = new Component.ChatTitle();
        chatBottom = new Component.ChatBottom();
        chatBody = new Component.ChatBody();

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chatTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chatBody, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chatBottom, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(chatTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chatBody, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chatBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Component.ChatBody chatBody;
    private Component.ChatBottom chatBottom;
    private Component.ChatTitle chatTitle;
    // End of variables declaration//GEN-END:variables
}
