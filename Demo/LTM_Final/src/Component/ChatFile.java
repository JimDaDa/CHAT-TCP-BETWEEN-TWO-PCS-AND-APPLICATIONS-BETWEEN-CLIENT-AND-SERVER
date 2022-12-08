package Component;

import javax.swing.JPanel;

public class ChatFile extends JPanel {

    /**
     * Creates new form ChatFile
     */
    public ChatFile() {
        initComponents();
        setOpaque(false);
    }
    
    public void setFile(String fileName, String fileSize) {
        lbFileName.setText(fileName);
        lbFileSize.setText(fileSize);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbFileName = new javax.swing.JLabel();
        lbFileSize = new javax.swing.JLabel();
        imageFile = new Swing.ImageAvatar();

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        lbFileName.setFont(new java.awt.Font("Cambria", 0, 11)); // NOI18N
        lbFileName.setText("FileName.file");
        jPanel1.add(lbFileName);

        lbFileSize.setFont(new java.awt.Font("Cambria", 0, 11)); // NOI18N
        lbFileSize.setForeground(new java.awt.Color(50, 151, 230));
        lbFileSize.setText("5 MB");
        jPanel1.add(lbFileSize);

        imageFile.setBorderSize(0);
        imageFile.setImage(new javax.swing.ImageIcon(getClass().getResource("/Icons/IconFile.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(imageFile, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(imageFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Swing.ImageAvatar imageFile;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbFileName;
    private javax.swing.JLabel lbFileSize;
    // End of variables declaration//GEN-END:variables
}
