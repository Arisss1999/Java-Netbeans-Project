import java.sql.*;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.*;
import java.text.SimpleDateFormat;

public class kematian extends javax.swing.JPanel {

    Connection con;
    Statement stm;
    ResultSet rs;
    String sql;
    String kelamin;
    String tgl;
    
    DefaultTableModel model;
    TableColumn kolom;
    
    
    public kematian() {
        initComponents();
         koneksi db = new koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
        
        String []th = {"No","ID Kematian","Tanggal Kematian","Nama Anak","Tempat Tanggal Lahir","Jenis Kelamin","Usia","Nama Ibu","Alamat","Keterangan Kematian"};
        model = new DefaultTableModel(th, 0);
        tabel.setModel(model);
        
        buat_id();
        tampil();
    }

     public void reset()
    {
       
       nama_anak.setText("");
       ttl.setText("");
       usia.setText("");
       nama_ibu.setText("");
       alamat.setText("");
       keterangan.setText("");
    }
     
     private void buat_id()
    {
        try
        {
            sql = "select * from kematian order by id_kematian desc";
            rs  = stm.executeQuery(sql);
            if(rs.next())
            {
                String a = rs.getString("id_kematian").substring(2);
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
                id_kematian.setText("KM" + c + b);
            }
            
            else
            {
                id_kematian.setText("KM0001");
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
            sql="update pasien set id_kematian = '"+id_kematian.getText()+"' where id_pasien = '"+pilih_anak.tes.getText()+"'";
            stm.executeUpdate(sql);
        }
        
        catch(Exception e)
        {
            
        }
    }
    public void tampil()
    {
        ubah.setVisible(false);
        simpan.setVisible(true);
        
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nama_anak = new javax.swing.JTextField();
        ttl = new javax.swing.JTextField();
        usia = new javax.swing.JTextField();
        nama_ibu = new javax.swing.JTextField();
        id_kematian = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        keterangan = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        tgl_kematian = new com.toedter.calendar.JDateChooser();
        kelamin_laki = new javax.swing.JRadioButton();
        kelamin_perempuan = new javax.swing.JRadioButton();
        ubah = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tes = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nama_anak.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        nama_anak.setBorder(null);
        add(nama_anak, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 234, 220, 20));

        ttl.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        ttl.setBorder(null);
        add(ttl, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 220, 20));

        usia.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        usia.setBorder(null);
        add(usia, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 154, 40, 20));

        nama_ibu.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        nama_ibu.setBorder(null);
        add(nama_ibu, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 200, 210, 20));

        id_kematian.setEditable(false);
        id_kematian.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        id_kematian.setBorder(null);
        add(id_kematian, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 152, 140, 20));

        keterangan.setColumns(20);
        keterangan.setRows(5);
        keterangan.setBorder(null);
        jScrollPane1.setViewportView(keterangan);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 307, 230, 50));

        alamat.setColumns(20);
        alamat.setRows(5);
        alamat.setBorder(null);
        jScrollPane2.setViewportView(alamat);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 240, 230, 50));

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
        jScrollPane3.setViewportView(tabel);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 870, 120));

        tgl_kematian.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tgl_kematianPropertyChange(evt);
            }
        });
        add(tgl_kematian, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 160, 30));

        kelamin_laki.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        kelamin_laki.setText("Laki - Laki");
        kelamin_laki.setBorder(null);
        add(kelamin_laki, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 328, -1, -1));

        kelamin_perempuan.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        kelamin_perempuan.setText("Perempuan");
        kelamin_perempuan.setBorder(null);
        add(kelamin_perempuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 328, -1, -1));

        ubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/ubah.png"))); // NOI18N
        ubah.setBorder(null);
        ubah.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/ubah1.png"))); // NOI18N
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });
        add(ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 420, -1, -1));

        simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/sinpan.png"))); // NOI18N
        simpan.setBorder(null);
        simpan.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/sinpan1.png"))); // NOI18N
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });
        add(simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 420, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/kematian.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        tes.setText("jTextField1");
        add(tes, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void tgl_kematianPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tgl_kematianPropertyChange
        if(tgl_kematian.getDate() != null)
        {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            tgl     = String.valueOf(format.format(tgl_kematian.getDate()));
            tgl_kematian.setDateFormatString("dd-MM-yyyy");
        }
    }//GEN-LAST:event_tgl_kematianPropertyChange

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        try
        {
            sql = "insert into kematian (id_kematian,tanggal_kematian,nama_anak,ttl,kelamin,usia,nama_ibu,alamat,keterangan,id_pasien) values ('"+id_kematian.getText()+"', '"+tgl+"', '"+nama_anak.getText()+"','"+ttl.getText()+"','"+kelamin+"','"+usia.getText()+"','"+nama_ibu.getText()+"','"+alamat.getText()+"','"+keterangan.getText()+"','"+pilih_anak.tes.getText()+"')";
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(this,"Data Berhasil Ditambah","Information",JOptionPane.INFORMATION_MESSAGE);
            pasienn();
            tampil();
            reset();
        }

        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        ubah.setVisible(true);
        simpan.setVisible(false);
        
        int row = tabel.getSelectedRow();
        id_kematian.setText(model.getValueAt(row, 1).toString());
        tgl_kematian.setDateFormatString(model.getValueAt(row, 2).toString());
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
        keterangan.setText(model.getValueAt(row, 9).toString());
    }//GEN-LAST:event_tabelMouseClicked

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ubahActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamat;
    private javax.swing.JTextField id_kematian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton kelamin_laki;
    private javax.swing.JRadioButton kelamin_perempuan;
    private javax.swing.JTextArea keterangan;
    private javax.swing.JTextField nama_anak;
    private javax.swing.JTextField nama_ibu;
    public static javax.swing.JButton simpan;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField tes;
    private com.toedter.calendar.JDateChooser tgl_kematian;
    private javax.swing.JTextField ttl;
    public static javax.swing.JButton ubah;
    private javax.swing.JTextField usia;
    // End of variables declaration//GEN-END:variables
}
