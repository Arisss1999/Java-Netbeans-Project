import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.*;

public class data_penyewaan extends javax.swing.JFrame {
    Connection con;
    Statement stm;
    ResultSet rs;
    String sql;
    
    DefaultTableModel model;
    TableColumn kolom;
    
    public data_penyewaan() {
        initComponents();
        koneksi db = new koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
        
        String []th = {"No","Kode Sewa","Nama Pelanggan","Nama Barang","Total Sewa", "Tanggal"};
        model = new DefaultTableModel(th, 0);
        tabel.setModel(model);
        
        tampil();
    }
    public void ambil_data()
    {
        try
        {
            sql = "select * from penyewaan inner join pelanggan using (id_pelanggan) inner join barang using (kd_barang) where kd_sewa = '"+pengembalian.kode.getText()+"' ";
            rs = stm.executeQuery(sql);
            if (rs.next())
            {
                pengembalian.nama.setText(rs.getString("nama_pelanggan"));
                pengembalian.alamat.setText(rs.getString("alamat"));
                pengembalian.telepon.setText(rs.getString("telepon"));
                pengembalian.kd_barang.setText(rs.getString("kd_barang"));
                pengembalian.tgl_sewa.setText(rs.getString("tgl_sewa"));
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
     public void tampil()
    {
        int row = tabel.getRowCount();
        for (int a=0; a<row; a++)
        {
            model.removeRow(0);
        }
        try
        {
            int no=1;
            sql = "select * from penyewaan inner join pelanggan using (id_pelanggan) inner join barang using (kd_barang)";
            rs  = stm.executeQuery(sql);
            while(rs.next())
            {
                model.addRow(new Object[]
                {
                    no++,
                    rs.getString("kd_sewa"),
                    rs.getString("nama_pelanggan"), 
                    rs.getString("nama_barang"),
                    rs.getString("ttl_sewa")+" Unit",
                    rs.getString("tgl_sewa")+" s/d "+rs.getString("tgl_kembali"),
                    
                });
            }
        }
        
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "2"+e.getMessage());
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        kode = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 220));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button action/pilih.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button action/pilih1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, -1, -1));
        getContentPane().add(kode, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 80, 20));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        int i = tabel.getSelectedRow();
        pengembalian.kode.setText(model.getValueAt(i, 1).toString());
    }//GEN-LAST:event_tabelMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ambil_data();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(data_penyewaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(data_penyewaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(data_penyewaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(data_penyewaan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new data_penyewaan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel kode;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}
