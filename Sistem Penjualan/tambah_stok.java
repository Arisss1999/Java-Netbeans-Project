
import java.io.File;
import javax.swing.JOptionPane;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class tambah_stok extends javax.swing.JFrame {

    Connection con;
    Statement stm;
    ResultSet rs;
    String sql, sqll, kode;
    
    public tambah_stok() {
        initComponents();
        
        koneksi db = new koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
       
        buat_kode();
        kode_transaksi();
    }
    
    
    private void kode_transaksi()
    {
        try
        {
            sql = "select * from pembelian order by kd_transaksi desc";
            rs  = stm.executeQuery(sql);
            if(rs.next())
            {
                String a = rs.getString("kd_transaksi").substring(1);
                String b = "" + (Integer.parseInt(a) + 1);
                String c = "";
                
                
                if( b.length()== 1 )
                {
                    c = "00";
                }
                else if( b.length()== 2 )
                {
                    c = "0";
                }
                else if( b.length()== 3 )
                {
                    c ="";
                }
                kd_transaksi.setText("T" + c + b);
            }
            
            else
            {
                kd_transaksi.setText("T001");
            }
        }
        
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
  private void cetak()
  {
      try
           {
                File file       = new File("src/Laporan/produk.jasper");
                HashMap parameter = new HashMap();
                parameter.put("kd_transaksi",kd_transaksi.getText());
                JasperPrint jp  = JasperFillManager.fillReport(file.getPath(),parameter, con);
                JasperViewer.viewReport(jp, false); 
           }
           catch (Exception e)
           {
               JOptionPane.showMessageDialog(null, e.getMessage());
           }
  }
   private void buat_kode()
    {
        try
        {
            sql = "select * from produk order by kd_produk desc";
            rs  = stm.executeQuery(sql);
            if(rs.next())
            {
                String a = rs.getString("kd_produk").substring(3);
                String b = "" + (Integer.parseInt(a) + 1);
                String c = "";
                
                
                if( b.length()== 1 )
                {
                    c = "00";
                }
                else if( b.length()== 2 )
                {
                    c = "0";
                }
                else if( b.length()== 3 )
                {
                    c ="";
                }
                kode = "BKP" + c + b;
                kode_produk.setText("BKP" + c + b);
            }
            
            else
            {
                kode_produk.setText("BKP001");
            }
        }
        
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
   public void produk()
   {
       try
            {
                sql = "insert into produk (kd_produk, nama_produk, stok_produk, harga_produk) values ('"+kode_produk.getText()+"', '"+nama_produk.getText()+"', '"+Integer.parseInt(stokk.getText())+"','"+0+"' )";
                stm.executeUpdate(sql);   
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            
            try
            {
                String input_harga = JOptionPane.showInputDialog("Input Harga Jual");
                
                sql = "update produk set harga_produk = '"+Integer.parseInt(input_harga)+"' where kd_produk = '"+kode_produk.getText()+"' ";
                stm.executeUpdate(sql);
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        simpan = new javax.swing.JButton();
        batal = new javax.swing.JButton();
        nama_produk = new javax.swing.JTextField();
        stokk = new javax.swing.JTextField();
        supplier = new javax.swing.JTextField();
        telepon = new javax.swing.JTextField();
        harga = new javax.swing.JTextField();
        kode_produk = new javax.swing.JTextField();
        background = new javax.swing.JLabel();
        kd_transaksi = new javax.swing.JLabel();

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
        getContentPane().add(simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn/batal.png"))); // NOI18N
        batal.setBorder(null);
        batal.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/btn/batal1.png"))); // NOI18N
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });
        getContentPane().add(batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 440, -1, -1));

        nama_produk.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        nama_produk.setBorder(null);
        getContentPane().add(nama_produk, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 150, 20));

        stokk.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        stokk.setBorder(null);
        getContentPane().add(stokk, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 150, 20));

        supplier.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        supplier.setBorder(null);
        getContentPane().add(supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 285, 150, 20));

        telepon.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        telepon.setBorder(null);
        getContentPane().add(telepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 332, 150, 20));

        harga.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        harga.setBorder(null);
        getContentPane().add(harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 237, 150, 20));

        kode_produk.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        kode_produk.setBorder(null);
        kode_produk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kode_produkActionPerformed(evt);
            }
        });
        getContentPane().add(kode_produk, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 94, 150, 20));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gmbr/barang masuk.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        kd_transaksi.setText("jLabel1");
        getContentPane().add(kd_transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 380, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        this.dispose();
    }//GEN-LAST:event_batalActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        java.util.Date buat_tgl = new java.util.Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal = (String.valueOf(format.format(buat_tgl)));
        
        if (stok.tes.getText().equals(kode_produk.getText()))
        {
            try
            {
                sql = "insert into pembelian (tanggal, kd_produk, stok, supplier, telepon, harga, kd_transaksi) values ('"+tanggal+"', '"+kode_produk.getText()+"', '"+Integer.parseInt(stokk.getText())+"', '"+supplier.getText()+"', '"+telepon.getText()+"', '"+Integer.parseInt(harga.getText())+"', '"+kd_transaksi.getText()+"')";
                stm.executeUpdate(sql);
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "gagal insert pembelian");
            }
             try
            {
              sql = "update produk set stok_produk = stok_produk + '"+Integer.parseInt(stokk.getText())+"' where kd_produk = '"+kode_produk.getText()+"' ";   
              stm.executeUpdate(sql);
              JOptionPane.showMessageDialog(null, "Stok Berhasil Ditambah");
            
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, "gagal update produk");
            }
        }
        
        else 
        {
            
            try
            {
                sql = "insert into pembelian (tanggal, kd_produk, stok, supplier, telepon, harga, kd_transaksi) values ('"+tanggal+"', '"+kode_produk.getText()+"', '"+Integer.parseInt(stokk.getText())+"', '"+supplier.getText()+"', '"+telepon.getText()+"', '"+Integer.parseInt(harga.getText())+"', '"+kd_transaksi.getText()+"')";
                stm.executeUpdate(sql);
            }
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            produk();
        }
        
        cetak();
        kode_transaksi();
        stok.refresh.doClick();
        this.dispose();
    }//GEN-LAST:event_simpanActionPerformed

    private void kode_produkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kode_produkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kode_produkActionPerformed

   
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
            java.util.logging.Logger.getLogger(tambah_stok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tambah_stok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tambah_stok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tambah_stok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tambah_stok().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton batal;
    public static javax.swing.JTextField harga;
    private javax.swing.JLabel kd_transaksi;
    public static javax.swing.JTextField kode_produk;
    public static javax.swing.JTextField nama_produk;
    private javax.swing.JButton simpan;
    public static javax.swing.JTextField stokk;
    public static javax.swing.JTextField supplier;
    public static javax.swing.JTextField telepon;
    // End of variables declaration//GEN-END:variables
}
