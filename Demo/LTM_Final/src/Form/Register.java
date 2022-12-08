package Form;

import Events.MessageEvent;
import Events.PublicEvent;
import Client.Model_Message;
import Client.Model_Register;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Register extends JPanel {

    public Register() {
        initComponents();
        //init();
    }
    
    public void init() {
        Register lg = new Register();
        slide.init(lg);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        slide = new Swing.PanelSlide();
        lbTitle = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtPass1 = new javax.swing.JPasswordField();
        btnRegister = new javax.swing.JButton();
        btnLogin = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtPass2 = new javax.swing.JPasswordField();
        lbError = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(606, 358));

        slide.setBackground(new java.awt.Color(255, 255, 255));

        lbTitle.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("ĐĂNG KÝ");
        lbTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel3.setFont(new java.awt.Font("Cambria", 2, 11)); // NOI18N
        jLabel3.setText("Tên đăng nhập");

        txtUser.setFont(new java.awt.Font("Cambria", 0, 11)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Cambria", 2, 11)); // NOI18N
        jLabel4.setText("Mật khẩu");

        txtPass1.setText("Password");

        btnRegister.setBackground(new java.awt.Color(255, 255, 255));
        btnRegister.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(5, 52, 107));
        btnRegister.setText("Đăng ký");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnLogin.setBackground(new java.awt.Color(255, 255, 255));
        btnLogin.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(65, 142, 232));
        btnLogin.setText("Đăng nhập");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Cambria", 2, 11)); // NOI18N
        jLabel5.setText("Nhập lại mật khẩu");

        txtPass2.setText("Password");

        lbError.setFont(new java.awt.Font("Cambria", 0, 11)); // NOI18N
        lbError.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout slideLayout = new javax.swing.GroupLayout(slide);
        slide.setLayout(slideLayout);
        slideLayout.setHorizontalGroup(
            slideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(slideLayout.createSequentialGroup()
                .addComponent(lbTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
            .addGroup(slideLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(slideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtUser)
                    .addComponent(txtPass1)
                    .addComponent(btnRegister, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtPass2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbError, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        slideLayout.setVerticalGroup(
            slideLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(slideLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegister)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbError)
                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(slide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(slide, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        String username = txtUser.getText().trim();
        String password = String.valueOf(txtPass1.getPassword());
        String confirmPassword = String.valueOf(txtPass2.getPassword());
        if (username.equals("")) {
            txtUser.grabFocus();
        } else if (password.equals("")) {
            txtPass1.grabFocus();
        } else if (!password.equals(confirmPassword)) {
            txtPass1.grabFocus();
        } else {
            Model_Register data = new Model_Register(username, password);
            PublicEvent.getInstance().getLoginEvent().register(data, new MessageEvent() {
                //@Override
                public void callMessage(Model_Message message) {
                    if (!message.isAction()) {
                        lbError.setText(message.getMessage());
                    } else {
                        PublicEvent.getInstance().getMainEvent().initChat();
                    }
                }
            });
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        PublicEvent.getInstance().getLoginEvent().goLogin();
    }//GEN-LAST:event_btnLoginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JButton btnRegister;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbError;
    private javax.swing.JLabel lbTitle;
    private Swing.PanelSlide slide;
    private javax.swing.JPasswordField txtPass1;
    private javax.swing.JPasswordField txtPass2;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
