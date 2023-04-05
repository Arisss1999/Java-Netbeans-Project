import java.io.File;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;


public class kematian extends javax.swing.JPanel {

     Connection con;
    Statement stm;
    ResultSet rs;
    String sql;
    
    DefaultTableModel model;
    TableColumn kolom;
    
    public kematian() {
        initComponents();
              
        koneksi db = new koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
        
        String []th = {"No","No Kematian","Tanggal Surat","No KK","NIK","Nama Lengkap","Jenis Kelamin","Tempat Lahir","Tanggal Lahir","Alamat" ,"Kewarganegaraan" ,"Tanggal Kematian","Agama","Status","Pekerjaan","Hubungan Keluarga","Tempat Kematian","Nama Pelapor"};
        model = new DefaultTableModel(th, 0);
        
        tabel.setModel(model);
        tampil_data();
    }

    public void ambil_data()
    {
        
        try
        {
            sql = " select * from kematian where no_kematian = '"+tes.getText()+"' ";
            rs = stm.executeQuery(sql);
            while (rs.next())
            {
                data_kematian.no_surat.setText(tes.getText());
                data_kematian.tgl_surat.setText(rs.getString("tgl_surat"));
                data_kematian.no_kk.setText(rs.getString("no_kk"));
                data_kematian.nik.setText(rs.getString("nik"));
                data_kematian.nama.setText(rs.getString("nama"));
               data_kematian.tempat_lahir.setText(rs.getString("tempat_lahir"));
                java.util.Date  date_lahir = new SimpleDateFormat("dd-MM-yyyy").parse((String)rs.getString("tgl_lahir"));
                    data_kematian.tgl_lahir.setDate(date_lahir);
                    
                java.util.Date date_mati = new SimpleDateFormat("dd-MM-yyyy").parse((String)rs.getString("tgl_kematian"));
                    data_kematian.tgl_mati.setDate(date_mati);
                data_kematian.agama.setText(rs.getString("agama"));
                data_kematian.status.setText(rs.getString("status"));
                data_kematian.pekerjaan.setText(rs.getString("pekerjaan"));
                data_kematian.tempat_mati.setText(rs.getString("tempat_kematian"));
                data_kematian.nama_pelapor.setText(rs.getString("nama_pelapor"));
                data_kematian.hub_keluarga.setText(rs.getString("hub_keluarga"));
                
                data_kematian.alamat.setText(rs.getString("alamat"));
                data_kematian.kewarganegaraan.setText(rs.getString("kewarganegaraan"));
                 if (rs.getString("kelamin").equals ("Laki - Laki"))
                {
                    data_kematian.laki.setSelected(true);
                    data_kematian.perempuan.setSelected(false);
                }
                else if (rs.getString("kelamin").equals("Perempuan"))
                {
                    data_kematian.laki.setSelected(false);
                    data_kematian.perempuan.setSelected(true);
                    
                }
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
     public void tampil_data()
    {
        int row = tabel.getRowCount();
        
        for (int a=0; a<row; a++)
        {
            model.removeRow(0);
        }
         try
        {
            int no=1;
           
            sql = "select * from kematian order by no_kematian asc";
            rs  = stm.executeQuery(sql);
            while(rs.next())
            {
                model.addRow(new Object[]
                {
                    no++,
                    rs.getString("no_kematian"),
                    rs.getString("tgl_surat"),
                    rs.getString("no_kk"),
                    rs.getString("nik"),
                    rs.getString("nama"),
                    rs.getString("kelamin"),
                    rs.getString("tempat_lahir"),
                    rs.getString("tgl_lahir"),
                    rs.getString("alamat"),
                    rs.getString("kewarganegaraan"),
                    rs.getString("tgl_kematian"),
                    rs.getString("agama"),
                    rs.getString("status"),
                    rs.getString("pekerjaan"),
                    rs.getString("hub_keluarga"),
                    rs.getString("tempat_kematian"),
                    rs.getString("nama_pelapor")
                    
                    
                });
            }
        }
        
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        hapus = new javax.swing.JButton();
        tambah = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        cetak = new javax.swing.JButton();
        background = new javax.swing.JLabel();
        tes = new javax.swing.JTextField();
        refresh = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1230, -1));

        hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/hapus Data.png"))); // NOI18N
        hapus.setBorder(null);
        hapus.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/hapus Data1.png"))); // NOI18N
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });
        add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 460, -1, -1));

        tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Tambah Data.png"))); // NOI18N
        tambah.setBorder(null);
        tambah.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Tambah Data1.png"))); // NOI18N
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });
        add(tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, -1, -1));

        ubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Ubah Data.png"))); // NOI18N
        ubah.setBorder(null);
        ubah.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Ubah Data1.png"))); // NOI18N
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });
        add(ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 460, -1, -1));

        cetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/print.png"))); // NOI18N
        cetak.setBorder(null);
        cetak.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/print1.png"))); // NOI18N
        cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakActionPerformed(evt);
            }
        });
        add(cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 460, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/panel.png"))); // NOI18N
        add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        add(tes, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 500, 140, -1));

        refresh.setBorder(null);
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 500, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
       new data_kematian().setVisible(true);
       data_kematian.ubah.setVisible(false);
       data_kematian.simpan.setVisible(true);
    }//GEN-LAST:event_tambahActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        int i = tabel.getSelectedRow();
        tes.setText(model.getValueAt(i, 1).toString());
        
    }//GEN-LAST:event_tabelMouseClicked

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        if (tes.getText().equals (""))
        {
            JOptionPane.showMessageDialog(this, "Pilih Data yang Ingin DiUbah");
        }
        else
        {
            
        
            new data_kematian().setVisible(true);
            ambil_data();
            data_kematian.simpan.setVisible(false);
            data_kematian.ubah.setVisible(true);
        }
    }//GEN-LAST:event_ubahActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
       tampil_data();
    }//GEN-LAST:event_refreshActionPerformed

    private void cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakActionPerformed
        try
            {
                File file       = new File("src/Report/kematian.jasper");
                JasperPrint jp  = JasperFillManager.fillReport(file.getPath(),null, con);
                JasperViewer.viewReport(jp, false);
            }
        
            catch (JRException e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
    }//GEN-LAST:event_cetakActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        if (tes.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin diHapus");
        }
        else
        {
            try
            {
                sql = "delete from kematian where no_kematian = '"+tes.getText()+"' ";  
                stm.executeUpdate(sql);
                JOptionPane.showMessageDialog(this,"Data Berhasil Di Hapus","Information",JOptionPane.INFORMATION_MESSAGE);
                
                    tampil_data();
            }
             catch (Exception e)
            {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_hapusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton cetak;
    private javax.swing.JButton hapus;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JButton refresh;
    private javax.swing.JTable tabel;
    private javax.swing.JButton tambah;
    private javax.swing.JTextField tes;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
