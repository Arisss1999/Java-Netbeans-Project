import java.io.File;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;



public class penduduk extends javax.swing.JPanel {

    Connection con;
    Statement stm;
    ResultSet rs;
    String sql;
    
    DefaultTableModel model;
    TableColumn kolom;
    
    
            
    public penduduk() {
        initComponents();
        
        koneksi db = new koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
        
        String []th = {"No","No KK","NIK","Nama Lengkap","Jenis Kelamin","Tempat Lahir","Tanggal Lahir", "Golongan Darah","Agama","Pendidikan","Pekerjaan","Nama Ibu","Nama Ayah","Hubungan Keluarga","Kewarganegaraan","Status","Alamat","Kode Pos"};
        model = new DefaultTableModel(th, 0);
        
        tabel_anggota.setModel(model);
        tampil_data();
    }


    public void ambil_data()
    {
        try
        {
            sql = "select * from identitas_penduduk where nik = '"+nik.getText()+"'";
            rs  = stm.executeQuery(sql);
            while(rs.next())
            {
                    data_penduduk.no_kk.setText(rs.getString("no_kk"));
                    data_penduduk.nik.setText(rs.getString("nik"));
                    data_penduduk.nama.setText( rs.getString("nama"));
                    data_penduduk.tempat_lahir.setText(rs.getString("tempat_lahir"));
                    data_penduduk.agama.setText(rs.getString("agama"));
                    data_penduduk.pendidikan.setText(rs.getString("pendidikan"));
                    data_penduduk.pekerjaan.setText(rs.getString("pekerjaan"));
                    data_penduduk.nama_ibu.setText(rs.getString("nama_ibu"));
                    data_penduduk.nama_ayah.setText(rs.getString("nama_ayah"));
                    data_penduduk.hubungan_keluarga.setText(rs.getString("hubungan_keluarga"));
                    data_penduduk.negara.setText(rs.getString("kewarganegaraan"));
                    data_penduduk.status.setText(rs.getString("status"));
                    data_penduduk.kode_pos.setText(rs.getString("kode_pos"));
                    data_penduduk.alamat.setText(rs.getString("alamat"));
                    data_penduduk.darah.setSelectedItem(rs.getString("gol_darah"));
                    java.util.Date ini_tanggal = new SimpleDateFormat("dd-MM-yyyy").parse((String)rs.getString("tanggal_lahir"));
                    data_penduduk.tgl_lahir.setDate(ini_tanggal);
                    if(rs.getString("kelamin").equals ("Laki-Laki"))
                    {
                        data_penduduk.laki.setSelected(true);
                        data_penduduk.perempuan.setSelected(false);
                    }
        
                    else
                    {
                        data_penduduk.perempuan.setSelected(true);
                        data_penduduk.laki.setSelected(false);
                    }
            }
        }
        
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage() );
        }
    }
    
    public void tampil_data()
    {
        int row = tabel_anggota.getRowCount();
        
        for (int a=0; a<row; a++)
        {
            model.removeRow(0);
        }
         try
        {
            int no=1;
           
            sql = "select * from identitas_penduduk ";
            rs  = stm.executeQuery(sql);
            while(rs.next())
            {
                model.addRow(new Object[]
                {
                    no++,
                    rs.getString("no_kk"),
                    rs.getString("nik"),
                    rs.getString("nama"),
                    rs.getString("kelamin"),
                    rs.getString("tempat_lahir"),
                    rs.getString("tanggal_lahir"),
                    rs.getString("gol_darah"),
                    rs.getString("agama"),
                    rs.getString("pendidikan"),
                    rs.getString("pekerjaan"),
                    rs.getString("nama_ibu"),
                    rs.getString("nama_ayah"),
                    rs.getString("hubungan_keluarga"),
                    rs.getString("kewarganegaraan"),
                    rs.getString("status"),
                    rs.getString("alamat"),
                    rs.getString("kode_pos")
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

        tambah_anggota = new javax.swing.JButton();
        ubah_data = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_anggota = new javax.swing.JTable();
        cetak = new javax.swing.JButton();
        background = new javax.swing.JLabel();
        nik = new javax.swing.JTextField();
        refresh = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tambah_anggota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Tambah Data.png"))); // NOI18N
        tambah_anggota.setBorder(null);
        tambah_anggota.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Tambah Data1.png"))); // NOI18N
        tambah_anggota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambah_anggotaActionPerformed(evt);
            }
        });
        add(tambah_anggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        ubah_data.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Ubah Data.png"))); // NOI18N
        ubah_data.setBorder(null);
        ubah_data.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Ubah Data1.png"))); // NOI18N
        ubah_data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubah_dataActionPerformed(evt);
            }
        });
        add(ubah_data, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, -1, -1));

        hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/hapus Data.png"))); // NOI18N
        hapus.setBorder(null);
        hapus.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/hapus Data1.png"))); // NOI18N
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });
        add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 320, -1, -1));

        tabel_anggota.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_anggota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_anggotaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_anggota);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1270, 290));

        cetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/print.png"))); // NOI18N
        cetak.setBorder(null);
        cetak.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/print1.png"))); // NOI18N
        cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakActionPerformed(evt);
            }
        });
        add(cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 320, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/panel.png"))); // NOI18N
        add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        nik.setText("tes");
        add(nik, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 10, 10));
    }// </editor-fold>//GEN-END:initComponents

    private void tambah_anggotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambah_anggotaActionPerformed
        new data_penduduk().setVisible(true);
    }//GEN-LAST:event_tambah_anggotaActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        if(nik.getText().equals (""))
        {
            JOptionPane.showMessageDialog(this, "Pilih Data Yang ingin diHapus.");
        }
        else
        {
            try
            {
                sql = "delete from identitas_penduduk where nik = '"+nik.getText()+"' "; 
                stm.executeUpdate(sql);
                
                
                    JOptionPane.showMessageDialog(this,"Data Berhasil Di Hapus","Information",JOptionPane.INFORMATION_MESSAGE);
                
                    tampil_data();
                
            }

            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void ubah_dataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubah_dataActionPerformed
        if (nik.getText().equals ("tes"))    
        {
             JOptionPane.showMessageDialog(this, "Pilih Data Yang ingin Di Ubah ! ","Information",JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
            new data_penduduk().setVisible(true);
            ambil_data();
            data_penduduk.ubah.setVerifyInputWhenFocusTarget(true);
            data_penduduk.simpan.setVisible(false);
        }
        
    }//GEN-LAST:event_ubah_dataActionPerformed

    private void tabel_anggotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_anggotaMouseClicked
        int i = tabel_anggota.getSelectedRow();
        nik.setText(model.getValueAt(i, 2).toString());
    }//GEN-LAST:event_tabel_anggotaMouseClicked

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        tampil_data();
    }//GEN-LAST:event_refreshActionPerformed

    private void cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakActionPerformed
        try
            {
                File file       = new File("src/Report/penduduk.jasper");
                JasperPrint jp  = JasperFillManager.fillReport(file.getPath(),null, con);
                JasperViewer.viewReport(jp, false);
            }
        
            catch (JRException e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
    }//GEN-LAST:event_cetakActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton cetak;
    public static javax.swing.JButton hapus;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField nik;
    public static javax.swing.JButton refresh;
    private javax.swing.JTable tabel_anggota;
    private javax.swing.JButton tambah_anggota;
    private javax.swing.JButton ubah_data;
    // End of variables declaration//GEN-END:variables
}
