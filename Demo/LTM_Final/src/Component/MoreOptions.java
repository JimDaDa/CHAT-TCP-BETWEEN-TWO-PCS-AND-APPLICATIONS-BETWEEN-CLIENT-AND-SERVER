package Component;

import Client.MessageType;
import Client.Send_Message;
import Client.Service;
import Client.User_Account;
import Emoji.Emoji;
import Emoji.Model_Emoji;
import Events.PublicEvent;
import Main.Main;
import Swing.ScrollBar;
import Swing.WrapLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import net.miginfocom.swing.MigLayout;

public class MoreOptions extends JPanel {

    private JPanel panelHeader;
    private JPanel panelDetail;
    private User_Account user;
    
    public User_Account getUser() {
        return user;
    }

    public void setUser(User_Account user) {
        this.user = user;
    }
  
    public MoreOptions() {
        initComponents();
        init();
    }

    private void init() {
        setLayout(new MigLayout("fillx"));
        panelHeader = new JPanel();
        panelHeader.setLayout(new BoxLayout(panelHeader, BoxLayout.LINE_AXIS));
        panelHeader.add(getButtonImage());
        panelHeader.add(getButtonFile());
        panelHeader.add(getEmojiStyle());
        add(panelHeader, "w 100%, h 20!, wrap");
        panelDetail = new JPanel();
        panelDetail.setLayout(new WrapLayout(WrapLayout.LEFT));    //  use warp layout
        JScrollPane ch = new JScrollPane(panelDetail);
        ch.setBorder(null);
        ch.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        ch.setVerticalScrollBar(new ScrollBar());
        //  test color
        add(ch, "w 100%, h 100%");
    }

    private JButton getButtonImage() {
        OptionButton cmd = new OptionButton();
        cmd.setIcon(new ImageIcon(getClass().getResource("/Icons/IconImage.png")));
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser ch = new JFileChooser();
                ch.setMultiSelectionEnabled(true);
                ch.setFileFilter(new FileFilter() {
                    @Override
                    public boolean accept(File file) {
                        return file.isDirectory() || isImageFile(file);
                    }

                    @Override
                    public String getDescription() {
                        return "Image File";
                    }
                });
                int option = ch.showOpenDialog(Main.getFrames()[0]);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File files[] = ch.getSelectedFiles();
                    try {
                        for (File file : files) {
                            Send_Message message = new Send_Message(MessageType.IMAGE, Service.getInstance().getUser().getID(), user.getID(), "");
                            Service.getInstance().addFile(file, message);
                           PublicEvent.getInstance().getChatEvent().sendMsg(message);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        return cmd;
    }
    
    private JButton getButtonFile() {
        OptionButton cmd = new OptionButton();
        cmd.setIcon(new ImageIcon(getClass().getResource("/Icons/IconLink.png")));
        cmd.addActionListener((ActionEvent ae) -> {
            JFileChooser ch = new JFileChooser();
            ch.showOpenDialog(Main.getFrames()[0]);
            //  Update next
        });
        return cmd;
    }
    
    private JButton getEmojiStyle() {
        OptionButton cmd = new OptionButton();
        cmd.setIcon(Emoji.getInstance().getImoji(1).toSize(25, 25).getIcon());
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                clearSelected();
                cmd.setSelected(true);
                panelDetail.removeAll();
                for (Model_Emoji d : Emoji.getInstance().getStyle()) {
                    panelDetail.add(getButton(d));
                }
                panelDetail.repaint();
                panelDetail.revalidate();
            }
        });
        return cmd;
    }
    
    private JButton getButton(Model_Emoji data) {
        JButton cmd = new JButton(data.getIcon());
        cmd.setName(data.getId() + "");
        cmd.setBorder(new EmptyBorder(3, 3, 3, 3));
        cmd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        cmd.setContentAreaFilled(false);
        cmd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Send_Message message = new Send_Message(MessageType.EMOJI, Service.getInstance().getUser().getID(), user.getID(), data.getId() + "");
                sendMessage(message);
                PublicEvent.getInstance().getChatEvent().sendMsg(message);
            }
        });
        return cmd;
    }
    
    private void sendMessage(Send_Message data) {
        Service.getInstance().getClient().emit("send_to_user", data.toJsonObject());
    }
    
    private boolean isImageFile(File file) {
        String name = file.getName().toLowerCase();
        return name.endsWith(".jpg") || name.endsWith(".png") || name.endsWith(".jpeg") || name.endsWith(".gif");
    }
    
    private void clearSelected() {
        for (Component c : panelHeader.getComponents()) {
            if (c instanceof OptionButton) {
                ((OptionButton) c).setSelected(false);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
