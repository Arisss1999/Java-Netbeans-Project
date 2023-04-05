
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class laporan extends javax.swing.JPanel {

    Connection con;
    Statement stm;
    ResultSet rs;
    String sql;
    
    DefaultTableModel model;
    TableColumn kolom;
    public laporan() {
        initComponents();
        
        koneksi db = new koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pilih = new javax.swing.JComboBox<String>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pilih.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Penyewaan", "Pengembalian", "Data Pelanggan", "Data Barang" }));
        pilih.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihActionPerformed(evt);
            }
        });
        add(pilih, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 160, 30));

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 940, 290));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button action/cetak.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button action/cetak1.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 470, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/laporan pnl.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void pilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihActionPerformed
        
        try
        {
            // Penyewaan
            if(pilih.getSelectedItem() == "Penyewaan")
            {
                sql = "Select * from penyewaan inner join pelanggan using (id_pelanggan) inner join barang using (kd_barang) order by kd_sewa asc";
                rs = stm.executeQuery(sql);
                
                int no = 1;
                String []th = {"No","Kode Sewa", "Nama Pelanggan","Nama Barang","Ukuran","Unit","Tanggal Sewa",};
                model = new DefaultTableModel(th, 0);
                tabel.setModel(model);
                
                SimpleDateFormat sdt = new SimpleDateFormat("dd-MM-yyyy");
                String tgl;
                        
                
                while(rs.next())
                {
                    model.addRow(new Object[]
                    {
                        no++,
                        rs.getString("kd_sewa"),
                        rs.getString("nama_pelanggan"),
                        rs.getString("nama_barang"),
                        rs.getString("ukuran"), 
                        rs.getString("ttl_sewa"),
                        tgl = String.valueOf(sdt.format(rs.getDate("tgl_sewa")))
                    });
                }
            }
            
            //Pengembalian
            else if(pilih.getSelectedItem() == "Pengembalian")
            {
                sql = "Select * from penyewaan inner join pengembalian using (kd_sewa) inner join pelanggan using (id_pelanggan) inner join barang using (kd_barang) order by kd_sewa asc";
                rs = stm.executeQuery(sql);
                
                int no = 1;
                String []th = {"No","Kode Sewa", "Nama Pelanggan","Nama Barang","Ukuran","Unit","Tanggal Sewa","Keterangan"};
                model = new DefaultTableModel(th, 0);
                tabel.setModel(model);
                
                SimpleDateFormat sdt = new SimpleDateFormat("dd-MM-yyyy");
                String tgl;
                        
                
                while(rs.next())
                {
                    model.addRow(new Object[]
                    {
                        no++,
                        rs.getString("kd_sewa"),
                        rs.getString("nama_pelanggan"),
                        rs.getString("nama_barang"),
                        rs.getString("ukuran"), 
                        rs.getString("ttl_sewa"),
                        tgl = String.valueOf(sdt.format(rs.getDate("tgl_sewa"))),
                        rs.getString("keterangan")
                    });
                }
            }
            
            //Pelanggan
            else if(pilih.getSelectedItem() == "Data Pelanggan")
            {
                sql = "Select * from pelanggan order by id_pelanggan asc";
                rs = stm.executeQuery(sql);
                
                int no = 1;
                String []th = {"No","ID Pelanggan", "Nama Pelanggan","Alamat","Jenis Kelamin","No Telepon"};
                model = new DefaultTableModel(th, 0);
                tabel.setModel(model);
                
                while(rs.next())
                {
                    model.addRow(new Object[]
                    {
                        no++,
                        rs.getString("id_pelanggan"),
                        rs.getString("nama_pelanggan"),
                        rs.getString("alamat"),
                        rs.getString("kelamin"), 
                        rs.getString("telepon")
                    });
                }
            }
            
            //Barang
            else if(pilih.getSelectedItem() == "Data Barang")
            {
                sql = "Select * from barang order by kd_barang asc";
                rs = stm.executeQuery(sql);
                
                int no = 1;
                String []th = {"No","Kode Barang", "Nama Barang","Harga","Ukuran","Unit"};
                model = new DefaultTableModel(th, 0);
                tabel.setModel(model);
                
                while(rs.next())
                {
                    model.addRow(new Object[]
                    {
                        no++,
                        rs.getString("kd_barang"),
                        rs.getString("nama_barang"),
                        rs.getString("harga"),
                        rs.getString("ukuran"), 
                        rs.getString("unit")
                    });
                }
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
    }//GEN-LAST:event_pilihActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (pilih.getSelectedItem() == "Penyewaan")
        {
            try
            {
                File file       = new File("src/laporan/penyewaan.jasper");
                JasperPrint jp  = JasperFillManager.fillReport(file.getPath(),null, con);
                JasperViewer.viewReport(jp, false);
            }
        
            catch (JRException e)
            {
                    JOptionPane.showMessageDialog(null, e);
            }
        }
        if (pilih.getSelectedItem() == "Pengembalian")
        {
            try
            {
                File file       = new File("src/laporan/pengembalian.jasper");
                JasperPrint jp  = JasperFillManager.fillReport(file.getPath(),null, con);
                JasperViewer.viewReport(jp, false);
            }
        
            catch (JRException e)
            {
                    JOptionPane.showMessageDialog(null, e);
            }
        }
        if (pilih.getSelectedItem() == "Data Pelanggan")
        {
            try
            {
                File file       = new File("src/laporan/pelanggan.jasper");
                JasperPrint jp  = JasperFillManager.fillReport(file.getPath(),null, con);
                JasperViewer.viewReport(jp, false);
            }
        
            catch (JRException e)
            {
                    JOptionPane.showMessageDialog(null, e);
            }
        }
        else if (pilih.getSelectedItem() == "Data Barang")
        {
            try
            {
                File file       = new File("src/laporan/barang.jasper");
                JasperPrint jp  = JasperFillManager.fillReport(file.getPath(),null, con);
                JasperViewer.viewReport(jp, false);
            }
        
            catch (JRException e)
            {
                    JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> pilih;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}
