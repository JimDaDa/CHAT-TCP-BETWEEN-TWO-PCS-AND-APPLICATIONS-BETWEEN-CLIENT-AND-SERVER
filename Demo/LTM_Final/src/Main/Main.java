package Main;

import Component.ChatLeft;
import Component.ChatBody;
import Component.ChatTitle;
import Component.ChatBottom;
import Component.ItemUser;
import Events.ImageViewEvent;
import Events.MainEvent;
import Events.MenuLeftEvent;
import Events.PublicEvent;
import Client.Service;
import Client.User_Account;
import Form.ImageView;
import Swing.ComponentResizer;
import Swing.ScrollBar;
import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import java.awt.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollBar;
import net.miginfocom.swing.MigLayout;
import java.util.ArrayList;
import java.util.List;

public class Main extends javax.swing.JFrame {
    
    public Main() {
        initComponents();
        init();
    }
    
    private void init() {
       setIconImage (new ImageIcon(getClass().getResource("/Icons/icon.jpg")).getImage());     
       ComponentResizer com = new ComponentResizer();
       com.registerComponent (this) ;
       com.setMinimumSize (new Dimension (622, 376));
       com.setMaximumSize (Toolkit.getDefaultToolkit().getScreenSize());
       com. setSnapSize (new Dimension (10, 10));

       Login.setVisible(true);
       imageView.setVisible(false);
       home.setVisible(true);

       initEvent();
       Service.getInstance().startServer();
    }

    public void initEvent() {
        PublicEvent.getInstance().addMainEvent(new MainEvent() {
            @Override
            public void initChat() {
                Login.setVisible(false);
                home.setVisible(true);
                Service.getInstance().getClient().emit("list_user", Service.getInstance().getUser().getID());
            }

            @Override
            public void selectUser(User_Account user) {
                home.setUser(user);
            }

            @Override
            public void updateUser(User_Account user) {
                home.updateUser(user);
            }
        });

        PublicEvent.getInstance().addImageViewEvent(new ImageViewEvent() {
           @Override
           public void viewImage(Icon image) {
               imageView.imageView(image);
           }
           @Override
           public void saveImage(Icon image) {
               System.out.println("...!");
           }
       });
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageAvatar1 = new Swing.ImageAvatar();
        Border = new javax.swing.JPanel();
        Background = new javax.swing.JPanel();
        Login = new Form.Login_Register();
        imageView = new Form.ImageView();
        home = new Form.Home();
        Title = new javax.swing.JPanel();
        minimise = new javax.swing.JButton();
        close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        Border.setBackground(new java.awt.Color(225, 230, 234));
        Border.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Background.setBackground(new java.awt.Color(255, 255, 255));
        Background.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        Background.add(Login, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -2, 620, 360));
        Background.add(imageView, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        Background.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, -1, -1));

        Title.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                TitleMouseDragged(evt);
            }
        });
        Title.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TitleMousePressed(evt);
            }
        });

        minimise.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/IconMinimize.png"))); // NOI18N
        minimise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimiseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TitleLayout = new javax.swing.GroupLayout(Title);
        Title.setLayout(TitleLayout);
        TitleLayout.setHorizontalGroup(
            TitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TitleLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(minimise, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        TitleLayout.setVerticalGroup(
            TitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(minimise, javax.swing.GroupLayout.PREFERRED_SIZE, 19, Short.MAX_VALUE)
        );

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/IconClose.png"))); // NOI18N
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BorderLayout = new javax.swing.GroupLayout(Border);
        Border.setLayout(BorderLayout);
        BorderLayout.setHorizontalGroup(
            BorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BorderLayout.createSequentialGroup()
                .addComponent(Title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        BorderLayout.setVerticalGroup(
            BorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BorderLayout.createSequentialGroup()
                .addGroup(BorderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(Border);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private int pX;
    private int pY;
    
    private void TitleMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TitleMouseDragged
        // TODO add your handling code here:
        this.setLocation(this.getLocation().x + evt.getX() - pX, this.getLocation().y + evt.getY() - pY);
    }//GEN-LAST:event_TitleMouseDragged

    private void TitleMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TitleMousePressed
        // TODO add your handling code here:
        pX = evt.getX();
        pY = evt.getY();
    }//GEN-LAST:event_TitleMousePressed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_closeActionPerformed

    private void minimiseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minimiseActionPerformed
        // TODO add your handling code here:
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimiseActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JPanel Border;
    private Form.Login_Register Login;
    private javax.swing.JPanel Title;
    private javax.swing.JButton close;
    private Form.Home home;
    private Swing.ImageAvatar imageAvatar1;
    private Form.ImageView imageView;
    private javax.swing.JButton minimise;
    // End of variables declaration//GEN-END:variables
}
