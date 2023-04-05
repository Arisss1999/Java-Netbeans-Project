import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.*;


public class data_pelanggan extends javax.swing.JPanel {

    Connection con;
    Statement stm;
    ResultSet rs;
    String sql;
    String harga;
    
    DefaultTableModel model;
    TableColumn kolom;
    
    public data_pelanggan() {
        initComponents();
        
        koneksi db = new koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
        
        String []th = {"No","ID Pelanggan","Nama Pelanggan","Alamat", "Jenis Kelamin", "Telepon"};
        model = new DefaultTableModel(th, 0);
        tabel.setModel(model);
        buat_id();
        tampil();
    }
    public final void buat_id()
    {
        try
        {
            sql = "select * from pelanggan order by id_pelanggan desc";
            rs  = stm.executeQuery(sql);
            if(rs.next())
            {
                String a = rs.getString("id_pelanggan").substring(3);
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
                id.setText("P"+ c + b);
            }
            else
            {
                id.setText("P0001");
            }
            
        }
        catch(SQLException | NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
  public void tampil()
    {
        int row = tabel.getRowCount();
        for (int a=0; a<row; a++)
        {
            model.removeRow(0);
        }
        try
        {
            int no=1;
            sql = "select * from pelanggan";
            rs  = stm.executeQuery(sql);
            while(rs.next())
            {
                model.addRow(new Object[]
                {
                    no++,
                    rs.getString("id_pelanggan"),
                    rs.getString("nama_pelanggan"), 
                    rs.getString("alamat"),
                    rs.getString("kelamin"),
                    rs.getString("telepon"),
                    
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
         nama.setText("");
         alamat.setText("");
         telepon.setText("");
         kelamin.setSelectedIndex(0);
     }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        telepon = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        kelamin = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        hapus = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        Backgrounf = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Alamat");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("No Telepon");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Jenis Kelamin");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("ID");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        telepon.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        telepon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(telepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 180, 250, -1));

        nama.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        nama.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 250, -1));

        alamat.setColumns(20);
        alamat.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        alamat.setRows(5);
        alamat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(alamat);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 250, 80));

        kelamin.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        kelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki - Laki", "Perempuan" }));
        kelamin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(kelamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 250, -1));

        tabel.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
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

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 960, 240));

        hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button action/hapus.png"))); // NOI18N
        hapus.setBorder(null);
        hapus.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button action/hapus1.png"))); // NOI18N
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });
        add(hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 280, -1, -1));

        ubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button action/ubah.png"))); // NOI18N
        ubah.setBorder(null);
        ubah.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button action/ubah1.png"))); // NOI18N
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });
        add(ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, -1, -1));

        simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button action/sinpan.png"))); // NOI18N
        simpan.setBorder(null);
        simpan.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button action/sinpan1.png"))); // NOI18N
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });
        add(simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Nama");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        id.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 160, 20));

        Backgrounf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Panel.png"))); // NOI18N
        add(Backgrounf, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        if (nama.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "pilih Data yang ingin Dihapus");
        }
        else
        {
            int ok = JOptionPane.showConfirmDialog(null,"Yakin ingin Menghapus Data ?","Peringatan",JOptionPane.YES_NO_OPTION);
            if(ok==0)
            {
                try
                {
                
                    sql = "delete from pelanggan where id_pelanggan = '"+id.getText()+"' ";
                    stm.executeUpdate(sql);
                    
                    JOptionPane.showMessageDialog(this, "Data Berhasil Dihapus");
                    
                    tampil();
                    buat_id();
                    reset();
                }
                catch (Exception e)
                {
                    JOptionPane.showMessageDialog(this, e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_hapusActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        try
        {
            sql = "insert into pelanggan (id_pelanggan, nama_pelanggan, alamat, kelamin, telepon) value ('"+id.getText()+"', '"+nama.getText()+"', '"+alamat.getText()+"', '"+kelamin.getSelectedItem()+"', '"+telepon.getText()+"' )";
            stm.executeUpdate(sql);
            
            JOptionPane.showMessageDialog(this, "Data Berhasil Ditambah");
            
            tampil();
            buat_id();
            reset();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        int i = tabel.getSelectedRow();
        id.setText(model.getValueAt(i, 1).toString());
        nama.setText(model.getValueAt(i, 2).toString());
        alamat.setText(model.getValueAt(i, 3).toString());
        telepon.setText(model.getValueAt(i, 5).toString());
        kelamin.setSelectedItem(model.getValueAt(i, 4).toString());
    }//GEN-LAST:event_tabelMouseClicked

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        if (nama.getText().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Pilih Data yang Ingin Diubah");
        }
        else
        {
            try
            {
                sql = "update pelanggan set nama_pelanggan = '"+nama.getText()+"', alamat = '"+alamat.getText()+"', telepon = '"+telepon.getText()+"', kelamin = '"+kelamin.getSelectedItem()+"' where id_pelanggan = '"+id.getText()+"' ";
                stm.executeUpdate(sql);
                JOptionPane.showMessageDialog(this, "Data Berhasil Diubah");
            
                reset();
                buat_id();
                tampil();
            }   
        
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_ubahActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Backgrounf;
    private javax.swing.JTextArea alamat;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> kelamin;
    private javax.swing.JTextField nama;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField telepon;
    private javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
