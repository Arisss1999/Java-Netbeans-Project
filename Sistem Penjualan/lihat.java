import java.io.File;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.*;

public class lihat extends javax.swing.JFrame {

    Connection con;
    Statement stm;
    ResultSet rs;
    String sql;
    
    DefaultTableModel model;
    TableColumn kolom;
    public lihat() {
        initComponents();
        koneksi db = new koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
        
        String []th = {"No","Kode Produk","Nama Produk","Sub","Harga"};
        model = new DefaultTableModel(th, 0);
        tabel.setModel(model);
        
        tampilkan();
    }
     public void tampilkan()
    {
        int row = tabel.getRowCount();
        for (int a=0; a<row; a++)
        {
            model.removeRow(0);
        }
        try
        {
            int no=1;
            sql = "select * from penjualan inner join produk using (kd_produk) where kd_pembelian = '"+riwayat_pesanan.kode.getText()+"'";
            rs  = stm.executeQuery(sql);
            while(rs.next())
            {
                model.addRow(new Object[]
                {
                    no++,
                    rs.getString("kd_produk"),
                    rs.getString("nama_produk"),
                    rs.getString("sub"),
                    rs.getString("total")
                });
            }
        }
        
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage()+"Kontol");
        }
    }
     
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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
        jScrollPane1.setViewportView(tabel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(lihat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lihat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lihat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lihat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lihat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}
