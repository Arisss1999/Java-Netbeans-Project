import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public class data_kematian extends javax.swing.JFrame {

    Connection con;
    Statement stm;
    ResultSet rs;
    String sql;
    String tm, tl;
    String kelamin;
    
    public data_kematian() {
        initComponents();
        koneksi db = new koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
        
        buat_no();
        tanggal();
        
    }
   private void tanggal()
   {
       java.util.Date buat_tgl = new java.util.Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        tgl_surat.setText(String.valueOf(format.format(buat_tgl)));
   }
    private void buat_no()
    {
        try
        {
            sql = "select * from kematian order by no_kematian desc";
            rs  = stm.executeQuery(sql);
            if(rs.next())
            {
                String a = rs.getString("no_kematian").substring(2);
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
                no_surat.setText("SM" + c + b);
            }
            
            else
            {
                no_surat.setText("SM0001");
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

        agama = new javax.swing.JTextField();
        no_kk = new javax.swing.JTextField();
        nik = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        kewarganegaraan = new javax.swing.JTextField();
        tgl_surat = new javax.swing.JTextField();
        status = new javax.swing.JTextField();
        pekerjaan = new javax.swing.JTextField();
        nama_pelapor = new javax.swing.JTextField();
        hub_keluarga = new javax.swing.JTextField();
        tempat_mati = new javax.swing.JTextField();
        tempat_lahir = new javax.swing.JTextField();
        no_surat = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        laki = new javax.swing.JRadioButton();
        perempuan = new javax.swing.JRadioButton();
        tgl_lahir = new com.toedter.calendar.JDateChooser();
        tgl_mati = new com.toedter.calendar.JDateChooser();
        simpan = new javax.swing.JButton();
        batal = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        agama.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        agama.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(agama, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 158, 220, 30));

        no_kk.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        no_kk.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(no_kk, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 158, 190, 30));

        nik.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        nik.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(nik, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 192, 190, 30));

        nama.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        nama.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 225, 190, 30));

        kewarganegaraan.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        kewarganegaraan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(kewarganegaraan, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 325, 190, 30));

        tgl_surat.setEditable(false);
        tgl_surat.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        tgl_surat.setBorder(null);
        tgl_surat.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tgl_suratPropertyChange(evt);
            }
        });
        getContentPane().add(tgl_surat, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 122, 160, 30));

        status.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        status.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 193, 220, 30));

        pekerjaan.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        pekerjaan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(pekerjaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 226, 220, 30));

        nama_pelapor.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        nama_pelapor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(nama_pelapor, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 350, 240, 30));

        hub_keluarga.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        hub_keluarga.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(hub_keluarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 384, 240, 30));

        tempat_mati.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        tempat_mati.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(tempat_mati, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 260, 80, 30));

        tempat_lahir.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        tempat_lahir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(tempat_lahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 359, 80, 30));

        no_surat.setEditable(false);
        no_surat.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        no_surat.setBorder(null);
        getContentPane().add(no_surat, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 89, 160, 30));

        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setFont(new java.awt.Font("Berlin Sans FB", 0, 11)); // NOI18N

        alamat.setColumns(20);
        alamat.setRows(5);
        jScrollPane1.setViewportView(alamat);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 190, 60));

        laki.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        laki.setText("Laki - Laki");
        laki.setBorder(null);
        laki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lakiActionPerformed(evt);
            }
        });
        getContentPane().add(laki, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 397, -1, 20));

        perempuan.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        perempuan.setText("Perempuan");
        perempuan.setBorder(null);
        perempuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perempuanActionPerformed(evt);
            }
        });
        getContentPane().add(perempuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 397, -1, 20));

        tgl_lahir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tgl_lahir.setDateFormatString("dd-MM-yyyy");
        tgl_lahir.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tgl_lahirPropertyChange(evt);
            }
        });
        getContentPane().add(tgl_lahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 90, 30));

        tgl_mati.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tgl_mati.setDateFormatString("dd-MM-yyyy");
        tgl_mati.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tgl_matiPropertyChange(evt);
            }
        });
        getContentPane().add(tgl_mati, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 260, 120, 30));

        simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Simpan.png"))); // NOI18N
        simpan.setBorder(null);
        simpan.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Simpan1.png"))); // NOI18N
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });
        getContentPane().add(simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, -1, -1));

        batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Batal.png"))); // NOI18N
        batal.setBorder(null);
        batal.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Batal1.png"))); // NOI18N
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });
        getContentPane().add(batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 460, -1, -1));

        ubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/ubah.png"))); // NOI18N
        ubah.setBorder(null);
        ubah.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/ubah1.png"))); // NOI18N
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });
        getContentPane().add(ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Panel Kematian.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 550));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lakiActionPerformed
        kelamin = "Laki - Laki";
        perempuan.setSelected(false);
    }//GEN-LAST:event_lakiActionPerformed

    private void perempuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perempuanActionPerformed
        kelamin = "Perempuan";
        laki.setSelected(false);
    }//GEN-LAST:event_perempuanActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        try
        {
            sql = "insert into kematian (no_kematian, tgl_surat, nik, no_kk, nama, tgl_lahir, tempat_lahir, tgl_kematian, kelamin, agama, status, pekerjaan, tempat_kematian, nama_pelapor, hub_keluarga, kewarganegaraan, alamat) value ('"+no_surat.getText()+"', '"+tgl_surat.getText()+"', '"+nik.getText()+"', '"+no_kk.getText()+"', '"+nama.getText()+"', '"+tl+"', '"+tempat_lahir.getText()+"', '"+tm+"', '"+kelamin+"', '"+agama.getText()+"', '"+status.getText()+"', '"+pekerjaan.getText()+"', '"+tempat_mati.getText()+"', '"+nama_pelapor.getText()+"', '"+hub_keluarga.getText()+"', '"+kewarganegaraan.getText()+"','"+alamat.getText()+"')";
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(this,"Data Berhasil Ditambah","Information",JOptionPane.INFORMATION_MESSAGE);

            buat_no();
            kematian.refresh.doClick();
            this.dispose();
        
        }

        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        
    }//GEN-LAST:event_simpanActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        this.dispose();
    }//GEN-LAST:event_batalActionPerformed

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        try
        {
            sql = "update kematian set nik = '"+nik.getText()+"', no_kk = '"+no_kk.getText()+"', nama = '"+nama.getText()+"', tgl_lahir = '"+tl+"', tempat_lahir = '"+tempat_lahir.getText()+"', tgl_kematian = '"+tm+"', kelamin = '"+kelamin+"', agama = '"+agama.getText()+"', status = '"+status.getText()+"', pekerjaan = '"+pekerjaan.getText()+"', tempat_kematian = '"+tempat_mati.getText()+"', nama_pelapor = '"+nama_pelapor.getText()+"', hub_keluarga = '"+hub_keluarga.getText()+"', alamat = '"+alamat.getText()+"', kewarganegaraan = '"+kewarganegaraan.getText()+"' where nik = '" +nik.getText()+"' ";
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(this,"Data Berhasil Diubah","Information",JOptionPane.INFORMATION_MESSAGE);
            
            kematian.refresh.doClick();
            simpan.setVisible(true);
            
            this.dispose();
            
        }
        catch (Exception e)
        {

            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_ubahActionPerformed

    private void tgl_suratPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tgl_suratPropertyChange
        
    }//GEN-LAST:event_tgl_suratPropertyChange

    private void tgl_lahirPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tgl_lahirPropertyChange
       if(tgl_lahir.getDate() != null)
        {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            tl     = String.valueOf(format.format(tgl_lahir.getDate()));
            tgl_lahir.setDateFormatString("dd-MM-yyyy");
        }
    }//GEN-LAST:event_tgl_lahirPropertyChange

    private void tgl_matiPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tgl_matiPropertyChange
        if(tgl_lahir.getDate() != null)
        {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            tm     = String.valueOf(format.format(tgl_mati.getDate()));
            tgl_mati.setDateFormatString("dd-MM-yyyy");
        }
    }//GEN-LAST:event_tgl_matiPropertyChange

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
            java.util.logging.Logger.getLogger(data_kematian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(data_kematian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(data_kematian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(data_kematian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new data_kematian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField agama;
    public static javax.swing.JTextArea alamat;
    public static javax.swing.JButton batal;
    public static javax.swing.JTextField hub_keluarga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField kewarganegaraan;
    public static javax.swing.JRadioButton laki;
    public static javax.swing.JTextField nama;
    public static javax.swing.JTextField nama_pelapor;
    public static javax.swing.JTextField nik;
    public static javax.swing.JTextField no_kk;
    public static javax.swing.JTextField no_surat;
    public static javax.swing.JTextField pekerjaan;
    public static javax.swing.JRadioButton perempuan;
    public static javax.swing.JButton simpan;
    public static javax.swing.JTextField status;
    public static javax.swing.JTextField tempat_lahir;
    public static javax.swing.JTextField tempat_mati;
    public static com.toedter.calendar.JDateChooser tgl_lahir;
    public static com.toedter.calendar.JDateChooser tgl_mati;
    public static javax.swing.JTextField tgl_surat;
    public static javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
