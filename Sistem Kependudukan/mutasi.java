
import java.io.File;
import javax.swing.JOptionPane;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


public class mutasi extends javax.swing.JPanel {

    Connection con;
    Statement stm;
    ResultSet rs;
    String sql;
    
    DefaultTableModel model;
    TableColumn kolom;
    
    public mutasi() {
        initComponents();
        
        koneksi db = new koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
        
        String []th = {"No","No Surat","Tanggal Surat","NIK","No KK","Nama Lengkap","Tempat Lahir","Tanggal Lahir","Jenis Kelamin","Kewarganegaraan","Agama","Status","Pekerjaan","Alamat Asal","Alamat Tujuan"};
        model = new DefaultTableModel(th, 0);
        
        tabel.setModel(model);
        
        tampil_data();
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
           
            sql = "select * from mutasi";
            rs  = stm.executeQuery(sql);
            while(rs.next())
            {
                model.addRow(new Object[]
                {
                    no++,
                    rs.getString("no_surat"),
                    rs.getString("tgl_surat"),
                    rs.getString("nik"),
                    rs.getString("no_kk"),
                    rs.getString("nama"),
                    rs.getString("tempat_lahir"),
                    rs.getString("tgl_lahir"),
                    rs.getString("kelamin"),
                    rs.getString("kewarganegaraan"),
                    rs.getString("agama"),
                    rs.getString("status"),
                    rs.getString("pekerjaan"),
                    rs.getString("alamat_asal"),
                    rs.getString("alamat_tujuan")
                });
                }
        }
        
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this,"tabel bermasalah");
        }
    }
     
     public void ambil_data()
    {
        
        try
        {
            sql = "select * from mutasi where no_surat = '"+tes.getText()+"' ";
            rs = stm.executeQuery(sql);
            while (rs.next())
            {
                data_mutasi.no_surat.setText(tes.getText());
                data_mutasi.tgl_surat.setText(rs.getString("tgl_surat"));
                data_mutasi.nik.setText(rs.getString("nik"));
                data_mutasi.no_kk.setText(rs.getString("no_kk"));
                data_mutasi.nama.setText(rs.getString("nama"));
                data_mutasi.tempat_lahir.setText(rs.getString("tempat_lahir"));
                java.util.Date  date_lahir = new SimpleDateFormat("dd-MM-yyyy").parse((String)rs.getString("tgl_lahir"));
                    data_mutasi.tgl_lahir.setDate(date_lahir);
                data_mutasi.kewarganegaraan.setText(rs.getString("kewarganegaraan"));
                data_mutasi.agama.setText(rs.getString("agama"));
                data_mutasi.status.setText(rs.getString("status"));
                data_mutasi.pekerjaan.setText(rs.getString("pekerjaan"));
                data_mutasi.asal.setText(rs.getString("alamat_asal"));
                data_mutasi.tujuan.setText(rs.getString("alamat_tujuan"));
                if (rs.getString("kelamin").equals ("Laki - Laki"))
                {
                    data_mutasi.laki.setSelected(true);
                    data_mutasi.perempuan.setSelected(false);
                }
                else if (rs.getString("kelamin").equals("Perempuan"))
                {
                    data_mutasi.laki.setSelected(false);
                    data_mutasi.perempuan.setSelected(true);
                    
                }
                
        
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "proses ambil data"+e.getMessage());
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        tambah = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        cetak = new javax.swing.JButton();
        backgroud = new javax.swing.JLabel();
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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 1190, -1));

        tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Tambah Data.png"))); // NOI18N
        tambah.setBorder(null);
        tambah.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Tambah Data1.png"))); // NOI18N
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });
        add(tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, -1, -1));

        ubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Ubah Data.png"))); // NOI18N
        ubah.setBorder(null);
        ubah.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Ubah Data1.png"))); // NOI18N
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });
        add(ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 480, -1, -1));

        hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/hapus Data.png"))); // NOI18N
        hapus.setBorder(null);
        hapus.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/hapus Data1.png"))); // NOI18N
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });
        add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 480, -1, -1));

        cetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/print.png"))); // NOI18N
        cetak.setBorder(null);
        cetak.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/print1.png"))); // NOI18N
        cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakActionPerformed(evt);
            }
        });
        add(cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 470, -1, -1));

        backgroud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/panel.png"))); // NOI18N
        add(backgroud, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        tes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tesActionPerformed(evt);
            }
        });
        add(tes, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 480, 110, -1));

        refresh.setText("jButton1");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 470, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        
        
        
        if (tes.getText().equals (""))
        {
            JOptionPane.showMessageDialog(this, "Pilih Data Yang ingin diUbah");
        }
        else
        {
            new data_mutasi().setVisible(true);
            data_mutasi.ubah.setVisible(true);
            data_mutasi.simpan.setVisible(false);
            ambil_data();
        }
    }//GEN-LAST:event_ubahActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        new data_mutasi().setVisible(true);
    }//GEN-LAST:event_tambahActionPerformed

    private void tesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tesActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        int i = tabel.getSelectedRow();
        tes.setText(model.getValueAt(i, 1).toString());
        
        
    }//GEN-LAST:event_tabelMouseClicked

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        tampil_data();
    }//GEN-LAST:event_refreshActionPerformed

    private void cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakActionPerformed
        try
            {
                File file       = new File("src/Report/mutasi.jasper");
                JasperPrint jp  = JasperFillManager.fillReport(file.getPath(),null, con);
                JasperViewer.viewReport(jp, false);
            }
        
        catch (JRException e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
    }//GEN-LAST:event_cetakActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        try
        {
            sql = "delete from mutasi where no_surat = '"+tes.getText()+"' ";
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Data DIhapus");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "proses ambil data"+e.getMessage());
        }
        tampil_data();
    }//GEN-LAST:event_hapusActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroud;
    private javax.swing.JButton cetak;
    private javax.swing.JButton hapus;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JButton refresh;
    private javax.swing.JTable tabel;
    private javax.swing.JButton tambah;
    public static javax.swing.JTextField tes;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
