import java.sql.*;
import javax.swing.JOptionPane;

public class dashboard extends javax.swing.JPanel {

        Connection con;
        Statement stm;
        ResultSet rs;
        String sql;
    public dashboard() {
        initComponents();
        koneksi db = new koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
        
        nama_pegawai();
    }
    public void nama_pegawai()
    {
        try
        {
            
            sql = "select * from login where username = '"+Login.username.getText()+"' ";
            rs = stm.executeQuery(sql);
            if(rs.next())
            {
            nama_pegawai.setText(rs.getString("nama_pegawai"));
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

        nama_pegawai = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nama_pegawai.setBackground(new java.awt.Color(74, 17, 5));
        nama_pegawai.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        add(nama_pegawai, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, 170, 30));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gmbr/beranda.png"))); // NOI18N
        add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    public static javax.swing.JLabel nama_pegawai;
    // End of variables declaration//GEN-END:variables
}
