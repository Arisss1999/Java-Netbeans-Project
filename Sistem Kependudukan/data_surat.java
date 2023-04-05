import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public class data_surat extends javax.swing.JFrame {

    Connection con;
    Statement stm;
    ResultSet rs;
    String sql;
    String tgl;
    
    public data_surat() {
        initComponents();
        
        koneksi db = new koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
        
        buat_nomor();
        
    }
    
    private void tgl_surat()
    {
        if (tanggal.getDate() != null)
        {
            String pattern          = "yyyy-MM-dd";
            SimpleDateFormat format = new SimpleDateFormat(pattern);
            tgl                  = String.valueOf(format.format(tanggal.getDate()));
        }
    }
     private void buat_nomor()
    {
        try
        {
            sql = "select * from surat order by no_surat desc";
            rs  = stm.executeQuery(sql);
            if(rs.next())
            {
                String a = rs.getString("no_surat").substring(3);
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
                no_surat.setText("SK" + c + b);
            }
            
            else
            {
                no_surat.setText("SK0001");
            }
        }
        
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        no_surat = new javax.swing.JTextField();
        nik = new javax.swing.JTextField();
        tanggal = new com.toedter.calendar.JDateChooser();
        nama = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tujuan = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        keterangan = new javax.swing.JTextArea();
        batal = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        ubah = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        no_surat.setEditable(false);
        no_surat.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        no_surat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(no_surat, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 98, 230, 30));

        nik.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        nik.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(nik, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 166, 230, 30));

        tanggal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tanggal.setDateFormatString("dd-MM-yyyy");
        tanggal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tanggalPropertyChange(evt);
            }
        });
        getContentPane().add(tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 132, 180, 30));

        nama.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        nama.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 230, 30));

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tujuan.setColumns(20);
        tujuan.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tujuan.setRows(5);
        jScrollPane2.setViewportView(tujuan);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 235, 240, 60));

        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        keterangan.setColumns(20);
        keterangan.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        keterangan.setRows(5);
        jScrollPane1.setViewportView(keterangan);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 302, 240, 60));

        batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Batal.png"))); // NOI18N
        batal.setBorder(null);
        batal.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Batal1.png"))); // NOI18N
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });
        getContentPane().add(batal, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, -1, -1));

        simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Simpan.png"))); // NOI18N
        simpan.setBorder(null);
        simpan.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/Simpan1.png"))); // NOI18N
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });
        getContentPane().add(simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

        ubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/ubah.png"))); // NOI18N
        ubah.setBorder(null);
        ubah.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/ubah1.png"))); // NOI18N
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });
        getContentPane().add(ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Panel Surat.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        this.dispose();
    }//GEN-LAST:event_batalActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        
        try
        {
            sql = "select nik from identitas_penduduk";
            rs = stm.executeQuery(sql);
            if (rs.next())
            {
                if (nik.getText().equals (rs.getString("nik")))
                {
                    
                    sql = "insert into surat (no_surat,tanggal_surat,nik,nama,tujuan,keterangan) values ('"+no_surat.getText()+"', '"+tgl+"', '"+nik.getText()+"', '"+nama.getText()+"', '"+tujuan.getText()+"', '"+keterangan.getText()+"')";
                    stm.executeUpdate(sql);
                    JOptionPane.showMessageDialog(this,"Data Berhasil Ditambah","Information",JOptionPane.INFORMATION_MESSAGE);
                    pembuatan_surat.refresh.doClick();
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "NIK Tidak Terdaftar !");
                }
            }
            else
                {
                    JOptionPane.showMessageDialog(this, "NIK Tidak Terdaftar !");
                }
                this.dispose();
        }

        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_simpanActionPerformed

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        try
        {
            sql = "update surat set nik = '"+nik.getText()+"', nama = '"+nama.getText()+"',tujuan = '"+tujuan.getText()+"', keterangan = '"+keterangan.getText()+"' where no_surat = '" +no_surat.getText()+ "' ";
            stm.executeUpdate(sql);
            JOptionPane.showMessageDialog(this,"Data Berhasil DiUbah","Information",JOptionPane.INFORMATION_MESSAGE);
            pembuatan_surat.refresh.doClick();
            
            this.dispose();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_ubahActionPerformed

    private void tanggalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tanggalPropertyChange
        if(tanggal.getDate() != null)
        {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            tgl = String.valueOf(format.format(tanggal.getDate()));
            tanggal.setDateFormatString("dd-MM-yyyy");
        }
    }//GEN-LAST:event_tanggalPropertyChange

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
            java.util.logging.Logger.getLogger(data_surat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(data_surat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(data_surat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(data_surat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new data_surat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    public static javax.swing.JButton batal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextArea keterangan;
    public static javax.swing.JTextField nama;
    public static javax.swing.JTextField nik;
    public static javax.swing.JTextField no_surat;
    public static javax.swing.JButton simpan;
    public static com.toedter.calendar.JDateChooser tanggal;
    public static javax.swing.JTextArea tujuan;
    public static javax.swing.JButton ubah;
    // End of variables declaration//GEN-END:variables
}
