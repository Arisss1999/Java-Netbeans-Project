import java.io.File;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.util.HashMap;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;


public class pembuatan_surat extends javax.swing.JPanel {

    Connection con;
    Statement stm;
    ResultSet rs;
    String sql;
    
    DefaultTableModel model;
    TableColumn kolom;
    
    
    public pembuatan_surat() {
        initComponents();
        koneksi db = new koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
        
        String []th = {"No","No surat", "Tanggal Surat", "NIK" , "Nama Pemohon", "Tujuan", "Keterangan"};
        model = new DefaultTableModel(th, 0);
        
        tabel.setModel(model);
        tampil_data();
        
    }
    private void ambil_data() {
        try
        {
            sql = "select * from surat where no_surat = '"+tes.getText()+"' ";
            rs = stm.executeQuery(sql);
            while (rs.next())
            {
            data_surat.no_surat.setText(rs.getString("no_surat"));
            java.util.Date da = new SimpleDateFormat("dd-MM-yyyy").parse((String)rs.getString("tanggal_surat"));
                    data_surat.tanggal.setDate(da);
            data_surat.nama.setText(rs.getString("nama"));
            data_surat.nik.setText(rs.getString("nik"));
            data_surat.tujuan.setText(rs.getString("tujuan"));
            data_surat.keterangan.setText(rs.getString("keterangan"));
            
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
           
            sql = "select * from surat order by no_surat asc";
            rs  = stm.executeQuery(sql);
            while(rs.next())
            {
                model.addRow(new Object[]
                {
                    no++,
                    rs.getString("no_surat"),
                    rs.getString("tanggal_surat"),
                    rs.getString("nik"),
                    rs.getString("nama"),
                    rs.getString("tujuan"),
                    rs.getString("keterangan")
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

        ubah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        tambah = new javax.swing.JButton();
        cetak = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        background = new javax.swing.JLabel();
        tes = new javax.swing.JTextField();
        refresh = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Ubah Data.png"))); // NOI18N
        ubah.setBorder(null);
        ubah.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Ubah Data1.png"))); // NOI18N
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });
        add(ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 460, -1, -1));

        hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/hapus Data.png"))); // NOI18N
        hapus.setBorder(null);
        hapus.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/hapus Data1.png"))); // NOI18N
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });
        add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 460, -1, -1));

        tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Tambah Data.png"))); // NOI18N
        tambah.setBorder(null);
        tambah.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Tambah Data1.png"))); // NOI18N
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });
        add(tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, -1));

        cetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/print.png"))); // NOI18N
        cetak.setBorder(null);
        cetak.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/print1.png"))); // NOI18N
        cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakActionPerformed(evt);
            }
        });
        add(cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 460, -1, -1));

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 1110, 400));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/panel.png"))); // NOI18N
        add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        add(tes, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 470, 170, -1));

        refresh.setText("refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        if (tes.getText().equals (""))    
        {
             JOptionPane.showMessageDialog(this, "Pilih Data Yang ingin Di Ubah ! ","Information",JOptionPane.INFORMATION_MESSAGE);
        }
        else
        {
           
            new data_surat().setVisible(true);
            ambil_data();
            data_surat.ubah.setVisible(true);
            data_surat.simpan.setVisible(false);
        }
                                
    }//GEN-LAST:event_ubahActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        new data_surat().setVisible(true) ; 
    }//GEN-LAST:event_tambahActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        try
        {
            sql = "delete from surat where no_surat = '"+tes.getText()+"' ";
            stm.executeUpdate(sql);
            tampil_data();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Data Berhasil DiHapus");
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        int i = tabel.getSelectedRow();
        tes.setText(model.getValueAt(i, 1).toString());
    }//GEN-LAST:event_tabelMouseClicked

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        tampil_data();
    }//GEN-LAST:event_refreshActionPerformed

    private void cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakActionPerformed
        try{
             File file       = new File("src/Report/surat.jasper");
                HashMap parameter = new HashMap();
                parameter.put("surat",tes.getText());
                JasperPrint jp  = JasperFillManager.fillReport(file.getPath(),parameter, con);
                JasperViewer.viewReport(jp, false);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }//GEN-LAST:event_cetakActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
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
