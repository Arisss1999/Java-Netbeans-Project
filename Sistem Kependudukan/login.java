import javax.swing.*;
import java.sql.*;

public class login extends javax.swing.JFrame {

    Connection con;
    Statement stm;
    ResultSet rs;
    String sql;
    
    
    public login() {
        initComponents();
        
        koneksi db = new koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
    
    
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        masuk = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        masuk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/masuki.png"))); // NOI18N
        masuk.setToolTipText("");
        masuk.setBorder(null);
        masuk.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/masuk1.png"))); // NOI18N
        masuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masukActionPerformed(evt);
            }
        });
        getContentPane().add(masuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, -1, -1));

        keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/keluarr.png"))); // NOI18N
        keluar.setBorder(null);
        keluar.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/button/keluarr1.png"))); // NOI18N
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });
        getContentPane().add(keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, -1, -1));
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 97, 240, 30));

        password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        password.setBorder(null);
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 240, 30));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/login.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void masukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masukActionPerformed
       try
       {
           sql = "select * from login where username = '"+username.getText()+"' and password = '"+password.getText()+"'";
           rs  = stm.executeQuery(sql);
           if(rs.next())
           {
                JOptionPane.showMessageDialog(this, "Login Berhasi","Information",JOptionPane.INFORMATION_MESSAGE);
                   new Utama().setVisible(true);
                  
                   this.dispose();
               }
               
               else
               {
                   JOptionPane.showMessageDialog(this, "Salah","Information",JOptionPane.INFORMATION_MESSAGE);
               }
           
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
    }//GEN-LAST:event_masukActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
           System.exit(0); 
    }//GEN-LAST:event_keluarActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JButton keluar;
    private javax.swing.JButton masuk;
    private javax.swing.JPasswordField password;
    public static javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
