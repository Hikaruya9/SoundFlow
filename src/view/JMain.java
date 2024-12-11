/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Aluno
 */
public class JMain extends javax.swing.JFrame {

    /**
     * Creates new form JMain
     */
    public JMain() {
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
        txtSearch = new javax.swing.JTextField();
        jProgressBar1 = new javax.swing.JProgressBar();
        btnPlay = new javax.swing.JButton();
        lblTrackImage = new javax.swing.JLabel();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        txtCurrentlyPlayingTrack = new javax.swing.JTextField();
        txtCurrentlyPlayingArtist = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSlider1 = new javax.swing.JSlider();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(5, 5, 5));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        txtSearch.setBackground(new java.awt.Color(41, 40, 40));
        txtSearch.setForeground(new java.awt.Color(204, 204, 204));
        txtSearch.setRequestFocusEnabled(false);
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSearchKeyPressed(evt);
            }
        });
        jPanel1.add(txtSearch);
        txtSearch.setBounds(410, 20, 460, 40);

        jProgressBar1.setBorder(null);
        jPanel1.add(jProgressBar1);
        jProgressBar1.setBounds(410, 695, 460, 7);

        btnPlay.setBackground(new java.awt.Color(255, 255, 255));
        btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/play.png"))); // NOI18N
        btnPlay.setRequestFocusEnabled(false);
        btnPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlayActionPerformed(evt);
            }
        });
        jPanel1.add(btnPlay);
        btnPlay.setBounds(620, 650, 35, 35);

        lblTrackImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/In_the_Court_of_the_Crimson_King.jpeg"))); // NOI18N
        jPanel1.add(lblTrackImage);
        lblTrackImage.setBounds(20, 640, 60, 60);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel1.add(jLayeredPane1);
        jLayeredPane1.setBounds(304, 87, 100, 100);

        txtCurrentlyPlayingTrack.setBackground(new java.awt.Color(5, 5, 5));
        txtCurrentlyPlayingTrack.setText("music title");
        txtCurrentlyPlayingTrack.setBorder(null);
        txtCurrentlyPlayingTrack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCurrentlyPlayingTrackActionPerformed(evt);
            }
        });
        jPanel1.add(txtCurrentlyPlayingTrack);
        txtCurrentlyPlayingTrack.setBounds(90, 645, 270, 16);

        txtCurrentlyPlayingArtist.setBackground(new java.awt.Color(5, 5, 5));
        txtCurrentlyPlayingArtist.setText("artist");
        txtCurrentlyPlayingArtist.setBorder(null);
        jPanel1.add(txtCurrentlyPlayingArtist);
        txtCurrentlyPlayingArtist.setBounds(90, 665, 64, 16);
        jPanel1.add(jButton1);
        jButton1.setBounds(570, 656, 30, 28);
        jPanel1.add(jButton2);
        jButton2.setBounds(1020, 660, 30, 28);
        jPanel1.add(jButton3);
        jButton3.setBounds(670, 656, 30, 28);
        jPanel1.add(jButton4);
        jButton4.setBounds(520, 656, 30, 28);

        jSlider1.setFocusable(false);
        jPanel1.add(jSlider1);
        jSlider1.setBounds(1050, 665, 200, 22);
        jPanel1.add(jButton5);
        jButton5.setBounds(720, 656, 30, 28);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlayActionPerformed
        if(!checkPlayPause){
            btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pause.png")));
            checkPlayPause = true;
        }else{
            btnPlay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/play.png")));
            checkPlayPause = false;
        }
    }//GEN-LAST:event_btnPlayActionPerformed

    private void txtSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyPressed
        
    }//GEN-LAST:event_txtSearchKeyPressed

    private void txtCurrentlyPlayingTrackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCurrentlyPlayingTrackActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCurrentlyPlayingTrackActionPerformed

    /**
     * @param args the command line arguments
     */
    
    boolean checkPlayPause = false;
    
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
            java.util.logging.Logger.getLogger(JMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JMain jmain = new JMain();
                jmain.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPlay;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JLabel lblTrackImage;
    private javax.swing.JTextField txtCurrentlyPlayingArtist;
    private javax.swing.JTextField txtCurrentlyPlayingTrack;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}

// Trazer uma opção de copiar o id da música diretamente na pesquisa
//// Fazer com que a página se adapte ao tamanho da tela do usuário.
////// Funções do visual entram no controller(?)
