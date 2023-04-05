import java.io.File;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

public class laporan extends javax.swing.JPanel {

    Connection con;
    Statement stm;
    ResultSet rs;
    String sql;
    String tgl;
    
    DefaultTableModel model;
    TableColumn kolom;
    
    public laporan() {
        initComponents();
        
        koneksi db = new koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
        
    }
    public void pengeluaran()
    {
         String []th = {"No","Kode Transaksi","Nama Produk","Stok", "Harga", "Supplier", "Telepon"};
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
                if (tanggal.getDate() == null)
                {
                    sql = "SELECT * from pembelian inner join produk using (kd_produk) order by kd_transaksi asc";
                }
                else if (tanggal.getDate() != null)
                {
                    sql = "SELECT * from pembelian inner join produk using (kd_produk) where tanggal = '"+tgl+"' order by kd_transaksi asc";
                }
                rs  = stm.executeQuery(sql);
                while(rs.next())
                {
                    model.addRow(new Object[]
                    {
                        no++,
                        rs.getString("kd_transaksi"),
                        rs.getString("nama_produk"),
                        rs.getString("stok"),
                        rs.getString("harga"),
                        rs.getString("supplier"),
                        rs.getString("telepon"),
                    });
                }
            }
        
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
    }
    
    public void penjualan()
    {
            String []th = {"No","Kode Pembelian","Tanggal","Total Belanja"};
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
                if (tanggal.getDate() == null)
                {
                    
                    sql = "SELECT DISTINCT kd_pembelian,tanggal,total_belanja from penjualan inner join produk using (kd_produk) order by kd_pembelian asc";
                }
                else if (tanggal.getDate() != null)
                {
                sql = "SELECT DISTINCT kd_pembelian,tanggal,total_belanja from penjualan inner join produk using (kd_produk) where tanggal = '"+tgl+"' order by kd_pembelian asc";
                }
                rs  = stm.executeQuery(sql);
                while(rs.next())
                {
                    model.addRow(new Object[]
                    {
                        no++,
                        rs.getString("kd_pembelian"),
                        rs.getString("tanggal"),
                        rs.getString("total_belanja")
                    });
                }
            }
        
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
    }

    public void hitung_total()
    {
        int total = 0;
        for (int i=0; i < tabel.getRowCount(); i++)
        {
            String x = tabel.getValueAt(i,4).toString();
            int nilai = Integer.parseInt(x);
            total += nilai;
        }
        ttl.setText("Rp."+total);
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        ttl = new javax.swing.JLabel();
        tanggal = new com.toedter.calendar.JDateChooser();
        ok = new javax.swing.JButton();
        combo_tabel = new javax.swing.JComboBox<>();
        cetak = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 730, 260));

        ttl.setFont(new java.awt.Font("Sylfaen", 1, 18)); // NOI18N
        add(ttl, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 480, 190, 30));

        tanggal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tanggalPropertyChange(evt);
            }
        });
        tanggal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tanggalKeyReleased(evt);
            }
        });
        add(tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 145, 130, 20));

        ok.setText("ok");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        add(ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 145, -1, -1));

        combo_tabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        combo_tabel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih -", "Penjualan", "Pengeluaran" }));
        combo_tabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        combo_tabel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                combo_tabelItemStateChanged(evt);
            }
        });
        add(combo_tabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 145, 110, 20));

        cetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn/cetak.png"))); // NOI18N
        cetak.setBorder(null);
        cetak.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/btn/cetak1.png"))); // NOI18N
        cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakActionPerformed(evt);
            }
        });
        add(cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 540, -1, -1));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gmbr/Laporran.png"))); // NOI18N
        add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void tanggalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tanggalPropertyChange
           if (tanggal.getDate() != null)
           {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                tanggal.setDateFormatString("yyyy-MM-dd");
                tgl = (String.valueOf(format.format (tanggal.getDate())));
           }
    }//GEN-LAST:event_tanggalPropertyChange

    private void tanggalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tanggalKeyReleased
       
    }//GEN-LAST:event_tanggalKeyReleased

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        if (combo_tabel.getSelectedItem() == "- Pilih -")
        {
            model.removeRow(0);
        }
        else if (combo_tabel.getSelectedItem() == "Penjualan")
        {
            penjualan();
            int total = 0;
            for (int i=0; i < tabel.getRowCount(); i++)
            {
                int nilai = Integer.parseInt((String)tabel.getValueAt(i, 3));
                total += nilai;
            }
            ttl.setText("Rp."+total);
        }
        else if (combo_tabel.getSelectedItem() == "Pengeluaran")
        {
            pengeluaran();
            hitung_total();
        }
        
        hitung_total();
    }//GEN-LAST:event_okActionPerformed

    private void combo_tabelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_combo_tabelItemStateChanged
        if (combo_tabel.getSelectedItem() == "- Pilih -")
        {
            model.removeRow(0);
        }
        else if (combo_tabel.getSelectedItem() == "Penjualan")
        {
            penjualan();
            int total = 0;
            for (int i=0; i < tabel.getRowCount(); i++)
            {
                int nilai = Integer.parseInt((String)tabel.getValueAt(i, 3));
                total += nilai;
            }
            ttl.setText("Rp."+total);
        }
        else if (combo_tabel.getSelectedItem() == "Pengeluaran")
        {
            pengeluaran();
            hitung_total();
        }
    }//GEN-LAST:event_combo_tabelItemStateChanged

    private void cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakActionPerformed
        if (combo_tabel.getSelectedItem() == "Pengeluaran")
        {
            if (tanggal.getDate() == null)
            {
                try
                {
                    File file       = new File("src/Laporan/tpengeluaran.jasper");
                    JasperPrint jp  = JasperFillManager.fillReport(file.getPath(),null, con);
                    JasperViewer.viewReport(jp, false);
                }
                catch (JRException e)
                {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
            else if(tanggal.getDate() != null) {
            
                try
                {
                    File file       = new File("src/Laporan/pengeluaran.jasper");
                    HashMap parameter = new HashMap();
                    parameter.put("tanggal",tgl);
                    JasperPrint jp  = JasperFillManager.fillReport(file.getPath(),parameter, con);
                    JasperViewer.viewReport(jp, false); 
                }
                catch (Exception e)
                {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
        else if (combo_tabel.getSelectedItem() == "Penjualan")
        {
            if (tanggal.getDate() == null)
            {
                try
                {
                    File file       = new File("src/Laporan/tpenjualan.jasper");
                    JasperPrint jp  = JasperFillManager.fillReport(file.getPath(),null, con);
                    JasperViewer.viewReport(jp, false);
                }
                catch (JRException e)
                {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
            else if(tanggal.getDate() != null)
            {
                try
                {
                    File file       = new File("src/Laporan/penjualan.jasper");
                    HashMap parameter = new HashMap();
                    parameter.put("tanggal",tgl);
                    JasperPrint jp  = JasperFillManager.fillReport(file.getPath(),parameter, con);
                    JasperViewer.viewReport(jp, false); 
                }
                catch (Exception e)
                {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_cetakActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton cetak;
    private javax.swing.JComboBox<String> combo_tabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton ok;
    private javax.swing.JTable tabel;
    private com.toedter.calendar.JDateChooser tanggal;
    private javax.swing.JLabel ttl;
    // End of variables declaration//GEN-END:variables
}
