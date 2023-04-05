import java.sql.*;
import javax.swing.JOptionPane;

public class koneksi {
   
    Connection con;
    Statement stm;
    
    public void config()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/db_penduduk","root","");
            stm = con.createStatement();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}

