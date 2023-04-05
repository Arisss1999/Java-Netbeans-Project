import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;


public class data_mutasi extends javax.swing.JFrame {

    Connection con;
    Statement stm;
    ResultSet rs;
    String sql;
    String kelamin, tgl;
    
    public data_mutasi() {
        initComponents();
        koneksi db = new koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
        
        buat_no();
        
    }

    private void buat_no()
    {
        try
        {
            sql = "select * from mutasi order by no_surat desc";
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
                no_surat.setText("M" + c + b);
            }
            
            else
            {
                no_surat.setText("M0001");
            }
        }
        
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tgl_surat = new javax.swing.JTextField();
        no_surat = new javax.swing.JTextField();
        no_kk = new javax.swing.JTextField();
        tempat_lahir = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        kewarganegaraan = new javax.swing.JTextField();
        agama = new javax.swing.JTextField();
        status = new javax.swing.JTextField();
        pekerjaan = new javax.swing.JTextField();
        nik = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tujuan = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        asal = new javax.swing.JTextArea();
        laki = new javax.swing.JRadioButton();
        perempuan = new javax.swing.JRadioButton();
        tgl_lahir = new com.toedter.calendar.JDateChooser();
        batal = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tgl_surat.setEditable(false);
        tgl_surat.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        tgl_surat.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tgl_suratPropertyChange(evt);
            }
        });
        getContentPane().add(tgl_surat, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 124, 230, 30));

        no_surat.setEditable(false);
        no_surat.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        getContentPane().add(no_surat, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, 230, 30));

        no_kk.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        no_kk.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(no_kk, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 230, 30));

        tempat_lahir.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        tempat_lahir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tempat_lahir.setName("277"); // NOI18N
        getContentPane().add(tempat_lahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 278, 80, 30));

        nama.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        nama.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 244, 230, 30));

        kewarganegaraan.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        kewarganegaraan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(kewarganegaraan, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 343, 230, 30));

        agama.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        agama.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(agama, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 180, 230, 30));

        status.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        status.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 214, 230, 30));

        pekerjaan.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        pekerjaan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(pekerjaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 248, 230, 30));

        nik.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        nik.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(nik, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 176, 230, 30));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tujuan.setColumns(20);
        tujuan.setRows(5);
        jScrollPane1.setViewportView(tujuan);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 350, 230, 70));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        asal.setColumns(20);
        asal.setRows(5);
        asal.setName("277"); // NOI18N
        jScrollPane2.setViewportView(asal);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 285, 230, 60));

        laki.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        laki.setText("Laki - Laki");
        laki.setBorder(null);
        laki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lakiActionPerformed(evt);
            }
        });
        getContentPane().add(laki, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 318, -1, -1));

        perempuan.setFont(new java.awt.Font("Berlin Sans FB", 0, 12)); // NOI18N
        perempuan.setText("Perempuan");
        perempuan.setBorder(null);
        perempuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                perempuanActionPerformed(evt);
            }
        });
        getContentPane().add(perempuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 318, -1, -1));

        tgl_lahir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tgl_lahir.setName("277"); // NOI18N
        tgl_lahir.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tgl_lahirPropertyChange(evt);
            }
        });
        getContentPane().add(tgl_lahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 278, 120, 30));

        batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Batal.png"))); // NOI18N
        batal.setBorder(null);
        batal.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Batal1.png"))); // NOI18N
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });
        getContentPane().add(batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 460, -1, -1));

        simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Simpan.png"))); // NOI18N
        simpan.setBorder(null);
        simpan.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Simpan1.png"))); // NOI18N
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });
        getContentPane().add(simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, -1, -1));

        ubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/ubah.png"))); // NOI18N
        ubah.setBorder(null);
        ubah.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/ubah1.png"))); // NOI18N
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });
        getContentPane().add(ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, -1, -1));

        jTextField1.setEditable(false);
        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTextField1.setText("Kewarganegaraan");
        jTextField1.setBorder(null);
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 120, -1));

        jTextField2.setEditable(false);
        jTextField2.setBorder(null);
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 380, 170, 30));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Panel Mutasi.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void perempuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_perempuanActionPerformed
       laki.setSelected(false);
       kelamin = "Perempuan";
    }//GEN-LAST:event_perempuanActionPerformed

    private void lakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lakiActionPerformed
       perempuan.setSelected(false);
       kelamin = "Laki - Laki";
    }//GEN-LAST:event_lakiActionPerformed

    private void tgl_lahirPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tgl_lahirPropertyChange
        if(tgl_lahir.getDate() != null)
        {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            tgl = String.valueOf(format.format(tgl_lahir.getDate()));
            tgl_lahir.setDateFormatString("dd-MM-yyyy");
        }
    }//GEN-LAST:event_tgl_lahirPropertyChange

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        try
        {
            sql = "insert into mutasi (no_surat, tgl_surat,nik, no_kk, nama, tempat_lahir, tgl_lahir,kelamin, kewarganegaraan, agama, status, pekerjaan, alamat_asal, alamat_tujuan) value ('"+no_surat.getText()+"', '"+tgl_surat.getText()+"', '"+nik.getText()+"', '"+no_kk.getText()+"', '"+nama.getText()+"', '"+tempat_lahir.getText()+"', '"+tgl+"', '"+kelamin+"', '"+kewarganegaraan.getText()+"', '"+agama.getText()+"', '"+status.getText()+"', '"+pekerjaan.getText()+"', '"+asal.getText()+"', '"+tujuan.getText()+"') ";
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(this,"Data Berhasil Ditambah","Information",JOptionPane.INFORMATION_MESSAGE);

            buat_no();
            mutasi.refresh.doClick();
            this.dispose();
        
        }   
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
       this.dispose();
    }//GEN-LAST:event_batalActionPerformed

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        try
        {
            sql = "update mutasi set nik = '"+nik.getText()+"',no_kk = '"+no_kk.getText()+"',nama = '"+nama.getText()+"',tempat_lahir = '"+tempat_lahir.getText()+"',tgl_lahir = '"+tgl+"',kelamin = '"+kelamin+"', kewarganegaraan = '"+kewarganegaraan.getText()+"', agama = '"+agama.getText()+"', status = '"+status.getText()+"', pekerjaan = '"+pekerjaan.getText()+"', alamat_asal = '"+asal.getText()+"', alamat_tujuan = '"+tujuan.getText()+"' where no_surat = '"+mutasi.tes.getText()+"' ";
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(this,"Data Berhasil Ditambah","Information",JOptionPane.INFORMATION_MESSAGE);

            buat_no();
            
            mutasi.refresh.doClick();
            this.dispose();
        
        }   
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_ubahActionPerformed

    private void tgl_suratPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tgl_suratPropertyChange
        java.util.Date buat_tgl = new java.util.Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        tgl_surat.setText(String.valueOf(format.format(buat_tgl)));
    }//GEN-LAST:event_tgl_suratPropertyChange

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
            java.util.logging.Logger.getLogger(data_mutasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(data_mutasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(data_mutasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(data_mutasi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new data_mutasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField agama;
    public static javax.swing.JTextArea asal;
    private javax.swing.JLabel background;
    private javax.swing.JButton batal;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    public static javax.swing.JTextField kewarganegaraan;
    public static javax.swing.JRadioButton laki;
    public static javax.swing.JTextField nama;
    public static javax.swing.JTextField nik;
    public static javax.swing.JTextField no_kk;
    public static javax.swing.JTextField no_surat;
    public static javax.swing.JTextField pekerjaan;
    public static javax.swing.JRadioButton perempuan;
    public static javax.swing.JButton simpan;
    public static javax.swing.JTextField status;
    public static javax.swing.JTextField tempat_lahir;
    public static com.toedter.calendar.JDateChooser tgl_lahir;
    public static javax.swing.JTextField tgl_surat;
    public static javax.swing.JTextArea tujuan;
    protected static javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
