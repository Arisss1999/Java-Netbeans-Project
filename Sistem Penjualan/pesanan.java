import java.io.File;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;


public class pesanan extends javax.swing.JPanel {

    Connection con;
    Statement stm;
    ResultSet rs;
    String sql;
    String harga;
    
    DefaultTableModel model;
    TableColumn kolom;
    
    
    public pesanan() {
        initComponents();
        koneksi db = new koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
        
        String []th = {"No","Kode","Nama Produk","Harga"};
        model = new DefaultTableModel(th, 0);
        tabel_produk.setModel(model);
       
        kode_pembelian();
        tampilkan(); 
        
    }
    public void hitung_total()
    {
        
        int total = 0;
        for (int i=0; i<tabel_pesanan.getRowCount(); i++)
        {
            String n = tabel_pesanan.getValueAt(i, 4).toString();
            int nilai = Integer.parseInt(n);
            total += nilai;
            
        }
        tb.setText(""+total);
    }
    
    public final void stok()
    {
        int x = tabel_pesanan.getRowCount();
        for(int i=0; i < x; i++)
        try
        {
            String kd_produk = tabel_pesanan.getValueAt(i, 0).toString();
            int jumlah = Integer.parseInt(tabel_pesanan.getValueAt(i, 3).toString());
            sql = "UPDATE produk SET stok_produk = stok_produk - '"+jumlah+"' where kd_produk = '"+kd_produk+"'";
            stm.executeUpdate(sql);
        }
        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
     public void tampilkan()
    {
        int row = tabel_produk.getRowCount();
        for (int a=0; a<row; a++)
        {
            model.removeRow(0);
        }
        try
        {
            int no=1;
            sql = "select * from produk order by kd_produk asc";
            rs  = stm.executeQuery(sql);
            while(rs.next())
            {
                model.addRow(new Object[]
                {
                    no++,
                    rs.getString("kd_produk"),
                    rs.getString("nama_produk"), 
                    rs.getString("harga_produk"),
                });
            }
        }
        
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }
     
     private void reset() 
     {
         DefaultTableModel model = (DefaultTableModel) tabel_pesanan.getModel();
         model.setRowCount(0);
         
         cash.setText("");
         kembalian.setText("");
         tb.setText("");
         
     }
     
     public final void kode_pembelian()
    {
        try
        {
            sql = "select * from penjualan order by kd_pembelian desc";
            rs  = stm.executeQuery(sql);
            if(rs.next())
            {
                String a = rs.getString("kd_pembelian").substring(1);
                String b = "" + (Integer.parseInt(a) + 1);
                String c = "";
                
                if(b.length() == 1)
                {
                    c = "000";
                }
                
                else if(b.length() == 2)
                {
                    c = "00";
                }
                
                else if(b.length() == 3)
                {
                    c = "0";
                }
                
                else if(b.length() == 4)
                {
                    c = "";
                }
                kode_pembelian.setText("P"+ c + b);
            }
            else
            {
                kode_pembelian.setText("P0001");
            }
            
        }
        catch(SQLException | NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        produk = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_produk = new javax.swing.JTable();
        pilih = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_pesanan = new javax.swing.JTable();
        sub = new javax.swing.JTextField();
        cash = new javax.swing.JTextField();
        tb = new javax.swing.JTextField();
        kembalian = new javax.swing.JTextField();
        cetak = new javax.swing.JButton();
        ok = new javax.swing.JButton();
        background = new javax.swing.JLabel();
        kode_pembelian = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        produk.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        produk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produkActionPerformed(evt);
            }
        });
        produk.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                produkKeyReleased(evt);
            }
        });
        add(produk, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 180, -1));

        tabel_produk.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_produk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_produkMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_produk);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, -1, 200));

        pilih.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        pilih.setText("Pilih");
        pilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihActionPerformed(evt);
            }
        });
        add(pilih, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 230, 60, -1));

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pilih / Cari Produk :");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, -1, -1));

        tabel_pesanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode", "Nama Produk", "Harga", "Sub", "Total Harga"
            }
        ));
        tabel_pesanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_pesananMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_pesanan);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 260, 330, 90));

        sub.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        add(sub, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 230, 180, -1));

        cash.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        cash.setBorder(null);
        cash.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cashKeyReleased(evt);
            }
        });
        add(cash, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 455, 140, 30));

        tb.setBackground(new java.awt.Color(177, 127, 78));
        tb.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        tb.setBorder(null);
        tb.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                tbCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        add(tb, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 407, 140, 30));

        kembalian.setBackground(new java.awt.Color(177, 127, 78));
        kembalian.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        kembalian.setBorder(null);
        add(kembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 505, 140, 30));

        cetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn/cetak.png"))); // NOI18N
        cetak.setBorder(null);
        cetak.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/btn/cetak1.png"))); // NOI18N
        cetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cetakActionPerformed(evt);
            }
        });
        add(cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 570, -1, -1));

        ok.setText("OK");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        add(ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 360, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gmbr/pemesanan.png"))); // NOI18N
        background.setToolTipText("");
        add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 650));

        kode_pembelian.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        add(kode_pembelian, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 180, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void produkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_produkActionPerformed

    private void pilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihActionPerformed
        int pilihh = tabel_produk.getSelectedRow();
        String kode_produk = model.getValueAt(pilihh, 1).toString();
        String nama_produk = model.getValueAt(pilihh, 2).toString();
        
        int harga_produk   = Integer.parseInt(model.getValueAt(pilihh, 3).toString());
        int subb           = Integer.parseInt(sub.getText());
        int totall         = harga_produk * subb;
        
        DefaultTableModel tabel2 = (DefaultTableModel)tabel_pesanan.getModel();
        tabel_pesanan.setAutoCreateColumnsFromModel(true);
        
        List list = new ArrayList<>();
        
        list.add(kode_produk);
        list.add(nama_produk);
        list.add(harga_produk);
        list.add(subb);
        list.add(totall);
        tabel2.addRow(list.toArray());
        
        tampilkan();
        sub.setText("");
        produk.setText("");
    }//GEN-LAST:event_pilihActionPerformed

    private void produkKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_produkKeyReleased
       int row = tabel_produk.getRowCount();
        for (int a=0; a<row; a++)
        {
            model.removeRow(0);
        }
        try
        {
            int no=1;
            sql = "select * from produk where nama_produk like  '"+produk.getText()+"%' order by kd_produk asc";
            rs  = stm.executeQuery(sql);
            while(rs.next())
            {
                model.addRow(new Object[]
                    {
                        no++,
                        rs.getString("kd_produk"),
                        rs.getString("nama_produk"),
                        rs.getString("harga_produk"),
                    });    
                }
            }
        
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
    }//GEN-LAST:event_produkKeyReleased

    private void tabel_produkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_produkMouseClicked
        int i = tabel_produk.getSelectedRow();
        produk.setText(model.getValueAt(i, 2).toString());
        harga = model.getValueAt(i, 3).toString();
    }//GEN-LAST:event_tabel_produkMouseClicked

    private void cashKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cashKeyReleased
        if(cash.getText().equals(""))
        {
            kembalian.setText("");
        }
        else
        {
            int cashh   = Integer.parseInt(cash.getText());
            int bayaran = Integer.parseInt(tb.getText());
            int hasill  = cashh-bayaran;
            kembalian.setText(String.valueOf(hasill));
        }
    }//GEN-LAST:event_cashKeyReleased

    private void cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cetakActionPerformed
        stok();   
        
        Date buat_tgl = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal = (String.valueOf(format.format(buat_tgl)));
        
        int x = tabel_pesanan.getRowCount();
        for(int i=0; i<x; i++)
            try
            {
                
                String kd_produk = tabel_pesanan.getValueAt(i, 0).toString();
                String sub = tabel_pesanan.getValueAt(i, 3).toString();
                String total = tabel_pesanan.getValueAt(i, 4).toString();
                
                sql = "insert into penjualan (kd_pembelian,tanggal,jam,total_belanja,kd_produk,sub, total, cash, kembalian) values ('" +kode_pembelian.getText()+"','"+tanggal+"', '"+utama.waktu.getText()+"','"+tb.getText()+"', '"+kd_produk+"', '"+sub+"', '"+total+"', '"+cash.getText()+"', '"+kembalian.getText()+"' )";
                stm.executeUpdate(sql);
               
               
            }
    
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        //JASPER
           try
           {
                File file       = new File("src/Laporan/struk.jasper");
                HashMap parameter = new HashMap();
                parameter.put("struk",kode_pembelian.getText());
                JasperPrint jp  = JasperFillManager.fillReport(file.getPath(),parameter, con);
                JasperViewer.viewReport(jp, false); 
           }
           catch (Exception e)
           {
               JOptionPane.showMessageDialog(null, e.getMessage());
           }    
           
           kode_pembelian();
           reset();
    }//GEN-LAST:event_cetakActionPerformed

    private void tabel_pesananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_pesananMouseClicked
        int row = tabel_pesanan.getSelectedRow();
        DefaultTableModel modelll = (DefaultTableModel)tabel_pesanan.getModel();
       
        if(row>=0)
        {
            int ok = JOptionPane.showConfirmDialog(null,"Yakin Mau Hapus","Konfirmasi",JOptionPane.YES_NO_OPTION);
            if(ok==0)
            {
                modelll.removeRow(row);
                
            }
        }
        else if (row == 0)
        {  
            tb.setText("0");
        }
               
    }//GEN-LAST:event_tabel_pesananMouseClicked

    private void tbCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_tbCaretPositionChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_tbCaretPositionChanged

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        hitung_total();
    }//GEN-LAST:event_okActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JTextField cash;
    private javax.swing.JButton cetak;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField kembalian;
    private javax.swing.JTextField kode_pembelian;
    private javax.swing.JButton ok;
    private javax.swing.JButton pilih;
    private javax.swing.JTextField produk;
    private javax.swing.JTextField sub;
    private javax.swing.JTable tabel_pesanan;
    private javax.swing.JTable tabel_produk;
    private javax.swing.JTextField tb;
    // End of variables declaration//GEN-END:variables
}
