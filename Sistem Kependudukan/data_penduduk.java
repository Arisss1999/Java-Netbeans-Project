import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;


public class data_penduduk extends javax.swing.JFrame {

    Connection con;
    Statement stm;
    ResultSet rs;
    String sql;
    String tgl;
    String kelamin;
    String gol;
        
    public data_penduduk() 
    {
        initComponents();
    
        koneksi db = new koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
    }

    public void combobox()
    {
        darah.setSelectedItem("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pendidikan = new javax.swing.JTextField();
        nik = new javax.swing.JTextField();
        kode_pos = new javax.swing.JTextField();
        nama_ibu = new javax.swing.JTextField();
        alamat = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        agama = new javax.swing.JTextField();
        no_kk = new javax.swing.JTextField();
        pekerjaan = new javax.swing.JTextField();
        nama_ayah = new javax.swing.JTextField();
        hubungan_keluarga = new javax.swing.JTextField();
        tempat_lahir = new javax.swing.JTextField();
        negara = new javax.swing.JTextField();
        tgl_lahir = new com.toedter.calendar.JDateChooser();
        darah = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        laki = new javax.swing.JRadioButton();
        perempuan = new javax.swing.JRadioButton();
        status = new javax.swing.JTextField();
        simpan = new javax.swing.JButton();
        batal = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pendidikan.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        pendidikan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(pendidikan, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 198, 150, 30));

        nik.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        nik.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(nik, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 132, 260, 30));

        kode_pos.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        kode_pos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(kode_pos, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 120, 30));

        nama_ibu.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        nama_ibu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(nama_ibu, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 266, 260, 30));

        alamat.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        alamat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(alamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 266, 260, 30));

        nama.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        nama.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 166, 260, 30));

        agama.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        agama.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(agama, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 165, 150, 30));

        no_kk.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        no_kk.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(no_kk, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 98, 260, 30));

        pekerjaan.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        pekerjaan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(pekerjaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 97, 250, 30));

        nama_ayah.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        nama_ayah.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(nama_ayah, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 233, 260, 30));

        hubungan_keluarga.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        hubungan_keluarga.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(hubungan_keluarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 335, 150, 30));

        tempat_lahir.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        tempat_lahir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(tempat_lahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 199, 80, 30));

        negara.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        negara.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(negara, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 300, 150, 30));

        tgl_lahir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tgl_lahir.setDateFormatString("MMM dd,yyyy");
        tgl_lahir.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tgl_lahirPropertyChange(evt);
            }
        });
        getContentPane().add(tgl_lahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 199, 150, 30));

        darah.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        darah.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih -", "A", "B", "O", "AB" }));
        darah.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        darah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                darahActionPerformed(evt);
            }
        });
        getContentPane().add(darah, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 132, 80, 30));

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel1.setText("Hubungan Keluarga      :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 340, -1, -1));

        laki.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        laki.setText("Laki - Laki");
        laki.setBorder(null);
        laki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lakiActionPerformed(evt);
            }
        });
        getContentPane().add(laki, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 238, -1, 20));

        perempuan.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        perempuan.setText("Perempuan");
        perempuan.setBorder(null);
        perempuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perempuanActionPerformed(evt);
            }
        });
        getContentPane().add(perempuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 238, -1, 20));

        status.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        status.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 334, 120, 30));

        simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Simpan.png"))); // NOI18N
        simpan.setBorder(null);
        simpan.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Simpan1.png"))); // NOI18N
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });
        getContentPane().add(simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, -1, -1));

        batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Batal.png"))); // NOI18N
        batal.setBorder(null);
        batal.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Batal1.png"))); // NOI18N
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });
        getContentPane().add(batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 440, -1, -1));

        ubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/ubah.png"))); // NOI18N
        ubah.setBorder(null);
        ubah.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/ubah1.png"))); // NOI18N
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });
        getContentPane().add(ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Panel Penduduk.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        this.dispose();
    }//GEN-LAST:event_batalActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        if (hubungan_keluarga.getText() == "") {
                JOptionPane.showMessageDialog(null, "Mohon Lengkapi Data !");
        }
        else {
            try
            {
                sql = "insert into identitas_penduduk (no_kk,nik,nama,kelamin,tempat_lahir,tanggal_lahir,agama,pendidikan,pekerjaan,hubungan_keluarga,kewarganegaraan,nama_ayah,nama_ibu,status,alamat,gol_darah,kode_pos) values ('"+no_kk.getText()+"', '"+nik.getText()+"', '"+nama.getText()+"','"+kelamin+"', '"+tempat_lahir.getText()+"', '"+tgl+"', '"+agama.getText()+"', '"+pendidikan.getText()+"', '"+pekerjaan.getText()+"', '"+hubungan_keluarga.getText()+"', '"+negara.getText()+"', '"+nama_ayah.getText()+"', '"+nama_ibu.getText()+"', '"+status.getText()+"', '"+alamat.getText()+"', '"+gol+"', '"+kode_pos.getText()+"')";
                stm.executeUpdate(sql);
                JOptionPane.showMessageDialog(this,"Data Berhasil Ditambah","Information",JOptionPane.INFORMATION_MESSAGE);
                
                this.dispose();
                penduduk.refresh.doClick();
            }

            catch(Exception e)
            {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void lakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lakiActionPerformed
        kelamin = "Laki - Laki";
        perempuan.setSelected(false);
    }//GEN-LAST:event_lakiActionPerformed

    private void perempuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perempuanActionPerformed
        kelamin = "Perempuan";
        laki.setSelected(false);
    }//GEN-LAST:event_perempuanActionPerformed

    private void darahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_darahActionPerformed
       
        if (darah.getSelectedItem() == "A"){
            gol = "A";
        }
        else if (darah.getSelectedItem() == "B"){
            gol = "B";
        }
        else if (darah.getSelectedItem() == "O"){
            gol = "O";
        }
        else if (darah.getSelectedItem() == "AB"){
            gol = "AB";
        }
        else    
        {
            JOptionPane.showMessageDialog(this ,"Pilih Golongan Darah");
        }
    }//GEN-LAST:event_darahActionPerformed

    private void tgl_lahirPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tgl_lahirPropertyChange
        if(tgl_lahir.getDate() != null)
        {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            tgl     = String.valueOf(format.format(tgl_lahir.getDate()));
            tgl_lahir.setDateFormatString("dd-MM-yyyy");
        }
    }//GEN-LAST:event_tgl_lahirPropertyChange

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        try
            {
                sql = "update identitas_penduduk set no_kk = '"+no_kk.getText()+"', nik = '"+nik.getText()+"', kelamin = '"+kelamin+"', nama ='"+nama.getText()+"', nama_ibu = '"+nama_ibu.getText()+"', nama_ayah = '"+nama_ayah.getText()+"', kewarganegaraan = '"+negara.getText()+"', status = '"+status.getText()+"', alamat = '"+alamat.getText()+"', gol_darah = '"+gol+"', tanggal_lahir = '"+tgl+"' where nik = '"+penduduk.nik.getText()+"'";
                stm.executeUpdate(sql);
                JOptionPane.showMessageDialog(this,"Data Berhasil Diubah","Information",JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                penduduk.refresh.doClick();
            }
         catch (Exception e)
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
            java.util.logging.Logger.getLogger(data_penduduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(data_penduduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(data_penduduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(data_penduduk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new data_penduduk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField agama;
    public static javax.swing.JTextField alamat;
    private javax.swing.JLabel background;
    public static javax.swing.JButton batal;
    public static javax.swing.JComboBox<String> darah;
    public static javax.swing.JTextField hubungan_keluarga;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JTextField kode_pos;
    public static javax.swing.JRadioButton laki;
    public static javax.swing.JTextField nama;
    public static javax.swing.JTextField nama_ayah;
    public static javax.swing.JTextField nama_ibu;
    public static javax.swing.JTextField negara;
    public static javax.swing.JTextField nik;
    public static javax.swing.JTextField no_kk;
    public static javax.swing.JTextField pekerjaan;
    public static javax.swing.JTextField pendidikan;
    public static javax.swing.JRadioButton perempuan;
    public static javax.swing.JButton simpan;
    public static javax.swing.JTextField status;
    public static javax.swing.JTextField tempat_lahir;
    public static com.toedter.calendar.JDateChooser tgl_lahir;
    public static javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
