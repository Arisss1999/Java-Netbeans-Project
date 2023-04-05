import java.awt.Component;
import java.io.File;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;


public class laporan extends javax.swing.JPanel {

    Connection con;
    Statement stm;
    ResultSet rs;
    String sql;
    public String jenis = "";
    
    DefaultTableModel model;
    TableColumn kolom;
    
    public laporan() {
        initComponents();
        koneksi db = new koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
        
        combo();
           
    }
    
    public void combo()
    {
        if(pilih.getSelectedItem() == "- pilih tabel -")
        {
            cetak.setEnabled(false);
        }
        else
        {
            cetak.setEnabled(true);
        }
    }
 
    
    public void tampil_penimbangan()
    {
        String []th = {"No","ID Penimbangan","Tanggal Penimbangan","Nama Anak","Tempat Tanggal Lahir","Jenis Kelamin","Usia","Lingkar Lengan","Tinggi Badan","Berat Badan","Nama Ibu","Alamat"};
        model = new DefaultTableModel(th, 0);
        tabel.setModel(model);
        
        int row = tabel.getRowCount();
        for (int a=0; a<row; a++)
        {
            model.removeRow(0);
        }
        try
        {
            int no=1;
            sql = "select * from pasien inner join penimbangan on penimbangan.id_penimbangan = pasien.id_penimbangan order by penimbangan.id_penimbangan asc";
            rs  = stm.executeQuery(sql);
            while(rs.next())
            {
                model.addRow(new Object[]
                {
                    no++,
                    rs.getString("id_penimbangan"),
                    rs.getString("tgl_daftar"),
                    rs.getString("nama_anak"),
                    rs.getString("ttl"),
                    rs.getString("jenis_kelamin"),
                    rs.getString("usia"),
                    rs.getString("lingkar_lengan"),
                    rs.getString("tinggi"),
                    rs.getString("berat"),
                    rs.getString("nama_ibu"),
                    rs.getString("alamat"),

                });
            }
        }
        
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } 
    }
    
    
    public void tampil_imunisasi()
    {
        String []th = {"No","ID Imunisasi","Tanggal Imunisasi","Nama Anak","Tempat Tanggal Lahir","Jenis Kelamin","Usia","Jenis Imunisasi","Nama Ibu","Alamat"};
        model = new DefaultTableModel(th, 0);
        tabel.setModel(model);
        
        int row = tabel.getRowCount();
        for (int a=0; a<row; a++)
        {
            model.removeRow(0);
        }
        try
        {
            int no=1;
            sql = "select * from pasien inner join imunisasi on imunisasi.id_imunisasi = pasien.id_imunisasi order by imunisasi.id_imunisasi asc";
            rs  = stm.executeQuery(sql);
            while(rs.next())
            {
                model.addRow(new Object[]
                {
                    no++,
                    rs.getString("id_imunisasi"),
                    rs.getString("tgl_daftar"),
                    rs.getString("nama_anak"),
                    rs.getString("ttl"),
                    rs.getString("jenis_kelamin"),
                    rs.getString("usia"),
                    rs.getString("jenis_imunisasi"),
                    rs.getString("nama_ibu"),
                    rs.getString("alamat"),

                });
            }
        }
        
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } 
    }
    
    
    public void tampil_kematian()
    {
        String []th = {"No","ID Kematian","Tanggal Kematian","Nama Anak","Tempat Tanggal Lahir","Jenis Kelamin","Usia","Nama Ibu","Alamat","Keterangan Kematian"};
        model = new DefaultTableModel(th, 0);
        tabel.setModel(model);
        
        int row = tabel.getRowCount();
        for (int a=0; a<row; a++)
        {
            model.removeRow(0);
        }
        try
        {
            int no=1;
            sql = "select * from kematian order by tanggal_kematian asc";
            rs  = stm.executeQuery(sql);
            while(rs.next())
            {
                model.addRow(new Object[]
                {
                    no++,
                    rs.getString("id_kematian"),
                    rs.getString("tanggal_kematian"),
                    rs.getString("nama_anak"),
                    rs.getString("ttl"),
                    rs.getString("kelamin"),
                    rs.getString("usia"),
                    rs.getString("nama_ibu"),
                    rs.getString("alamat"),
                    rs.getString("keterangan"),                  
                });
            }
        }
        
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    
    
    public void tampil_pendaftaran()
    {
        String []th = {"No","ID Pendaftaran","Tanggal Pendaftaran","Nama Anak","Tempat Tanggal Lahir","Jenis Kelamin","Usia","Nama Ibu","Alamat"};
        model = new DefaultTableModel(th, 0);
        tabel.setModel(model);
        
        int row = tabel.getRowCount();
        for (int a=0; a<row; a++)
        {
            model.removeRow(0);
        }
        try
        {
            int no=1;
            sql = "select * from pasien order by id_pasien asc";
            rs  = stm.executeQuery(sql);
            while(rs.next())
            {
                model.addRow(new Object[]
                {
                    no++,
                    rs.getString("id_pasien"),
                    rs.getString("tgl_daftar"),
                    rs.getString("nama_anak"),
                    rs.getString("ttl"),
                    rs.getString("jenis_kelamin"),
                    rs.getString("usia"),
                    rs.getString("nama_ibu"),
                    rs.getString("alamat"),

                });
            }
        }
        
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
    
    
    public void tampil_vitamin()
    {
        String []th = {"No","ID Vitamin","Tanggal Vitamin","Nama Anak","Tempat Tanggal Lahir","Jenis Kelamin","Jenis Vitamin","Status","Usia","Nama Ibu","Alamat"};
        model = new DefaultTableModel(th, 0);
        tabel.setModel(model);
        
        int row = tabel.getRowCount();
        for (int a=0; a<row; a++)
        {
            model.removeRow(0);
        }
        try
        {
            int no=1;
            sql = "select * from pasien inner join vitamin on vitamin.id_vitamin = pasien.id_vitamin order by vitamin.id_vitamin asc";
            rs  = stm.executeQuery(sql);
            while(rs.next())
            {
                model.addRow(new Object[]
                {
                    no++,
                    rs.getString("id_vitamin"),
                    rs.getString("tgl_vitamin"),
                    rs.getString("nama_anak"),
                    rs.getString("ttl"),
                    rs.getString("jenis_kelamin"),
                    rs.getString("keterangan"),
                    rs.getString("status"),
                    rs.getString("usia"),
                    rs.getString("nama_ibu"),
                    rs.getString("alamat"),

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
        pilih = new javax.swing.JComboBox<>();
        cetak = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

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
        jScrollPane1.setViewportView(tabel);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 1000, 300));

        pilih.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        pilih.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- pilih tabel -", "Pendaftaran", "Penimbangan", "Imunisasi", "Vitamin", "Kematian" }));
        pilih.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                pilihItemStateChanged(evt);
            }
        });
        add(pilih, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 110, -1));

        cetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/cetak.png"))); // NOI18N
        cetak.setBorder(null);
        cetak.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/cetak1.png"))); // NOI18N
        cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakActionPerformed(evt);
            }
        });
        add(cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 530, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Laporan.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakActionPerformed
       
        if (pilih.getSelectedItem() == "Imunisasi")
        {
            try
            {
                File file       = new File("src/cetak/imunisasi.jasper");
                JasperPrint jp  = JasperFillManager.fillReport(file.getPath(),null, con);
                JasperViewer.viewReport(jp, false);
            }
        
            catch (JRException e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        else if (pilih.getSelectedItem() == "Kematian")
        {
             try
            {
                File file       = new File("src/cetak/kematian.jasper");
                JasperPrint jp  = JasperFillManager.fillReport(file.getPath(),null, con);
                JasperViewer.viewReport(jp, false);
            }
        
            catch (JRException e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        else if (pilih.getSelectedItem() == "Pendaftaran")
        {
            try
            {
                File file       = new File("src/cetak/Pasien.jasper");
                JasperPrint jp  = JasperFillManager.fillReport(file.getPath(),null, con);
                JasperViewer.viewReport(jp, false);
            }
        
            catch (JRException e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        else if (pilih.getSelectedItem() == "Penimbangan")
        {
            try
            {
                File file       = new File("src/cetak/penimbangan.jasper");
                JasperPrint jp  = JasperFillManager.fillReport(file.getPath(),null, con);
                JasperViewer.viewReport(jp, false);
            }
        
            catch (JRException e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        else if(pilih.getSelectedItem() == "Vitamin")
        {
            try
            {
                File file       = new File("src/cetak/vitamin.jasper");
                JasperPrint jp  = JasperFillManager.fillReport(file.getPath(),null, con);
                JasperViewer.viewReport(jp, false);
            }
        
            catch (JRException e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        else 
        {
            model = new DefaultTableModel();
            tabel.setModel(model);
        }
        
    }//GEN-LAST:event_cetakActionPerformed

    private void pilihItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_pilihItemStateChanged
        combo();
        if (pilih.getSelectedItem() == "Imunisasi")
        {
            tampil_imunisasi();
        }
        else if (pilih.getSelectedItem() == "Kematian")
        {
             tampil_kematian();
        }
        else if (pilih.getSelectedItem() == "Pendaftaran")
        {
            tampil_pendaftaran();
        }
        else if (pilih.getSelectedItem() == "Penimbangan")
        {
            tampil_penimbangan();
        }
        else if(pilih.getSelectedItem() == "Vitamin")
        {
            tampil_vitamin();
        }
        else 
        {
            model = new DefaultTableModel();
            tabel.setModel(model);
        }
    }//GEN-LAST:event_pilihItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cetak;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> pilih;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}
