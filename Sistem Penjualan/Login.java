import java.sql.*;
import javax.swing.*;


public class Login extends javax.swing.JFrame {

    Connection con;
    Statement stm;
    ResultSet rs;
    String sql;
    
    public Login() {
        initComponents();
        
        koneksi db = new koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        masuk = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        username.setBackground(new java.awt.Color(239, 233, 228));
        username.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        username.setBorder(null);
        getContentPane().add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 193, 180, 30));

        password.setBackground(new java.awt.Color(239, 233, 228));
        password.setBorder(null);
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, 170, 30));

        masuk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/btn/login.png"))); // NOI18N
        masuk.setBorder(null);
        masuk.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/btn/login2.png"))); // NOI18N
        masuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                masukActionPerformed(evt);
            }
        });
        getContentPane().add(masuk, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, -1, -1));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gmbr/Login.png"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void masukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_masukActionPerformed
       try
       {
           sql = "select * from login";
           rs  = stm.executeQuery(sql);
           while(rs.next())
           {
               if(username.getText().equals(rs.getString("username")) && password.getText().equals(rs.getString("password")))
               {
                   JOptionPane.showMessageDialog(this, "Login Berhasi","Information",JOptionPane.INFORMATION_MESSAGE);
                   
                   
                    new utama().setVisible(true);
                    this.dispose();
               }
               else
               {
                   JOptionPane.showMessageDialog(this, "Salah","Information",JOptionPane.INFORMATION_MESSAGE);
               }
           }
       }
       catch(Exception e)
       {
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
       
    }//GEN-LAST:event_masukActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton masuk;
    private javax.swing.JPasswordField password;
    public static javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
