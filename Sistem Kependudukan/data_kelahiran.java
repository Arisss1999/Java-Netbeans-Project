import java.sql.*;
import java.util.Date;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;


public class data_kelahiran extends javax.swing.JFrame {

    Connection con;
    Statement stm;
    ResultSet rs;
    String sql;
    String kelamin;
    String tgl,tgll;
    
    public data_kelahiran() {
        initComponents();
        
        koneksi db = new koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
        
        no_surat();
        set_tanggal();
    }
    
    public final void set_tanggal()
    {
        Date buat_tgl           = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        tgl_surat.setText(String.valueOf(format.format(buat_tgl)));
    }
   private void reset ()
   {
            no_surat.setText("");
            tgl_surat.setText("");
            jam_lahir.setText("");
            anak_ke.setText("");
            nama_anak.setText("");
            nama_kepala.setText("");
            nik.setText("");
            nama_ibu.setText("");
            tempat_lahir.setText("");
            pekerjaan.setText("");
            alamat.setText("");
            hub_keluarga.setText("");
            agama.setText("");
            no_kk.setText("");
            tgl_lahir.setDate(null);
            tgl_lahir.setDate(null);
   }
    private void no_surat()
    {
        try
        {
            sql = "select * from kelahiran order by no_surat desc";
            rs  = stm.executeQuery(sql);
            if(rs.next())
            {
                String a = rs.getString("no_surat").substring(2);
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
                no_surat.setText("SL" + c + b);
            }
            
            else
            {
                no_surat.setText("SL0001");
            }
        }
        
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
   public void reset_ibu ()
   {
       
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nama_kepala = new javax.swing.JTextField();
        no_surat = new javax.swing.JTextField();
        nik = new javax.swing.JTextField();
        tgl_surat = new javax.swing.JTextField();
        no_kk = new javax.swing.JTextField();
        tempat_lahir = new javax.swing.JTextField();
        hub_keluarga = new javax.swing.JTextField();
        jam_lahir = new javax.swing.JTextField();
        nama_ibu = new javax.swing.JTextField();
        pekerjaan = new javax.swing.JTextField();
        agama = new javax.swing.JTextField();
        nama_anak = new javax.swing.JTextField();
        anak_ke = new javax.swing.JTextField();
        tgl_lahir = new com.toedter.calendar.JDateChooser();
        tgl_anak = new com.toedter.calendar.JDateChooser();
        laki = new javax.swing.JRadioButton();
        perempuan = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        batal = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nama_kepala.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        nama_kepala.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(nama_kepala, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 86, 180, 30));

        no_surat.setEditable(false);
        no_surat.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        no_surat.setBorder(null);
        getContentPane().add(no_surat, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 87, 130, 30));

        nik.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        nik.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nik.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nikKeyReleased(evt);
            }
        });
        getContentPane().add(nik, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 213, 190, 30));

        tgl_surat.setEditable(false);
        tgl_surat.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        tgl_surat.setBorder(null);
        getContentPane().add(tgl_surat, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 130, 30));

        no_kk.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        no_kk.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(no_kk, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, 180, 30));

        tempat_lahir.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        tempat_lahir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(tempat_lahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 280, 70, 30));

        hub_keluarga.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        hub_keluarga.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(hub_keluarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 398, 190, 30));

        jam_lahir.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jam_lahir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(jam_lahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 314, 110, 30));

        nama_ibu.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        nama_ibu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(nama_ibu, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 246, 190, 30));

        pekerjaan.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        pekerjaan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(pekerjaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 313, 190, 30));

        agama.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        agama.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(agama, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 381, 200, 30));

        nama_anak.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        nama_anak.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(nama_anak, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 213, 200, 30));

        anak_ke.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        anak_ke.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(anak_ke, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 348, 200, 30));

        tgl_lahir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tgl_lahir.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tgl_lahirPropertyChange(evt);
            }
        });
        getContentPane().add(tgl_lahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(911, 280, 100, 30));

        tgl_anak.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tgl_anak.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        tgl_anak.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tgl_anakPropertyChange(evt);
            }
        });
        getContentPane().add(tgl_anak, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 200, 30));

        laki.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        laki.setText("Laki - Laki");
        laki.setBorder(null);
        laki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lakiActionPerformed(evt);
            }
        });
        getContentPane().add(laki, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 250, 90, 20));

        perempuan.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        perempuan.setText("Perempuan");
        perempuan.setBorder(null);
        perempuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perempuanActionPerformed(evt);
            }
        });
        getContentPane().add(perempuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 90, 20));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        alamat.setColumns(20);
        alamat.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        alamat.setRows(5);
        alamat.setBorder(null);
        jScrollPane1.setViewportView(alamat);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 350, 190, 40));

        batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Batal.png"))); // NOI18N
        batal.setBorder(null);
        batal.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Batal1.png"))); // NOI18N
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });
        getContentPane().add(batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 460, -1, -1));

        simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Simpan.png"))); // NOI18N
        simpan.setBorder(null);
        simpan.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Simpan1.png"))); // NOI18N
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });
        getContentPane().add(simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 460, -1, -1));

        ubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/ubah.png"))); // NOI18N
        ubah.setBorder(null);
        ubah.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/ubah1.png"))); // NOI18N
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });
        getContentPane().add(ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 460, -1, -1));

        jLabel1.setText("/");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 290, 10, -1));

        background.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Panel Kelahiran.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lakiActionPerformed
        perempuan.setSelected(false);
        kelamin = "Laki - Laki";
    }//GEN-LAST:event_lakiActionPerformed

    private void nikKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nikKeyReleased
        if(nik.getText().equals (""))
        {
                 nama_ibu.setText("");
                 pekerjaan.setText("");
                 alamat.setText("");
                 tempat_lahir.setText("");
                 tgl_lahir.setDate(null);
        }
        else
        {
            try
            {
            
                sql = "select * from identitas_penduduk where nik  = '"+nik.getText()+"' order by nik asc";
                rs  = stm.executeQuery(sql);
                while(rs.next())
                {   
                     nama_ibu.setText(rs.getString("nama"));
                     pekerjaan.setText(rs.getString("pekerjaan"));
                     alamat.setText(rs.getString("alamat"));
                     tempat_lahir.setText(rs.getString("tempat_lahir"));
                     java.util.Date ini_tanggal = new SimpleDateFormat("dd-MM-yyyy").parse((String)rs.getString("tanggal_lahir"));
                     tgl_lahir.setDate(ini_tanggal);
                }
            }
        
            catch (Exception e)
            {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
        
    }//GEN-LAST:event_nikKeyReleased

    private void tgl_lahirPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tgl_lahirPropertyChange
        if (tgl_lahir.getDate() != null) {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            tgl_lahir.setDateFormatString("dd-MM-yyyy");
            tgl = String.valueOf(format.format (tgl_lahir.getDate()));
        }
    }//GEN-LAST:event_tgl_lahirPropertyChange

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
       
        try
       {
         sql = "insert into kelahiran (no_surat, tgl_surat, kelamin, tgl_lahir_anak, jam_lahir, anak_ke, nama_anak, nama_kepala, nik, nama_ibu, tgl_lahir_ibu, tempat_lahir, pekerjaan, alamat, hub_keluarga, no_kk, agama) values ('"+no_surat.getText()+"', '"+tgl_surat.getText()+"', '" +kelamin+"', '"+tgll+"', '"+jam_lahir.getText()+"', '"+anak_ke.getText()+"', '"+nama_anak.getText()+"', '"+nama_kepala.getText()+"', '"+nik.getText()+"', '"+nama_ibu.getText()+"', '"+tgl+"', '"+tempat_lahir.getText()+"', '"+pekerjaan.getText()+"', '"+alamat.getText()+"', '"+hub_keluarga.getText()+"', '"+no_kk.getText()+"', '"+agama.getText()+"')"; 
        
         stm.executeUpdate(sql);
         JOptionPane.showMessageDialog(this,"Data Berhasil Ditambah","Information",JOptionPane.INFORMATION_MESSAGE);
                
         no_surat();
         kelahiran.refresh.doClick();
         this.dispose();
       }
       catch(Exception e) 
       {
             JOptionPane.showMessageDialog(this, e.getMessage());
       }
    }//GEN-LAST:event_simpanActionPerformed

    private void perempuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perempuanActionPerformed
        laki.setSelected(false);
        kelamin = "Perempuan";
    }//GEN-LAST:event_perempuanActionPerformed

    private void tgl_anakPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tgl_anakPropertyChange
       if (tgl_anak.getDate() != null) {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            tgl_anak.setDateFormatString("dd-MM-yyyy");
            tgll = String.valueOf(format.format (tgl_anak.getDate()));
        }
    }//GEN-LAST:event_tgl_anakPropertyChange

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        this.dispose();
    }//GEN-LAST:event_batalActionPerformed

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        try
       {
         sql = "update kelahiran set kelamin = '"+kelamin+"', tgl_lahir_anak = '"+tgll+"', jam_lahir = '"+jam_lahir.getText()+"', anak_ke = '"+anak_ke.getText()+"', nama_anak = '"+nama_anak.getText()+"', nama_kepala = '"+nama_kepala.getText()+"', nik = '"+nik.getText()+"', nama_ibu = '"+nama_ibu.getText()+"', tgl_lahir_ibu = '"+tgl+"', tempat_lahir = '"+tempat_lahir.getText()+"', pekerjaan = '"+pekerjaan.getText()+"', alamat = '"+alamat.getText()+"', hub_keluarga = '"+hub_keluarga.getText()+"', agama = '"+agama.getText()+"', no_kk = '"+no_kk.getText()+"' Where no_surat = '"+kelahiran.tes.getText()+"' ";  
         stm.executeUpdate(sql);
         JOptionPane.showMessageDialog(this,"Data Berhasil Di Ubah","Information",JOptionPane.INFORMATION_MESSAGE);
                
         kelahiran.refresh.doClick();
         this.dispose();
       }
       catch(Exception e) 
       {
             JOptionPane.showMessageDialog(this, e.getMessage());
       }
    }//GEN-LAST:event_ubahActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(data_kelahiran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(data_kelahiran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(data_kelahiran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(data_kelahiran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new data_kelahiran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField agama;
    public static javax.swing.JTextArea alamat;
    public static javax.swing.JTextField anak_ke;
    private javax.swing.JLabel background;
    private javax.swing.JButton batal;
    public static javax.swing.JTextField hub_keluarga;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField jam_lahir;
    public static javax.swing.JRadioButton laki;
    public static javax.swing.JTextField nama_anak;
    public static javax.swing.JTextField nama_ibu;
    public static javax.swing.JTextField nama_kepala;
    public static javax.swing.JTextField nik;
    public static javax.swing.JTextField no_kk;
    public static javax.swing.JTextField no_surat;
    public static javax.swing.JTextField pekerjaan;
    public static javax.swing.JRadioButton perempuan;
    public static javax.swing.JButton simpan;
    public static javax.swing.JTextField tempat_lahir;
    public static com.toedter.calendar.JDateChooser tgl_anak;
    public static com.toedter.calendar.JDateChooser tgl_lahir;
    public static javax.swing.JTextField tgl_surat;
    public static javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
