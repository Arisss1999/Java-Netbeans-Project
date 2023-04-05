import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.*;

public class pengembalian extends javax.swing.JPanel {

     Connection con;
    Statement stm;
    ResultSet rs;
    String sql,kembali,tgl;
    int dnd;
    
    public pengembalian() {
        initComponents();
        
        koneksi db = new koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
    }

    public void ambil_data()
    {
        try
        {
            sql = "select * from penyewaan inner join pelanggan using (id_pelanggan) inner join barang using (kd_barang) where kd_sewa = '"+kode.getText()+"' ";
            rs = stm.executeQuery(sql);
            if (rs.next())
            {
                nama.setText(rs.getString("nama_pelanggan"));
                alamat.setText(rs.getString("alamat"));
                telepon.setText(rs.getString("telepon"));
                kd_barang.setText(rs.getString("kd_barang"));
                denda.setText("");
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        telepon = new javax.swing.JTextField();
        tgl_sewa = new javax.swing.JTextField();
        kd_barang = new javax.swing.JTextField();
        kode = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        denda = new javax.swing.JLabel();
        cari = new javax.swing.JButton();
        tgl_kembali = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Nama");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Alamat");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Telepon");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Kode Barang");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 30, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Kode Sewa");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Tanggal Kembali");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Tanggal Sewa");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, -1, -1));

        nama.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        nama.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaActionPerformed(evt);
            }
        });
        add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 200, -1));

        telepon.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        telepon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(telepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 200, -1));

        tgl_sewa.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tgl_sewa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(tgl_sewa, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, 200, -1));

        kd_barang.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        kd_barang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(kd_barang, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 30, 200, -1));

        kode.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        kode.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(kode, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 130, -1));

        alamat.setColumns(20);
        alamat.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        alamat.setRows(5);
        alamat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(alamat);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, -1, 60));
        add(denda, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 160, 110, 20));

        cari.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cari.setText("Cari");
        cari.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });
        add(cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 60, 20));

        tgl_kembali.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tgl_kembaliPropertyChange(evt);
            }
        });
        tgl_kembali.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tgl_kembaliKeyReleased(evt);
            }
        });
        add(tgl_kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 90, 150, -1));

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, -1, -1));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Panel.png"))); // NOI18N
        add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1010, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        new data_penyewaan().setVisible(true);
    }//GEN-LAST:event_cariActionPerformed

    private void tgl_kembaliPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tgl_kembaliPropertyChange
        if (tgl_kembali.getDate() != null)
        {
                SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd");
                tgl_kembali.setDateFormatString("dd-MM-yyyy");
                kembali = String.valueOf(sdt.format(tgl_kembali.getDate()));
                tgl = kembali.substring(9,10);
                
        }
    }//GEN-LAST:event_tgl_kembaliPropertyChange

    private void tgl_kembaliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tgl_kembaliKeyReleased

    }//GEN-LAST:event_tgl_kembaliKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try
        {
            sql = "select * from penyewaan where kd_sewa = '"+kode.getText()+"' " ;
            rs = stm.executeQuery(sql);
            if (rs.next())
            {
                if (kembali != rs.getString("tgl_kembali"))
                {
                    
                    String tg = rs.getString("tgl_kembali").substring(9,10);
                    dnd = (Integer.parseInt(tgl) - Integer.parseInt(tg)) * 10000;
                    if(dnd >= 0)
                    {
                        new pelunasan().setVisible(true);
                        pelunasan.denda.setText("Rp."+dnd);
                        int ttl = rs.getInt("ttl_harga") - rs.getInt("uang_muka") + dnd;
                        pelunasan.total.setText("Rp."+ttl);
                                           
                    }
                    else
                    {
                        dnd = 0;
                        new pelunasan().setVisible(true);
                        pelunasan.denda.setText("Rp."+dnd);
                        int ttl = rs.getInt("ttl_harga") - rs.getInt("uang_muka") + dnd;
                        pelunasan.total.setText("Rp."+ttl);
                    }
                }
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        try
        {
            sql = "insert into pengembalian (kd_sewa, keterangan, tgl_kembali) values ('"+kode.getText()+"', '"+"lunas"+"' ,'"+kembali+"') ";
            stm.executeUpdate(sql);
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    public static javax.swing.JTextArea alamat;
    private javax.swing.JButton cari;
    private javax.swing.JLabel denda;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField kd_barang;
    public static javax.swing.JTextField kode;
    public static javax.swing.JTextField nama;
    public static javax.swing.JTextField telepon;
    private com.toedter.calendar.JDateChooser tgl_kembali;
    public static javax.swing.JTextField tgl_sewa;
    // End of variables declaration//GEN-END:variables
}
