import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


public class imunisasi extends javax.swing.JPanel {

    Connection con;
    Statement stm;
    ResultSet rs;
    String sql,sqll;
    public String jenis = "";
    
    DefaultTableModel model;
    TableColumn kolom;
    
    
    
    public imunisasi() {
        initComponents();
        
        koneksi db = new koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
        
        String []th = {"No","ID Imunisasi","Tanggal Imunisasi","Nama Anak","Tempat Tanggal Lahir","Jenis Kelamin","Usia","Jenis Imunisasi","Nama Ibu","Alamat"};
        model = new DefaultTableModel(th, 0);
        tabel.setModel(model);
        
        
        
        tampil();
        buat_id();
        
    }
    public void pasienn()
    {
        try
        {
            sql="update pasien set id_imunisasi = '"+id_imunisasi.getText()+"' where id_pasien = '"+pilih_anak.tes.getText()+"'";
            stm.executeUpdate(sql);
        }
        
        catch(Exception e)
        {
            
        }
    }
     private void buat_id()
    {
        try
        {
            sql = "select * from imunisasi order by id_imunisasi desc";
            rs  = stm.executeQuery(sql);
            if(rs.next())
            {
                String a = rs.getString("id_imunisasi").substring(2);
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
                id_imunisasi.setText("IM" + c + b);
            }
            
            else
            {
                id_imunisasi.setText("IM0001");
            }
        }
        
        catch (Exception e)
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
            sql = "select * from pasien inner join imunisasi using (id_imunisasi) order by id_imunisasi asc";
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
     
     public void reset()
    {
       imunisasi.setSelectedItem("");
       
    }
     
     
     
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tgl_imunisasi = new javax.swing.JTextField();
        nama_anak = new javax.swing.JTextField();
        kelamin = new javax.swing.JTextField();
        usia = new javax.swing.JTextField();
        nama_ibu = new javax.swing.JTextField();
        id_imunisasi = new javax.swing.JTextField();
        ttl = new javax.swing.JTextField();
        imunisasi = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        simpan = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        ubah = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tgl_imunisasi.setEditable(false);
        tgl_imunisasi.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        tgl_imunisasi.setBorder(null);
        add(tgl_imunisasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 195, 140, -1));

        nama_anak.setEditable(false);
        nama_anak.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        nama_anak.setBorder(null);
        nama_anak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_anakActionPerformed(evt);
            }
        });
        add(nama_anak, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 235, 220, -1));

        kelamin.setEditable(false);
        kelamin.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        kelamin.setBorder(null);
        add(kelamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 325, 230, -1));

        usia.setEditable(false);
        usia.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        usia.setBorder(null);
        add(usia, new org.netbeans.lib.awtextra.AbsoluteConstraints(775, 198, 40, -1));

        nama_ibu.setEditable(false);
        nama_ibu.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        nama_ibu.setBorder(null);
        add(nama_ibu, new org.netbeans.lib.awtextra.AbsoluteConstraints(775, 244, 220, -1));

        id_imunisasi.setEditable(false);
        id_imunisasi.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        id_imunisasi.setBorder(null);
        id_imunisasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_imunisasiActionPerformed(evt);
            }
        });
        add(id_imunisasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 151, 140, -1));

        ttl.setEditable(false);
        ttl.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        ttl.setBorder(null);
        add(ttl, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 220, -1));

        imunisasi.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        imunisasi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "None", "Campak", "DPT", "Folio", "Hepatitis", "Rubela" }));
        imunisasi.setBorder(null);
        imunisasi.setCursor(new java.awt.Cursor(java.awt.Cursor.NE_RESIZE_CURSOR));
        imunisasi.setPreferredSize(new java.awt.Dimension(76, 22));
        imunisasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imunisasiActionPerformed(evt);
            }
        });
        add(imunisasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 151, 150, -1));

        alamat.setEditable(false);
        alamat.setColumns(20);
        alamat.setRows(5);
        alamat.setBorder(null);
        jScrollPane1.setViewportView(alamat);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(775, 288, 220, 60));

        simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/sinpan.png"))); // NOI18N
        simpan.setBorder(null);
        simpan.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/sinpan1.png"))); // NOI18N
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });
        add(simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 360, -1, -1));

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

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 950, 150));

        ubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/ubah.png"))); // NOI18N
        ubah.setBorder(null);
        ubah.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/ubah1.png"))); // NOI18N
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });
        add(ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 360, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/imunisasi.png"))); // NOI18N
        add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void imunisasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imunisasiActionPerformed
        if (imunisasi.getSelectedIndex() == 1)
        {
            jenis = "Campak";
        }
        else if (imunisasi.getSelectedIndex() == 2)
        {
            jenis = "DPT";
        }
        else if (imunisasi.getSelectedIndex() == 3) 
        {
            jenis = "Folio";
        }
        else if (imunisasi.getSelectedIndex() == 4) 
        {
            jenis = "Hepatitis";
        }
        else if (imunisasi.getSelectedIndex() == 5) 
        {
            jenis = "Rubela";
        }
        else 
        {
            jenis = "None";
        }
           
    }//GEN-LAST:event_imunisasiActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        try
        {
            sql = "insert into imunisasi (id_imunisasi,tgl_imunisasi,jenis_imunisasi,id_pasien) values ('"+id_imunisasi.getText()+"', '"+tgl_imunisasi.getText()+"', '"+jenis+"','"+pilih_anak.tes.getText()+"')";
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

    private void id_imunisasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_imunisasiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_imunisasiActionPerformed

    private void nama_anakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_anakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_anakActionPerformed

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        try
        {
            sql = "update imunisasi set janis_imunisasi = '"+jenis+"'";
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
        id_imunisasi.setText(model.getValueAt(row, 1).toString());
        nama_anak.setText(model.getValueAt(row, 3).toString());
        ttl.setText(model.getValueAt(row, 4).toString());
        kelamin.setText(model.getValueAt(row, 5).toString());
        usia.setText(model.getValueAt(row, 6).toString());
        jenis = (model.getValueAt(row, 7).toString());
        nama_ibu.setText(model.getValueAt(row, 8).toString());
        alamat.setText(model.getValueAt(row, 9).toString());
    }//GEN-LAST:event_tabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextArea alamat;
    private javax.swing.JLabel background;
    public static javax.swing.JTextField id_imunisasi;
    private javax.swing.JComboBox<String> imunisasi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextField kelamin;
    public static javax.swing.JTextField nama_anak;
    public static javax.swing.JTextField nama_ibu;
    private javax.swing.JButton simpan;
    private javax.swing.JTable tabel;
    public static javax.swing.JTextField tgl_imunisasi;
    public static javax.swing.JTextField ttl;
    private javax.swing.JButton ubah;
    public static javax.swing.JTextField usia;
    // End of variables declaration//GEN-END:variables
}
