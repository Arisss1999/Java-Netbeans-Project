import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.text.*;
import java.util.Date;

public class utama extends javax.swing.JFrame {
    
    dashboard db;
    pesanan pms;
    stok st;
    riwayat_pesanan rp;
    laporan lp;
    
    Connection con;
    Statement stm;
    ResultSet rs;
    String sql;
    
    public utama() 
    {
        initComponents();
        
        db = new dashboard();
        pms = new pesanan();
        st = new stok();
        rp = new riwayat_pesanan();
        lp = new laporan();
        
        pnl.add(db);
        pnl.add(pms);
        pnl.add(st);
        pnl.add(rp);
        pnl.add(lp);

        db.setVisible(true);
        pms.setVisible(false);
        st.setVisible(false);
        rp.setVisible(false);
        lp.setVisible(false);
       settanggal();
       setjam();
    }
    
    public final void settanggal()
    {
        Date buat_tgl           = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        tanggal.setText(String.valueOf(format.format(buat_tgl)));
    }
    
    public final void setjam()
    {
        ActionListener taskperformer = new ActionListener()
        {
            public void actionPerformed(ActionEvent awt)
            {
                String jamm =""; String menitt = ""; String detikk = ""; 
                Date buat_waktu = new Date();
                int jam         = buat_waktu.getHours();
                int menit       = buat_waktu.getMinutes();
                int detik       = buat_waktu.getSeconds();
                
                if(jam <= 9) jamm = "0";
                if(menit <=9) menitt ="0";
                if(detik <=9) detikk = "0";
                
                String a = jamm + Integer.toString(jam);
                String b = menitt + Integer.toString(menit);
                String c = detikk + Integer.toString(detik);
                    
                waktu.setText(a+":"+b+":"+c);
            }
        };
        new Timer(1000, taskperformer).start();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rekapitulasi = new javax.swing.JButton();
        pemesanan = new javax.swing.JButton();
        stok = new javax.swing.JButton();
        list_pesanan1 = new javax.swing.JButton();
        pnl = new javax.swing.JPanel();
        tanggal = new javax.swing.JTextField();
        waktu = new javax.swing.JTextField();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        rekapitulasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn/rekapitulasi.png"))); // NOI18N
        rekapitulasi.setBorder(null);
        rekapitulasi.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/btn/rekapitulasi1.png"))); // NOI18N
        rekapitulasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rekapitulasiActionPerformed(evt);
            }
        });
        getContentPane().add(rekapitulasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 397, 240, -1));

        pemesanan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn/pemesanan.png"))); // NOI18N
        pemesanan.setBorder(null);
        pemesanan.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/btn/pemesanan1.png"))); // NOI18N
        pemesanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pemesananMouseClicked(evt);
            }
        });
        getContentPane().add(pemesanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 103, 240, -1));

        stok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn/stok.png"))); // NOI18N
        stok.setBorder(null);
        stok.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/btn/stok1.png"))); // NOI18N
        stok.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stokMouseClicked(evt);
            }
        });
        getContentPane().add(stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 199, 240, -1));

        list_pesanan1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn/Riwayat pesanan.png"))); // NOI18N
        list_pesanan1.setBorder(null);
        list_pesanan1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/btn/Riwayat pesanan1.png"))); // NOI18N
        list_pesanan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list_pesanan1ActionPerformed(evt);
            }
        });
        getContentPane().add(list_pesanan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 298, 240, -1));

        pnl.setLayout(new javax.swing.BoxLayout(pnl, javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(pnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 101, 1090, 650));

        tanggal.setEditable(false);
        tanggal.setBackground(new java.awt.Color(74, 17, 5));
        tanggal.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        tanggal.setForeground(new java.awt.Color(255, 255, 255));
        tanggal.setBorder(null);
        getContentPane().add(tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 10, 130, 30));

        waktu.setEditable(false);
        waktu.setBackground(new java.awt.Color(74, 17, 5));
        waktu.setFont(new java.awt.Font("Berlin Sans FB", 0, 20)); // NOI18N
        waktu.setForeground(new java.awt.Color(255, 255, 255));
        waktu.setBorder(null);
        getContentPane().add(waktu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 50, 130, 30));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gmbr/Utama2.png"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pemesananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pemesananMouseClicked
         pms.setVisible(true);
         db.setVisible(false);
         st.setVisible(false);
         rp.setVisible(false);
        lp.setVisible(false);
    }//GEN-LAST:event_pemesananMouseClicked

    private void stokMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stokMouseClicked
        db.setVisible(false);
        pms.setVisible(false);
        st.setVisible(true); 
        rp.setVisible(false);
        lp.setVisible(false);
    }//GEN-LAST:event_stokMouseClicked

    private void list_pesanan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list_pesanan1ActionPerformed
        riwayat_pesanan.refresh.doClick();
        
        db.setVisible(false);
        pms.setVisible(false);
        st.setVisible(false); 
        rp.setVisible(true);
        lp.setVisible(false);
    }//GEN-LAST:event_list_pesanan1ActionPerformed

    private void rekapitulasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rekapitulasiActionPerformed
        db.setVisible(false);
        pms.setVisible(false);
        st.setVisible(false); 
        rp.setVisible(false);
        lp.setVisible(true);
    }//GEN-LAST:event_rekapitulasiActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
 
    }//GEN-LAST:event_formWindowOpened

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
    private javax.swing.JLabel Background;
    private javax.swing.JButton list_pesanan1;
    private javax.swing.JButton pemesanan;
    private javax.swing.JPanel pnl;
    private javax.swing.JButton rekapitulasi;
    private javax.swing.JButton stok;
    public static javax.swing.JTextField tanggal;
    public static javax.swing.JTextField waktu;
    // End of variables declaration//GEN-END:variables
}
