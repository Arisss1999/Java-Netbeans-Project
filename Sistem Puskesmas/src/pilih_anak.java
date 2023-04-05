import java.sql.*;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.*;

public class pilih_anak extends javax.swing.JFrame {

    Connection con;
    Statement stm;
    ResultSet rs;
    String sql;
    
    
    DefaultTableModel model;
    TableColumn kolom;
    public pilih_anak() {
        initComponents();
        koneksi db = new koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
        
        String []th = {"No","ID Pendaftaran","Tanggal Pendaftaran","Nama Anak","Tempat Tanggal Lahir","Jenis Kelamin","Usia","Nama Ibu","Alamat"};
        model = new DefaultTableModel(th, 0);
        tabel.setModel(model);
        
        tampil();
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
            sql = "select * from pasien where tgl_daftar = '"+pendaftaran.tgl_pendaftaran.getText()+"' order by tgl_daftar asc";
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
    public void ambil_data()
    {
        try
        {
            sql = "select * from pasien  where id_pasien = '"+tes.getText()+"'";
            rs  = stm.executeQuery(sql);
                       
            while(rs.next())
            {
                penimbangan.tgl_penimbangan.setText(rs.getString("tgl_daftar"));
                penimbangan.nama_anak.setText(rs.getString("nama_anak"));
                penimbangan.ttl.setText(rs.getString("ttl"));
                penimbangan.kelamin.setText(rs.getString("jenis_kelamin"));
                penimbangan.usia.setText(rs.getString("usia"));
                penimbangan.nama_ibu.setText(rs.getString("nama_ibu"));
                penimbangan.alamat.setText(rs.getString("alamat"));
                
               
                imunisasi.tgl_imunisasi.setText(rs.getString("tgl_daftar"));
                imunisasi.nama_anak.setText(rs.getString("nama_anak"));
                imunisasi.ttl.setText(rs.getString("ttl"));
                imunisasi.kelamin.setText(rs.getString("jenis_kelamin"));
                imunisasi.usia.setText(rs.getString("usia"));
                imunisasi.nama_ibu.setText(rs.getString("nama_ibu"));
                imunisasi.alamat.setText(rs.getString("alamat"));
                
                
                vitamin.tgl_vitamin.setText(rs.getString("tgl_daftar"));
                vitamin.nama_anak.setText(rs.getString("nama_anak"));
                vitamin.ttl.setText(rs.getString("ttl"));
                vitamin.kelamin.setText(rs.getString("jenis_kelamin"));
                vitamin.usia.setText(rs.getString("usia"));
                vitamin.nama_ibu.setText(rs.getString("nama_ibu"));
                vitamin.alamat.setText(rs.getString("alamat"));
                
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        ok = new javax.swing.JButton();
        cari = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tes = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        jScrollPane1.setViewportView(tabel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 850, 160));

        ok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/button/pilih.png"))); // NOI18N
        ok.setBorder(null);
        ok.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/button/pilih1.png"))); // NOI18N
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });
        getContentPane().add(ok, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 310, -1, -1));

        cari.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cariKeyReleased(evt);
            }
        });
        getContentPane().add(cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 83, 260, 20));

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB", 0, 18)); // NOI18N
        jLabel2.setText("Cari Pasien :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Panel pilih anak.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
        getContentPane().add(tes, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 80, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        int row = tabel.getSelectedRow();
        tes.setText(model.getValueAt(row, 1).toString());
               
       
       
       
    }//GEN-LAST:event_tabelMouseClicked

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        ambil_data();
        this.dispose();
        
    }//GEN-LAST:event_okActionPerformed

    private void cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariKeyReleased
        int row = tabel.getRowCount();
        for (int a=0; a<row; a++)
        {
            model.removeRow(0);
        }
        try
        {
             int no=1;
            sql = "select * from pasien where nama_anak like  '"+cari.getText()+"%' order by nama_anak asc";
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
    }//GEN-LAST:event_cariKeyReleased

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
            java.util.logging.Logger.getLogger(pilih_anak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(pilih_anak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(pilih_anak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(pilih_anak.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new pilih_anak().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton ok;
    private javax.swing.JTable tabel;
    public static javax.swing.JTextField tes;
    // End of variables declaration//GEN-END:variables
}
