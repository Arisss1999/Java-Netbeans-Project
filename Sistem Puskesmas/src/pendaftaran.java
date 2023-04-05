import java.sql.*;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import java.text.SimpleDateFormat;


public class pendaftaran extends javax.swing.JPanel {
    Connection con;
    Statement stm;
    ResultSet rs;
    String sql;
    String kelamin;
    
    DefaultTableModel model;
    TableColumn kolom;
    
    pendaftaran pdf;

    
    public pendaftaran() {
        initComponents();
        koneksi db = new koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
        
        String []th = {"No","ID Pendaftaran","Tanggal Pendaftaran","Nama Anak","Tempat Tanggal Lahir","Jenis Kelamin","Usia","Nama Ibu","Alamat"};
        model = new DefaultTableModel(th, 0);
        tabel_pendaftaran.setModel(model);

        tampil();
        buat_id();
        settanggal();
        
    }
    
    public void reset()
    {
       nama_anak.setText("");
       ttl.setText("");
       usia.setText("");
       nama_ibu.setText("");
       alamat.setText("");
    }
    
    private void buat_id()
    {
        try
        {
            sql = "select * from pasien order by id_pasien desc";
            rs  = stm.executeQuery(sql);
            if(rs.next())
            {
                String a = rs.getString("id_pasien").substring(3);
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
                id_pendaftaran.setText("P" + c + b);
            }
            
            else
            {
                id_pendaftaran.setText("P0001");
            }
        }
        
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public final void settanggal()
    {
        Date buat_tgl           = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        tgl_pendaftaran.setText(String.valueOf(format.format(buat_tgl)));
    }
    
   
    
    public void tampil()
    {
        
        
        int row = tabel_pendaftaran.getRowCount();
        for (int a=0; a<row; a++)
        {
            model.removeRow(0);
        }
        try
        {
            int no=1;
            sql = "select * from pasien where tgl_daftar = '"+tgl_pendaftaran.getText()+"'order by tgl_daftar asc";
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        nama_anak = new javax.swing.JTextField();
        tgl_pendaftaran = new javax.swing.JTextField();
        ttl = new javax.swing.JTextField();
        usia = new javax.swing.JTextField();
        nama_ibu = new javax.swing.JTextField();
        id_pendaftaran = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        kelamin_laki = new javax.swing.JRadioButton();
        kelamin_perempuan = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_pendaftaran = new javax.swing.JTable();
        ubah = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        backgroud = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nama_anak.setBorder(null);
        add(nama_anak, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 236, 230, 20));

        tgl_pendaftaran.setEditable(false);
        tgl_pendaftaran.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        tgl_pendaftaran.setBorder(null);
        add(tgl_pendaftaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 198, 150, -1));

        ttl.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        ttl.setBorder(null);
        add(ttl, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 284, 230, -1));

        usia.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        usia.setBorder(null);
        add(usia, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 153, 50, 20));

        nama_ibu.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        nama_ibu.setBorder(null);
        add(nama_ibu, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 200, 220, 20));

        id_pendaftaran.setEditable(false);
        id_pendaftaran.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        id_pendaftaran.setBorder(null);
        id_pendaftaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_pendaftaranActionPerformed(evt);
            }
        });
        add(id_pendaftaran, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 154, 150, -1));

        alamat.setColumns(20);
        alamat.setFont(new java.awt.Font("Berlin Sans FB", 0, 13)); // NOI18N
        alamat.setRows(5);
        alamat.setBorder(null);
        jScrollPane1.setViewportView(alamat);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 243, 230, 60));

        kelamin_laki.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        kelamin_laki.setText("Laki - laki");
        kelamin_laki.setBorder(null);
        kelamin_laki.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kelamin_lakiMouseClicked(evt);
            }
        });
        kelamin_laki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelamin_lakiActionPerformed(evt);
            }
        });
        add(kelamin_laki, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 325, -1, -1));

        kelamin_perempuan.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        kelamin_perempuan.setText("Perempuan");
        kelamin_perempuan.setBorder(null);
        kelamin_perempuan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                kelamin_perempuanMouseClicked(evt);
            }
        });
        kelamin_perempuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelamin_perempuanActionPerformed(evt);
            }
        });
        add(kelamin_perempuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 325, -1, -1));

        tabel_pendaftaran.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_pendaftaran.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_pendaftaranMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_pendaftaran);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 1020, 100));

        ubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/ubah.png"))); // NOI18N
        ubah.setBorder(null);
        ubah.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/ubah1.png"))); // NOI18N
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });
        add(ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 350, -1, -1));

        simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/sinpan.png"))); // NOI18N
        simpan.setBorder(null);
        simpan.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/sinpan1.png"))); // NOI18N
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });
        add(simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 350, -1, -1));

        backgroud.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/pendaftaran.png"))); // NOI18N
        add(backgroud, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        try
        {
            sql= "insert into pasien (id_pasien,tgl_daftar,nama_anak,ttl,jenis_kelamin,usia,nama_ibu,alamat) values ('"+id_pendaftaran.getText()+"', '"+tgl_pendaftaran.getText()+"', '"+nama_anak.getText()+"','"+ttl.getText()+"','"+kelamin+"','"+usia.getText()+"','"+nama_ibu.getText()+"','"+alamat.getText()+"')";
            
            stm.executeUpdate(sql);
            
            JOptionPane.showMessageDialog(this,"Data Berhasil Ditambah","Information",JOptionPane.INFORMATION_MESSAGE);
            tampil();
            reset();
        }

        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        buat_id();
    }//GEN-LAST:event_simpanActionPerformed

    private void kelamin_perempuanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kelamin_perempuanMouseClicked
       
    }//GEN-LAST:event_kelamin_perempuanMouseClicked

    private void kelamin_lakiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kelamin_lakiMouseClicked
       
    }//GEN-LAST:event_kelamin_lakiMouseClicked

    private void kelamin_lakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelamin_lakiActionPerformed
        kelamin = "Laki-Laki";
        kelamin_perempuan.setSelected(false);
    }//GEN-LAST:event_kelamin_lakiActionPerformed

    private void kelamin_perempuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelamin_perempuanActionPerformed
        kelamin = "Perempuan";
        kelamin_laki.setSelected(false);
    }//GEN-LAST:event_kelamin_perempuanActionPerformed

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
         try
            {
                sql = "update pasien set nama_anak = '"+nama_anak.getText()+"', ttl = '"+ttl.getText()+"', jenis_kelamin = '"+kelamin+"', usia ='"+usia.getText()+"', nama_ibu = '"+nama_ibu.getText()+"' where id_pasien = '"+id_pendaftaran.getText()+"'";
                stm.executeUpdate(sql);
                JOptionPane.showMessageDialog(this,"Data Berhasil Diubah","Information",JOptionPane.INFORMATION_MESSAGE);
                tampil();
                reset();
            }
         catch (Exception e)
         {
             
             JOptionPane.showMessageDialog(null, e.getMessage());
         }
    }//GEN-LAST:event_ubahActionPerformed

    private void tabel_pendaftaranMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_pendaftaranMouseClicked
       
        int row = tabel_pendaftaran.getSelectedRow();
        id_pendaftaran.setText(model.getValueAt(row, 1).toString());
        nama_anak.setText(model.getValueAt(row, 3).toString());
        ttl.setText(model.getValueAt(row, 4).toString());
        String tes = model.getValueAt(row, 5).toString();
        if(tes.equals("Laki-Laki"))
        {
            kelamin_laki.setSelected(true);
        }
        
        else
        {
            kelamin_perempuan.setSelected(true);
        }
        usia.setText(model.getValueAt(row, 6).toString());
        nama_ibu.setText(model.getValueAt(row, 7).toString());
        alamat.setText(model.getValueAt(row, 8).toString());
    }//GEN-LAST:event_tabel_pendaftaranMouseClicked

    private void id_pendaftaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_pendaftaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_pendaftaranActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamat;
    private javax.swing.JLabel backgroud;
    private javax.swing.ButtonGroup buttonGroup1;
    public static javax.swing.JTextField id_pendaftaran;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton kelamin_laki;
    private javax.swing.JRadioButton kelamin_perempuan;
    private javax.swing.JTextField nama_anak;
    private javax.swing.JTextField nama_ibu;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabel_pendaftaran;
    public static javax.swing.JTextField tgl_pendaftaran;
    private javax.swing.JTextField ttl;
    private javax.swing.JButton ubah;
    private javax.swing.JTextField usia;
    // End of variables declaration//GEN-END:variables
}
