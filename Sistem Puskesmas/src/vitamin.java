import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


public class vitamin extends javax.swing.JPanel {

    Connection con;
    Statement stm;
    ResultSet rs;
    String sql;
    String status;
    String id;
    
    DefaultTableModel model;
    TableColumn kolom;
    
    public vitamin() {
        initComponents();
        koneksi db = new koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
        
        String []th = {"No","ID Vitamin","Tanggal Vitamin","Nama Anak","Tempat Tanggal Lahir","Jenis Kelamin","Jenis Vitamin","Status","Usia","Nama Ibu","Alamat"};
        model = new DefaultTableModel(th, 0);
        tabel.setModel(model);
        
        pendaftaran.id_pendaftaran.getText();
        tampil();
        buat_id();
    }
     private void buat_id()
    {
        try
        {
            sql = "select * from vitamin order by id_vitamin desc";
            rs  = stm.executeQuery(sql);
            if(rs.next())
            {
                String a = rs.getString("id_vitamin").substring(2);
                String b = "" + (Integer.parseInt(a) + 1);
                String c = "";
                
                if( b.length()== 1 )
                {
                    c = "000";
                }
                else if( b.length()== 2 )
                {
                    c = "00";
                }
                else if( b.length()== 3 )
                {
                    c = "0";
                }
                else if( b.length()== 4 )
                {
                    c ="";
                }
                id_vitamin.setText("VT" + c + b);
            }
            
            else
            {
                id_vitamin.setText("VT0001");
            }
        }
        
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    public void pasienn()
    {
        try
        {
            sql="update pasien set id_vitamin = '"+id_vitamin.getText()+"' where id_pasien = '"+pilih_anak.tes.getText()+"'";
            stm.executeUpdate(sql);
        }
        
        catch(Exception e)
        {
            
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
            sql = "select * from pasien inner join vitamin on vitamin.id_vitamin = pasien.id_vitamin order by tgl_vitamin asc";
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

        tgl_vitamin = new javax.swing.JTextField();
        nama_anak = new javax.swing.JTextField();
        ttl = new javax.swing.JTextField();
        nama_ibu = new javax.swing.JTextField();
        id_vitamin = new javax.swing.JTextField();
        usia = new javax.swing.JTextField();
        kelamin = new javax.swing.JTextField();
        jenis = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        simpan = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        ubah = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tgl_vitamin.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        tgl_vitamin.setBorder(null);
        add(tgl_vitamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 198, 140, -1));

        nama_anak.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        nama_anak.setBorder(null);
        add(nama_anak, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 238, 220, -1));

        ttl.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        ttl.setBorder(null);
        ttl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ttlActionPerformed(evt);
            }
        });
        add(ttl, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 284, 220, -1));

        nama_ibu.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        nama_ibu.setBorder(null);
        add(nama_ibu, new org.netbeans.lib.awtextra.AbsoluteConstraints(775, 247, 220, -1));

        id_vitamin.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        id_vitamin.setBorder(null);
        add(id_vitamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 152, 140, 20));

        usia.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        usia.setBorder(null);
        add(usia, new org.netbeans.lib.awtextra.AbsoluteConstraints(775, 201, 40, -1));

        kelamin.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        kelamin.setBorder(null);
        add(kelamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 327, 140, -1));

        jenis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "A (Kapsul Biru)", "A(Kapsul Merah)" }));
        jenis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenisActionPerformed(evt);
            }
        });
        add(jenis, new org.netbeans.lib.awtextra.AbsoluteConstraints(768, 150, 153, 25));

        alamat.setColumns(20);
        alamat.setRows(5);
        jScrollPane1.setViewportView(alamat);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(775, 290, 220, 55));

        simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/sinpan.png"))); // NOI18N
        simpan.setBorder(null);
        simpan.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/sinpan1.png"))); // NOI18N
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });
        add(simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 420, -1, -1));

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

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 840, 120));

        ubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/ubah.png"))); // NOI18N
        ubah.setBorder(null);
        ubah.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/ubah1.png"))); // NOI18N
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });
        add(ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 470, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Vitamin.png"))); // NOI18N
        add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void ttlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ttlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ttlActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        if (jenis.getSelectedItem() == ""  || jenis.getSelectedItem() == "None")
        {
            status = "Belum";
        }
        else
        {
            status = "Sudah";
        }
        try
        {
            sql = "insert into vitamin (id_vitamin,tgl_vitamin,status,keterangan,id_pasien) values ('"+id_vitamin.getText()+"', '"+tgl_vitamin.getText()+"','"+status+"','"+jenis.getSelectedItem()+"','"+pilih_anak.tes.getText()+"')";
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(this,"Data Berhasil Ditambah","Information",JOptionPane.INFORMATION_MESSAGE);
            
            pasienn();
            tampil();
          
        }

        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        try
        {
            sql = "update vitamin set janis = '"+jenis.getSelectedItem()+"', status = '"+status+"'";
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(this,"Data Berhasil Diubah","Information",JOptionPane.INFORMATION_MESSAGE);
            tampil();
            
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_ubahActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        int row = tabel.getSelectedRow();
        id_vitamin.setText(model.getValueAt(row, 1).toString());
        nama_anak.setText(model.getValueAt(row, 3).toString());
        ttl.setText(model.getValueAt(row, 4).toString());
        kelamin.setText(model.getValueAt(row, 5).toString());
        jenis.setSelectedItem(model.getValueAt(row, 6).toString());
        status = (model.getValueAt(row, 7).toString());
        usia.setText(model.getValueAt(row, 8).toString());
        nama_ibu.setText(model.getValueAt(row, 9).toString());
        alamat.setText(model.getValueAt(row, 10).toString());
    }//GEN-LAST:event_tabelMouseClicked

    private void jenisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jenisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jenisActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextArea alamat;
    private javax.swing.JLabel background;
    public static javax.swing.JTextField id_vitamin;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JComboBox<String> jenis;
    public static javax.swing.JTextField kelamin;
    public static javax.swing.JTextField nama_anak;
    public static javax.swing.JTextField nama_ibu;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabel;
    public static javax.swing.JTextField tgl_vitamin;
    public static javax.swing.JTextField ttl;
    private javax.swing.JButton ubah;
    public static javax.swing.JTextField usia;
    // End of variables declaration//GEN-END:variables
}
