
import java.io.File;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

public class riwayat_pesanan extends javax.swing.JPanel {

    Connection con;
    Statement stm;
    ResultSet rs;
    String sql;
    String harga;
    String tanggal;
    
    
    DefaultTableModel model;
    TableColumn kolom;
    
    public riwayat_pesanan() {
        initComponents();
        
        koneksi db = new koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
        
        kasir.setText(dashboard.nama_pegawai.getText());
        String []th = {"No","Kode Pembelian","Tanggal","Total Belanja"};
        model = new DefaultTableModel(th, 0);
        tabel.setModel(model);
       
        tampilkan();
        pembeli();
        
    }

    private void pembeli()
    {
        try
        {
            sql = "SELECT count(DISTINCT kd_pembelian) as total from penjualan where tanggal = '"+tanggal+"' ";
            rs = stm.executeQuery(sql);
            if (rs.next())
            {
                pembeli.setText(rs.getString("total"));
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    public void tampilkan()
    {
        Date buat_tgl = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        tanggal = (String.valueOf(format.format(buat_tgl)));
        
        int row = tabel.getRowCount();
        for (int a=0; a<row; a++)
        {
            model.removeRow(0);
        }
        try
        {
            int no=1;
            sql = "SELECT DISTINCT kd_pembelian,tanggal,total_belanja from penjualan where tanggal = '"+tanggal+"' order by kd_pembelian asc";
            rs  = stm.executeQuery(sql);
            while(rs.next())
            {
                model.addRow(new Object[]
                {
                    no++,
                    rs.getString("kd_pembelian"),
                    rs.getString("tanggal"),
                    rs.getString("total_belanja"),
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
        kasir = new javax.swing.JLabel();
        pembeli = new javax.swing.JLabel();
        lihat = new javax.swing.JButton();
        background = new javax.swing.JLabel();
        kode = new javax.swing.JTextField();
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

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 760, 230));

        kasir.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        add(kasir, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 160, 20));

        pembeli.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        pembeli.setForeground(new java.awt.Color(255, 255, 255));
        add(pembeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 118, 40, 20));

        lihat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn/lihat.png"))); // NOI18N
        lihat.setToolTipText("");
        lihat.setBorder(null);
        lihat.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/btn/lihat1.png"))); // NOI18N
        lihat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lihatActionPerformed(evt);
            }
        });
        add(lihat, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 500, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gmbr/Riwayat pesanan.png"))); // NOI18N
        add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        add(kode, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 170, -1));

        refresh.setText("Refresh");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        int row = tabel.getSelectedRow();
        kode.setText(model.getValueAt(row, 1).toString());
    }//GEN-LAST:event_tabelMouseClicked

    private void lihatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lihatActionPerformed
        new lihat().setVisible(true);
    }//GEN-LAST:event_lihatActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        pembeli();
        tampilkan();
    }//GEN-LAST:event_refreshActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel kasir;
    public static javax.swing.JTextField kode;
    private javax.swing.JButton lihat;
    private javax.swing.JLabel pembeli;
    public static javax.swing.JButton refresh;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}
