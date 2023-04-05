import java.io.File;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

public class kelahiran extends javax.swing.JPanel {

    Connection con;
    Statement stm;
    ResultSet rs;
    String sql;
    
    DefaultTableModel model;
    TableColumn kolom;
    
    
    public kelahiran() {
        initComponents();
        koneksi db = new koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
        
        String []th = {"No","No surat", "Tanggal Surat", "Nama Anak" , "Tanggal Lahir", "Jam Lahir", "Jenis Kelamin", "Agama", "Anak Ke", "Nama Kepala Keluarga", "NIK", "Nama Ibu", "Tanggal Lahir", "Tempat Lahir", "Pekerjaan", "Alamat", "No KK", "Hubungan Keluarga"};
        model = new DefaultTableModel(th, 0);
        
        tabel.setModel(model);
        tampil_data();
    }
 
    private void ambil_data() {
        try
        {
            sql = "select * from kelahiran where no_surat = '"+tes.getText()+"' ";
            rs = stm.executeQuery(sql);
            while (rs.next())
            {
            data_kelahiran.no_surat.setText(rs.getString("no_surat"));
            data_kelahiran.tgl_surat.setText(rs.getString("tgl_surat"));
            data_kelahiran.jam_lahir.setText(rs.getString("jam_lahir"));
            data_kelahiran.anak_ke.setText(rs.getString("anak_ke"));
            data_kelahiran.nama_anak.setText(rs.getString("nama_anak"));
            data_kelahiran.nama_kepala.setText(rs.getString("nama_kepala"));
            data_kelahiran.nik.setText(rs.getString("nik"));
            data_kelahiran.nama_ibu.setText(rs.getString("nama_ibu"));
            data_kelahiran.tempat_lahir.setText(rs.getString("tempat_lahir"));
            data_kelahiran.pekerjaan.setText(rs.getString("pekerjaan"));
            data_kelahiran.alamat.setText(rs.getString("alamat"));
            data_kelahiran.hub_keluarga.setText(rs.getString("hub_keluarga"));
            data_kelahiran.agama.setText(rs.getString("agama"));
            data_kelahiran.no_kk.setText(rs.getString("no_kk"));
            if (rs.getString("kelamin").equals("Perempuan"))
            {
                data_kelahiran.laki.setSelected(false);
                data_kelahiran.perempuan.setSelected(true);
                
            }
            else
            {
                data_kelahiran.laki.setSelected(true);
                data_kelahiran.perempuan.setSelected(false);
                
            }
            java.util.Date da = new SimpleDateFormat("dd-MM-yyyy").parse((String)rs.getString("tgl_lahir_anak"));
                    data_kelahiran.tgl_anak.setDate(da);
            java.util.Date di = new SimpleDateFormat("dd-MM-yyyy").parse((String)rs.getString("tgl_lahir_ibu"));
                    data_kelahiran.tgl_lahir.setDate(di);
           
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
           
            sql = "select * from kelahiran order by no_surat asc";
            rs  = stm.executeQuery(sql);
            while(rs.next())
            {
                model.addRow(new Object[]
                {
                    no++,
                    rs.getString("no_surat"),
                    rs.getString("tgl_surat"),
                    rs.getString("nama_anak"),
                    rs.getString("tgl_lahir_anak"),
                    rs.getString("jam_lahir"),
                    rs.getString("kelamin"),
                    rs.getString("agama"),
                    rs.getString("anak_ke"),
                    rs.getString("nama_kepala"),
                    rs.getString("nik"),
                    rs.getString("nama_ibu"),
                    rs.getString("tgl_lahir_ibu"),
                    rs.getString("tempat_lahir"),
                    rs.getString("pekerjaan"),
                    rs.getString("alamat"),
                    rs.getString("no_kk"),
                    rs.getString("hub_keluarga")
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

        tambah = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        background = new javax.swing.JLabel();
        tes = new javax.swing.JTextField();
        refresh = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Tambah Data.png"))); // NOI18N
        tambah.setBorder(null);
        tambah.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Tambah Data1.png"))); // NOI18N
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });
        add(tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, -1));

        ubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Ubah Data.png"))); // NOI18N
        ubah.setBorder(null);
        ubah.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Ubah Data1.png"))); // NOI18N
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });
        add(ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 450, -1, -1));

        hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/hapus Data.png"))); // NOI18N
        hapus.setBorder(null);
        hapus.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/hapus Data1.png"))); // NOI18N
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });
        add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 450, -1, -1));

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
        jScrollPane2.setViewportView(tabel);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1260, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/print.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/print1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 450, -1, -1));

        background.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/panel.png"))); // NOI18N
        add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        add(tes, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 460, 130, -1));

        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 480, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        if (tes.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Pilih data yang ingin diHapus");
        }
        else
        {
            try
            {
                sql = "delete from kelahiran where no_surat = '"+tes.getText()+"' ";  
                stm.executeUpdate(sql);
                JOptionPane.showMessageDialog(this,"Data Berhasil Di Hapus","Information",JOptionPane.INFORMATION_MESSAGE);
                
                    tampil_data();
            }
             catch (Exception e)
            {
            
            }
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        new data_kelahiran().setVisible(true);
        data_kelahiran.simpan.setVisible(true);
        data_kelahiran.ubah.setVisible(false);
    }//GEN-LAST:event_tambahActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        int i = tabel.getSelectedRow();
        tes.setText(model.getValueAt(i, 1).toString());
    }//GEN-LAST:event_tabelMouseClicked

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        tampil_data();
    }//GEN-LAST:event_refreshActionPerformed

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        if (tes.getText().equals (""))    
        {
             JOptionPane.showMessageDialog(this, "Pilih Data Yang ingin Di Ubah ! ","Information",JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
           
            new data_kelahiran().setVisible(true);
            ambil_data();
            data_kelahiran.ubah.setVisible(true);
            data_kelahiran.simpan.setVisible(false);
        }
    }//GEN-LAST:event_ubahActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try
            {
                File file       = new File("src/Report/kelahiran.jasper");
                JasperPrint jp  = JasperFillManager.fillReport(file.getPath(),null, con);
                JasperViewer.viewReport(jp, false);
            }
        
            catch (JRException e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton hapus;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JButton refresh;
    private javax.swing.JTable tabel;
    private javax.swing.JButton tambah;
    public static javax.swing.JTextField tes;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
