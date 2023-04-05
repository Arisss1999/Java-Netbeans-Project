import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class utama extends javax.swing.JFrame {

    dashboard dsb;
    pendaftaran pdf;
    penimbangan pnm;
    imunisasi im;
    vitamin vt;
    kematian km;
    laporan lp;
    
    public utama() {
        initComponents();
        
        pdf = new pendaftaran();
        dsb = new dashboard();
        pnm = new penimbangan();
        im = new imunisasi();
        vt = new vitamin();
        km = new kematian();
        lp = new laporan();
        
        panel.add(dsb);
        panel.add(pdf);
        panel.add(pnm);
        panel.add(im);
        panel.add(vt);
        panel.add(km);
        panel.add(lp);
        
        dsb.setVisible(true);
        pdf.setVisible(false);
        pnm.setVisible(false);
        im.setVisible(false);
        vt.setVisible(false);
        km.setVisible(false);
        lp.setVisible(false);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pendaftaran = new javax.swing.JButton();
        penimbangan = new javax.swing.JButton();
        vitamin = new javax.swing.JButton();
        laporan = new javax.swing.JButton();
        imunisasi = new javax.swing.JButton();
        data_kematian = new javax.swing.JButton();
        panel = new javax.swing.JPanel();
        backgrounf = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1366, 768));
        setPreferredSize(new java.awt.Dimension(1366, 768));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pendaftaran.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/Pendaftaran.png"))); // NOI18N
        pendaftaran.setBorder(null);
        pendaftaran.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/Pendaftaran1.png"))); // NOI18N
        pendaftaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pendaftaranActionPerformed(evt);
            }
        });
        getContentPane().add(pendaftaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, -1, -1));

        penimbangan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/Penimbangan.png"))); // NOI18N
        penimbangan.setBorder(null);
        penimbangan.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/Penimbangan1.png"))); // NOI18N
        penimbangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penimbanganActionPerformed(evt);
            }
        });
        getContentPane().add(penimbangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, -1, -1));

        vitamin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/vitamin.png"))); // NOI18N
        vitamin.setBorder(null);
        vitamin.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/vitamin1.png"))); // NOI18N
        vitamin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vitaminActionPerformed(evt);
            }
        });
        getContentPane().add(vitamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, -1, -1));

        laporan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/Laporan.png"))); // NOI18N
        laporan.setBorder(null);
        laporan.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/Laporan1.png"))); // NOI18N
        laporan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laporanActionPerformed(evt);
            }
        });
        getContentPane().add(laporan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 560, -1, -1));

        imunisasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/imunisasi.png"))); // NOI18N
        imunisasi.setBorder(null);
        imunisasi.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/imunisasi1.png"))); // NOI18N
        imunisasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imunisasiActionPerformed(evt);
            }
        });
        getContentPane().add(imunisasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, -1, -1));

        data_kematian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/data kematian.png"))); // NOI18N
        data_kematian.setBorder(null);
        data_kematian.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/data kematian1.png"))); // NOI18N
        data_kematian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                data_kematianActionPerformed(evt);
            }
        });
        getContentPane().add(data_kematian, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, -1, -1));

        panel.setMaximumSize(new java.awt.Dimension(1139, 655));
        panel.setMinimumSize(new java.awt.Dimension(1139, 655));
        panel.setPreferredSize(new java.awt.Dimension(1139, 655));
        panel.setLayout(new javax.swing.BoxLayout(panel, javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(228, 110, -1, -1));

        backgrounf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Utama.png"))); // NOI18N
        getContentPane().add(backgrounf, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pendaftaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pendaftaranActionPerformed
        pdf.setVisible(true);
        dsb.setVisible(false);
        pnm.setVisible(false);
        im.setVisible(false);
        vt.setVisible(false);
        km.setVisible(false);
        lp.setVisible(false);
       
    }//GEN-LAST:event_pendaftaranActionPerformed

    private void penimbanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penimbanganActionPerformed
        pdf.setVisible(false);
        dsb.setVisible(false);
        pnm.setVisible(true);
        im.setVisible(false);
        vt.setVisible(false);
        km.setVisible(false);
        lp.setVisible(false);
        
        new pilih_anak().setVisible(true);
    }//GEN-LAST:event_penimbanganActionPerformed

    private void imunisasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imunisasiActionPerformed
        pdf.setVisible(false);
        dsb.setVisible(false);
        pnm.setVisible(false);
        im.setVisible(true);
        vt.setVisible(false);
        km.setVisible(false);
        lp.setVisible(false);
        
        new pilih_anak().setVisible(true);
    }//GEN-LAST:event_imunisasiActionPerformed

    private void vitaminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vitaminActionPerformed
        pdf.setVisible(false);
        dsb.setVisible(false);
        pnm.setVisible(false);
        im.setVisible(false);
        vt.setVisible(true);
        km.setVisible(false);
        lp.setVisible(false);        
        
        new pilih_anak().setVisible(true);
    }//GEN-LAST:event_vitaminActionPerformed

    private void data_kematianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_data_kematianActionPerformed
        pdf.setVisible(false);
        dsb.setVisible(false);
        pnm.setVisible(false);
        im.setVisible(false);
        vt.setVisible(false);
        km.setVisible(true);
        lp.setVisible(false);
       
        kematian.ubah.setVisible(false);
        kematian.simpan.setVisible(true);
    }//GEN-LAST:event_data_kematianActionPerformed

    private void laporanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laporanActionPerformed
         pdf.setVisible(false);
        dsb.setVisible(false);
        pnm.setVisible(false);
        im.setVisible(false);
        vt.setVisible(false);
        km.setVisible(false);
        lp.setVisible(true);

    }//GEN-LAST:event_laporanActionPerformed

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
            java.util.logging.Logger.getLogger(utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(utama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new utama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgrounf;
    private javax.swing.JButton data_kematian;
    private javax.swing.JButton imunisasi;
    private javax.swing.JButton laporan;
    private javax.swing.JPanel panel;
    private javax.swing.JButton pendaftaran;
    private javax.swing.JButton penimbangan;
    private javax.swing.JButton vitamin;
    // End of variables declaration//GEN-END:variables
}
