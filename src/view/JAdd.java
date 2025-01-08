/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.ArtistController;
import controller.ReleaseController;
import controller.TrackController;
import javax.swing.JOptionPane;
import model.ArtistDAO;
import model.ReleaseDAO;
import model.TrackDAO;


/**
 *
 * @author Aluno
 */
public class JAdd extends javax.swing.JFrame {

    private ArtistController artistController;
    private ReleaseController releaseController;
    private TrackController trackController;
    
    /**
     * Creates new form JAddUpdate
     */
    public JAdd(ArtistController artistController, ReleaseController releaseController, TrackController trackController) {
        this.artistController = artistController;
        this.releaseController = releaseController;
        this.trackController = trackController;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tabArtist = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtArtistName = new javax.swing.JTextField();
        txtArtistGenre = new javax.swing.JTextField();
        txtArtistImagePath = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaArtistAbout = new javax.swing.JTextArea();
        btnArtistAdd = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtReleaseTitle = new javax.swing.JTextField();
        txtReleaseLength = new javax.swing.JTextField();
        txtReleaseDate = new javax.swing.JTextField();
        txtReleaseArtistID = new javax.swing.JTextField();
        txtReleaseTrackNumber = new javax.swing.JTextField();
        txtReleaseImagePath = new javax.swing.JTextField();
        btnReleaseAdd = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnTrackAdd = new javax.swing.JButton();
        txtTrackTitle = new javax.swing.JTextField();
        txtTrackLength = new javax.swing.JTextField();
        txtTrackArtistID = new javax.swing.JTextField();
        txtTrackReleaseID = new javax.swing.JTextField();
        txtTrackAudioFile = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));

        tabArtist.setBackground(new java.awt.Color(45, 45, 45));
        tabArtist.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tabArtist.setToolTipText("");
        tabArtist.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(10, 10, 10));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 590));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Name");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 25, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Genre");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 25, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("About");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 91, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Avatar Image Path");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        txtArtistName.setBackground(new java.awt.Color(51, 51, 51));
        txtArtistName.setForeground(new java.awt.Color(255, 255, 255));
        txtArtistName.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.add(txtArtistName, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 47, 149, 28));

        txtArtistGenre.setBackground(new java.awt.Color(51, 51, 51));
        txtArtistGenre.setForeground(new java.awt.Color(255, 255, 255));
        txtArtistGenre.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.add(txtArtistGenre, new org.netbeans.lib.awtextra.AbsoluteConstraints(325, 47, 150, 28));

        txtArtistImagePath.setBackground(new java.awt.Color(51, 51, 51));
        txtArtistImagePath.setForeground(new java.awt.Color(255, 255, 255));
        txtArtistImagePath.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jPanel2.add(txtArtistImagePath, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 450, 28));

        areaArtistAbout.setBackground(new java.awt.Color(51, 51, 51));
        areaArtistAbout.setColumns(20);
        areaArtistAbout.setForeground(new java.awt.Color(255, 255, 255));
        areaArtistAbout.setRows(5);
        areaArtistAbout.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        areaArtistAbout.setCaretColor(new java.awt.Color(51, 51, 51));
        jScrollPane1.setViewportView(areaArtistAbout);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 113, 450, 120));

        btnArtistAdd.setBackground(new java.awt.Color(55, 55, 55));
        btnArtistAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnArtistAdd.setText("Add");
        btnArtistAdd.setFocusable(false);
        btnArtistAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnArtistAddMouseClicked(evt);
            }
        });
        jPanel2.add(btnArtistAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(183, 325, 125, -1));

        tabArtist.addTab("Artist", jPanel2);

        jPanel3.setBackground(new java.awt.Color(10, 10, 10));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Title");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Length");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Release Date");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Artist ID");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Track Number");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, -1, -1));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Cover Image Path");
        jLabel12.setToolTipText("");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        txtReleaseTitle.setBackground(new java.awt.Color(51, 51, 51));
        txtReleaseTitle.setForeground(new java.awt.Color(255, 255, 255));
        txtReleaseTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel3.add(txtReleaseTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 150, 28));

        txtReleaseLength.setBackground(new java.awt.Color(51, 51, 51));
        txtReleaseLength.setForeground(new java.awt.Color(255, 255, 255));
        txtReleaseLength.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel3.add(txtReleaseLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 161, 28));

        txtReleaseDate.setBackground(new java.awt.Color(51, 51, 51));
        txtReleaseDate.setForeground(new java.awt.Color(255, 255, 255));
        txtReleaseDate.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel3.add(txtReleaseDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 150, 28));

        txtReleaseArtistID.setBackground(new java.awt.Color(51, 51, 51));
        txtReleaseArtistID.setForeground(new java.awt.Color(255, 255, 255));
        txtReleaseArtistID.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        txtReleaseArtistID.setMinimumSize(new java.awt.Dimension(60, 26));
        jPanel3.add(txtReleaseArtistID, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 70, 28));

        txtReleaseTrackNumber.setBackground(new java.awt.Color(51, 51, 51));
        txtReleaseTrackNumber.setForeground(new java.awt.Color(255, 255, 255));
        txtReleaseTrackNumber.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel3.add(txtReleaseTrackNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 70, 28));

        txtReleaseImagePath.setBackground(new java.awt.Color(51, 51, 51));
        txtReleaseImagePath.setForeground(new java.awt.Color(255, 255, 255));
        txtReleaseImagePath.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel3.add(txtReleaseImagePath, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 430, 28));

        btnReleaseAdd.setBackground(new java.awt.Color(55, 55, 55));
        btnReleaseAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnReleaseAdd.setText("Add");
        btnReleaseAdd.setFocusable(false);
        btnReleaseAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReleaseAddMouseClicked(evt);
            }
        });
        jPanel3.add(btnReleaseAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 285, 125, -1));

        tabArtist.addTab("Release", jPanel3);

        jPanel4.setBackground(new java.awt.Color(10, 10, 10));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Title");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Length");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, -1, -1));

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Artist ID");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Release ID");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, -1, -1));

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Audio File Path");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 200, -1, -1));

        btnTrackAdd.setBackground(new java.awt.Color(55, 55, 55));
        btnTrackAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnTrackAdd.setText("Add");
        btnTrackAdd.setFocusable(false);
        btnTrackAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTrackAddMouseClicked(evt);
            }
        });
        jPanel4.add(btnTrackAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 285, 125, -1));

        txtTrackTitle.setBackground(new java.awt.Color(51, 51, 51));
        txtTrackTitle.setForeground(new java.awt.Color(255, 255, 255));
        txtTrackTitle.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel4.add(txtTrackTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 150, 28));

        txtTrackLength.setBackground(new java.awt.Color(51, 51, 51));
        txtTrackLength.setForeground(new java.awt.Color(255, 255, 255));
        txtTrackLength.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel4.add(txtTrackLength, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 150, 28));

        txtTrackArtistID.setBackground(new java.awt.Color(51, 51, 51));
        txtTrackArtistID.setForeground(new java.awt.Color(255, 255, 255));
        txtTrackArtistID.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel4.add(txtTrackArtistID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 85, 28));

        txtTrackReleaseID.setBackground(new java.awt.Color(51, 51, 51));
        txtTrackReleaseID.setForeground(new java.awt.Color(255, 255, 255));
        txtTrackReleaseID.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel4.add(txtTrackReleaseID, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 85, 28));

        txtTrackAudioFile.setBackground(new java.awt.Color(51, 51, 51));
        txtTrackAudioFile.setForeground(new java.awt.Color(255, 255, 255));
        txtTrackAudioFile.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel4.add(txtTrackAudioFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 220, 415, 28));

        tabArtist.addTab("Track", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabArtist, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(tabArtist, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnArtistAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnArtistAddMouseClicked
        String name = txtArtistName.getText();
        String genre = txtArtistGenre.getText();
        String about = areaArtistAbout.getText();
        String imagePath = txtArtistImagePath.getText();
        
        artistController.add(name, genre, about, imagePath);
        
        JOptionPane.showMessageDialog(this, "Artista salvo!");
        txtArtistName.setText("");
        txtArtistGenre.setText("");
        areaArtistAbout.setText("");
        txtArtistImagePath.setText("");
    }//GEN-LAST:event_btnArtistAddMouseClicked

    private void btnReleaseAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReleaseAddMouseClicked
        String title = txtReleaseTitle.getText();
        String releaseDate = txtReleaseDate.getText();
        int trackNumber = Integer.valueOf(txtReleaseTrackNumber.getText());
        String length = txtReleaseLength.getText();
        String imagePath = txtReleaseImagePath.getText();
        int artistId = Integer.valueOf(txtReleaseArtistID.getText());
        
        releaseController.add(title, releaseDate, trackNumber, length, imagePath, artistId);
        
        JOptionPane.showMessageDialog(this, "Lançamento salvo!");
        txtReleaseTitle.setText("");
        txtReleaseDate.setText("");
        txtReleaseTrackNumber.setText("");
        txtReleaseLength.setText("");
        txtReleaseImagePath.setText("");
        txtReleaseArtistID.setText("");
    }//GEN-LAST:event_btnReleaseAddMouseClicked

    private void btnTrackAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrackAddMouseClicked
        String title = txtTrackTitle.getText();
        String trackLength = txtTrackLength.getText();
        String audioFile = txtTrackAudioFile.getText();
        int artistId = Integer.valueOf(txtTrackArtistID.getText());
        int releaseId = Integer.valueOf(txtTrackReleaseID.getText());
        
        trackController.add(title, trackLength, audioFile, artistId, releaseId);
        
        JOptionPane.showMessageDialog(this, "Música salva!");
        txtTrackTitle.setText("");
        txtTrackLength.setText("");
        txtTrackAudioFile.setText("");
        txtTrackArtistID.setText("");
        txtTrackReleaseID.setText("");
    }//GEN-LAST:event_btnTrackAddMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ArtistDAO artistDAO = new ArtistDAO();
                ArtistController artistController = new ArtistController(artistDAO);
                
                ReleaseDAO releaseDAO = new ReleaseDAO();
                ReleaseController releaseController = new ReleaseController(releaseDAO);
                
                TrackDAO trackDAO = new TrackDAO();
                TrackController trackController = new TrackController(trackDAO);
                
                JAdd jadd = new JAdd(artistController, releaseController, trackController);
                jadd.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaArtistAbout;
    private javax.swing.JButton btnArtistAdd;
    private javax.swing.JButton btnReleaseAdd;
    private javax.swing.JButton btnTrackAdd;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane tabArtist;
    private javax.swing.JTextField txtArtistGenre;
    private javax.swing.JTextField txtArtistImagePath;
    private javax.swing.JTextField txtArtistName;
    private javax.swing.JTextField txtReleaseArtistID;
    private javax.swing.JTextField txtReleaseDate;
    private javax.swing.JTextField txtReleaseImagePath;
    private javax.swing.JTextField txtReleaseLength;
    private javax.swing.JTextField txtReleaseTitle;
    private javax.swing.JTextField txtReleaseTrackNumber;
    private javax.swing.JTextField txtTrackArtistID;
    private javax.swing.JTextField txtTrackAudioFile;
    private javax.swing.JTextField txtTrackLength;
    private javax.swing.JTextField txtTrackReleaseID;
    private javax.swing.JTextField txtTrackTitle;
    // End of variables declaration//GEN-END:variables
}
