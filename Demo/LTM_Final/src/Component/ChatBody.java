package Component;

import Client.MessageType;
import Client.Receive_Message;
import Client.Send_Message;
import Emoji.Emoji;
import Swing.ScrollBar;
import java.awt.Adjustable;
import java.awt.Color;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author HOAI THU
 */
public class ChatBody extends javax.swing.JPanel {

    /**
     * Creates new form ChatBody
     */
    public ChatBody() {
        initComponents();
        Body.setLayout(new MigLayout("fillx", "", "5[]5"));
        SP2.setVerticalScrollBar(new ScrollBar());
        SP2.getVerticalScrollBar().setBackground(Color.WHITE);
           
//        addDate("24/12/2012");
//        addItemChatRight("hihi");
//        addItemChatRight("hihi");
//        addItemChatLeft("helloooooooooooooo", "HT");
//        addItemChatLeft("hello", "HT", new ImageIcon(getClass().getResource("/Icons/test.jpg")), new ImageIcon(getClass().getResource("/Icons/test.jpg")));
//        String img[] = {};
//        addItemChatLeft("hello", "HT", new ImageIcon(getClass().getResource("/Icons/test.jpg")), new ImageIcon(getClass().getResource("/Icons/Poster.jpeg")));
//        addItemChatRight("hihi",new ImageIcon(getClass().getResource("/Icons/test.jpg")), new ImageIcon(getClass().getResource("/Icons/Poster.jpeg")));
//        addItemFileLeft("", "HT", "mydoc.pdf", "1MB");
//        addItemFileRight("", "mydoc.pdf", "1MB");
    }
    
    public void addItemChatRight(Send_Message data) {
        if (data.getMessageType() == MessageType.TEXT) {
            ChatRight item = new ChatRight();
            item.setMsg(data.getText());
            item.setTime();
            Body.add(item, "wrap, al right, w ::70%");
        } else if (data.getMessageType() == MessageType.EMOJI) {
            ChatRight item = new ChatRight();
            item.setEmoji(Emoji.getInstance().getImoji(Integer.valueOf(data.getText())).getIcon());
            item.setTime();
            Body.add(item, "wrap, al right, w ::70%");
        } else if (data.getMessageType() == MessageType.IMAGE) {
            ChatRight item = new ChatRight();
            item.setMsg("");
            item.setImage(data.getFile());
            item.setTime();
            Body.add(item, "wrap, al right, w ::70%");
        }
        Body.repaint();
        Body.revalidate();
        scrollToBottom();
    }

    public void addItemChatLeft(Receive_Message data) {
        if (data.getMessageType() == MessageType.TEXT) {
            ChatLeft item = new ChatLeft();
            item.setMsg(data.getText());
            item.setTime();
            Body.add(item, "wrap, w ::70%");
        } else if (data.getMessageType() == MessageType.EMOJI) {
            ChatLeft item = new ChatLeft();
            item.setEmoji(Emoji.getInstance().getImoji(Integer.valueOf(data.getText())).getIcon());
            item.setTime();
            Body.add(item, "wrap, w ::70%");
        } else if (data.getMessageType() == MessageType.IMAGE) {
            ChatLeft item = new ChatLeft();
            item.setMsg("");
            item.setImage(data.getDataImage());
            item.setTime();
            Body.add(item, "wrap, w ::70%");
        }
        Body.repaint();
        Body.revalidate();
        scrollToBottom();
    }
    
    public void addItemChatLeft(String text, String user) {
        ChatLeft item = new ChatLeft();
        item.setMsg(text);
        item.setUserProfile(user);
        Body.add(item, "wrap, w ::70%");
        Body.repaint();
        Body.revalidate();
        item.setTime();
        scrollToBottom();
    }

    public void addItemChatLeft(String text, String user, Icon... image) {
        ChatLeft item = new ChatLeft();
        item.setMsg(text);
        item.setImage(image);
        item.setUserProfile(user);
        Body.add(item, "wrap, w ::70%");
        Body.repaint();
        Body.revalidate();
        item.setTime();
        scrollToBottom();
    }
    
    public void addItemChatLeft(String text, String user, String[] image) {
        ChatLeft item = new ChatLeft();
        item.setMsg(text);
        item.setImage(image);
        item.setUserProfile(user);
        Body.add(item, "wrap, w ::70%");
        Body.repaint();
        Body.revalidate();
        item.setTime();
        scrollToBottom();
    }
    
    public void addItemFileLeft(String text, String user, String fileName, String fileSize) {
        ChatLeft item = new ChatLeft();
        item.setMsg(text);
        item.setFile(fileName, fileSize);
        item.setUserProfile(user);
        Body.add(item, "wrap, w ::70%");
        Body.repaint();
        Body.revalidate();
        item.setTime();
        scrollToBottom();
    }
    
    public void addItemChatRight(String text) {
        ChatRight item = new ChatRight();
        item.setMsg(text);
        Body.add(item, "wrap, al right, w ::70%");
        Body.repaint();
        Body.revalidate();
        item.setTime();
        scrollToBottom();
    }
    
    public void addItemChatRight(String text, Icon... image) {
        ChatRight item = new ChatRight();
        item.setMsg(text);
        item.setImage(image);
        Body.add(item, "wrap, al right, w ::70%");
        Body.repaint();
        Body.revalidate();
        item.setTime();
        scrollToBottom();
    }
    
    public void addItemFileRight(String text, String fileName, String fileSize) {
        ChatRight item = new ChatRight();
        item.setMsg(text);
        item.setFile(fileName, fileSize);
        Body.add(item, "wrap, al right, w ::70%");
        Body.repaint();
        Body.revalidate();
        item.setTime();
        scrollToBottom();
    }
    
    public void clearChat() {
        Body.removeAll();
        Body.repaint();
        Body.revalidate();
    }
    
    private void scrollToBottom() {
        JScrollBar verticalBar = SP2.getVerticalScrollBar();
        AdjustmentListener downScroller = new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                Adjustable adjustable = e.getAdjustable();
                adjustable.setValue(adjustable.getMaximum());
                verticalBar.removeAdjustmentListener(this);
            }
        };
        verticalBar.addAdjustmentListener(downScroller);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SP2 = new javax.swing.JScrollPane();
        Body = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));

        SP2.setBorder(null);
        SP2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        Body.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout BodyLayout = new javax.swing.GroupLayout(Body);
        Body.setLayout(BodyLayout);
        BodyLayout.setHorizontalGroup(
            BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 364, Short.MAX_VALUE)
        );
        BodyLayout.setVerticalGroup(
            BodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        SP2.setViewportView(Body);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(SP2, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(SP2)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Body;
    private javax.swing.JScrollPane SP2;
    // End of variables declaration//GEN-END:variables

    
}
