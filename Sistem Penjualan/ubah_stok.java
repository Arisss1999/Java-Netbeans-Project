
import javax.swing.JOptionPane;
import java.sql.*;

public class ubah_stok extends javax.swing.JFrame {

    Connection con;
    Statement stm;
    ResultSet rs;
    String sql;
   
    
    public ubah_stok() {
        initComponents();
        koneksi db = new koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
        stok();
        
        stok_produk.setEditable(false);
    }

    public void stok()
    {
        try
        {
            sql = "select * from produk where kd_produk = '"+stok.tes.getText()+"'";
            rs  = stm.executeQuery(sql);
            
            while(rs.next())
            {
                nama_produk.setText(rs.getString("nama_produk"));
                stok_produk.setText(rs.getString("stok_produk"));
                harga.setText(rs.getString("harga_produk"));
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        simpan = new javax.swing.JButton();
        batal = new javax.swing.JButton();
        nama_produk = new javax.swing.JTextField();
        stok_produk = new javax.swing.JTextField();
        harga = new javax.swing.JTextField();
        kode_produk = new javax.swing.JTextField();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn/simpan.png"))); // NOI18N
        simpan.setBorder(null);
        simpan.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/btn/simpan1.png"))); // NOI18N
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });
        getContentPane().add(simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn/batal.png"))); // NOI18N
        batal.setBorder(null);
        batal.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/btn/batal1.png"))); // NOI18N
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });
        getContentPane().add(batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 360, -1, -1));

        nama_produk.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        nama_produk.setBorder(null);
        getContentPane().add(nama_produk, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 178, 160, 30));

        stok_produk.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        stok_produk.setBorder(null);
        getContentPane().add(stok_produk, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 223, 160, 30));

        harga.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        harga.setBorder(null);
        getContentPane().add(harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 274, 160, 30));

        kode_produk.setEditable(false);
        kode_produk.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        kode_produk.setBorder(null);
        kode_produk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kode_produkActionPerformed(evt);
            }
        });
        getContentPane().add(kode_produk, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 160, 30));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gmbr/ubah_stok.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void kode_produkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kode_produkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kode_produkActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        kode_produk.setText("");
        nama_produk.setText("");
        stok_produk.setText("");
        harga.setText("");
        
        this.dispose();
    }//GEN-LAST:event_batalActionPerformed
    
    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        try
            {
                sql = "update produk set  nama_produk = '"+nama_produk.getText()+"', stok_produk = '"+stok_produk.getText()+"', harga_produk ='"+Integer.parseInt(harga.getText())+"'where kd_produk = '"+kode_produk.getText()+"'";
                stm.executeUpdate(sql);
                JOptionPane.showMessageDialog(this,"Data Berhasil Diubah","Information",JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            }
    
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }    
        stok.refresh.doClick();
    }//GEN-LAST:event_simpanActionPerformed

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
            java.util.logging.Logger.getLogger(ubah_stok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ubah_stok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ubah_stok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ubah_stok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ubah_stok().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton batal;
    private javax.swing.JTextField harga;
    public static javax.swing.JTextField kode_produk;
    private javax.swing.JTextField nama_produk;
    private javax.swing.JButton simpan;
    private javax.swing.JTextField stok_produk;
    // End of variables declaration//GEN-END:variables
}
