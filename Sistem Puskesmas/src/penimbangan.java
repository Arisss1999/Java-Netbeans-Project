import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class penimbangan extends javax.swing.JPanel {

    Connection con;
    Statement stm;
    ResultSet rs;
    String sql;
    
    
    DefaultTableModel model;
    TableColumn kolom;
    
    
    
    public penimbangan() {
        initComponents();
        koneksi db = new koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
        
        String []th = {"No","ID Penimbangan","Tanggal Penimbangan","Nama Anak","Tempat Tanggal Lahir","Jenis Kelamin","Usia","Lingkar Lengan","Tinggi Badan","Berat Badan","Nama Ibu","Alamat"};
        model = new DefaultTableModel(th, 0);
        tabel_penimbangan.setModel(model);
        
        
        tampil();
        buat_id();
    }
    
    
    private void buat_id()
    {
        try
        {
            sql = "select * from penimbangan order by id_penimbangan desc";
            rs  = stm.executeQuery(sql);
            if(rs.next())
            {
                String a = rs.getString("id_penimbangan").substring(2);
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
                id_penimbangan.setText("PN" + c + b);
            }
            
            else
            {
                id_penimbangan.setText("PN0001");
            }
        }
        
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void penimbangann()
    {
        try
        {
            sql = "insert into penimbangan (id_penimbangan, lingkar_lengan,tinggi,berat,tanggal_penimbangan,id_pasien) values ('"+id_penimbangan.getText()+"', '"+lingkar_lengan.getText()+"', '"+tinggi.getText()+"','"+berat.getText()+"','"+tgl_penimbangan.getText()+"','"+pilih_anak.tes.getText()+"')";
            stm.executeUpdate(sql);
        }
        catch(Exception e)
        {
            
        }
    }
    
    public void pasienn()
    {
        try
        {
            sql="update pasien set id_penimbangan = '"+id_penimbangan.getText()+"' where id_pasien = '"+pilih_anak.tes.getText()+"'";
            stm.executeUpdate(sql);
        }
        
        catch(Exception e)
        {
            
        }
    }
    
    public void tampil()
    {
        int row = tabel_penimbangan.getRowCount();
        for (int a=0; a<row; a++)
        {
            model.removeRow(0);
        }
        try
        {
            int no=1;
            sql = "select * from pasien inner join penimbangan using (id_penimbangan) order by id_penimbangan asc";
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
    
    public void reset()
    {
       lingkar_lengan.setText("");
       tinggi.setText("");
       berat.setText("");
    }
    
     

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nama_ibu = new javax.swing.JTextField();
        tgl_penimbangan = new javax.swing.JTextField();
        id_penimbangan = new javax.swing.JTextField();
        nama_anak = new javax.swing.JTextField();
        kelamin = new javax.swing.JTextField();
        usia = new javax.swing.JTextField();
        lingkar_lengan = new javax.swing.JTextField();
        tinggi = new javax.swing.JTextField();
        berat = new javax.swing.JTextField();
        ttl = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_penimbangan = new javax.swing.JTable();
        simpan = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        background = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nama_ibu.setEditable(false);
        nama_ibu.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        nama_ibu.setBorder(null);
        nama_ibu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_ibuActionPerformed(evt);
            }
        });
        add(nama_ibu, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 287, 220, 20));

        tgl_penimbangan.setEditable(false);
        tgl_penimbangan.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        tgl_penimbangan.setBorder(null);
        add(tgl_penimbangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 195, 140, 20));

        id_penimbangan.setEditable(false);
        id_penimbangan.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        id_penimbangan.setBorder(null);
        id_penimbangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_penimbanganActionPerformed(evt);
            }
        });
        add(id_penimbangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 152, 140, 20));

        nama_anak.setEditable(false);
        nama_anak.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        nama_anak.setBorder(null);
        add(nama_anak, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 235, 220, 20));

        kelamin.setEditable(false);
        kelamin.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        kelamin.setBorder(null);
        kelamin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kelaminActionPerformed(evt);
            }
        });
        add(kelamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 322, 120, 20));

        usia.setEditable(false);
        usia.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        usia.setBorder(null);
        add(usia, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 367, 50, 20));

        lingkar_lengan.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        lingkar_lengan.setBorder(null);
        add(lingkar_lengan, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 155, 50, 20));

        tinggi.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        tinggi.setBorder(null);
        add(tinggi, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 199, 50, 20));

        berat.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        berat.setBorder(null);
        add(berat, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 241, 50, 20));

        ttl.setEditable(false);
        ttl.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        ttl.setBorder(null);
        add(ttl, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 282, 220, 20));

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jLabel2.setText("Lingkar Lengan");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 150, -1, -1));

        jScrollPane1.setBorder(null);
        jScrollPane1.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N

        alamat.setEditable(false);
        alamat.setColumns(20);
        alamat.setRows(5);
        jScrollPane1.setViewportView(alamat);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 330, 230, 60));

        tabel_penimbangan.setModel(new javax.swing.table.DefaultTableModel(
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
        tabel_penimbangan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_penimbanganMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_penimbangan);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 910, 180));

        simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/sinpan.png"))); // NOI18N
        simpan.setBorder(null);
        simpan.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/sinpan1.png"))); // NOI18N
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });
        add(simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 430, -1, -1));

        ubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/ubah.png"))); // NOI18N
        ubah.setBorder(null);
        ubah.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/ubah1.png"))); // NOI18N
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });
        add(ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 470, -1, -1));

        jTextField1.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jTextField1.setText("Penimbangan");
        jTextField1.setBorder(null);
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(85, 149, 120, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/penimbangan.png"))); // NOI18N
        add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void nama_ibuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_ibuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_ibuActionPerformed

    private void id_penimbanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_penimbanganActionPerformed
        
    }//GEN-LAST:event_id_penimbanganActionPerformed

    private void kelaminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kelaminActionPerformed
     
    }//GEN-LAST:event_kelaminActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        penimbangann();
        pasienn();
            JOptionPane.showMessageDialog(this,"Data Berhasil Ditambah","Information",JOptionPane.INFORMATION_MESSAGE);
            tampil();
            reset();
    }//GEN-LAST:event_simpanActionPerformed

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        try
        {
            sql = "update penimbangan set lingkar_lengan = '"+lingkar_lengan.getText()+"', tinggi = '"+tinggi.getText()+"', berat = '"+berat+"'";
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

    private void tabel_penimbanganMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_penimbanganMouseClicked
       
        int row = tabel_penimbangan.getSelectedRow();
        id_penimbangan.setText(model.getValueAt(row, 1).toString());
        nama_anak.setText(model.getValueAt(row, 3).toString());
        ttl.setText(model.getValueAt(row, 4).toString());
        kelamin.setText(model.getValueAt(row, 5).toString());
        usia.setText(model.getValueAt(row, 6).toString());
        lingkar_lengan.setText(model.getValueAt(row, 7).toString());
        tinggi.setText(model.getValueAt(row, 8).toString());
        berat.setText(model.getValueAt(row, 9).toString());
        nama_ibu.setText(model.getValueAt(row, 10).toString());
        alamat.setText(model.getValueAt(row, 11).toString());
    }//GEN-LAST:event_tabel_penimbanganMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextArea alamat;
    public static javax.swing.JLabel background;
    private javax.swing.JTextField berat;
    public static javax.swing.JTextField id_penimbangan;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    public static javax.swing.JTextField kelamin;
    private javax.swing.JTextField lingkar_lengan;
    public static javax.swing.JTextField nama_anak;
    public static javax.swing.JTextField nama_ibu;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabel_penimbangan;
    public static javax.swing.JTextField tgl_penimbangan;
    private javax.swing.JTextField tinggi;
    public static javax.swing.JTextField ttl;
    private javax.swing.JButton ubah;
    public static javax.swing.JTextField usia;
    // End of variables declaration//GEN-END:variables
}
