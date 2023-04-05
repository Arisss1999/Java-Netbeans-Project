import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.*;

public class data_barang extends javax.swing.JPanel {

    Connection con;
    Statement stm;
    ResultSet rs;
    String sql;
    
    DefaultTableModel model;
    TableColumn kolom;
    
    public data_barang() {
        initComponents();
        koneksi db = new koneksi();
        db.config();
        con = db.con;
        stm = db.stm;
        
        String []th = {"No","Kode Barang","Nama Barang","Ukuran","Unit"};
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
            sql = "select * from barang order by kd_barang asc";
            rs  = stm.executeQuery(sql);
            while(rs.next())
            {
                model.addRow(new Object[]
                {
                    no++,
                    rs.getString("kd_barang"),
                    rs.getString("nama_barang"),
                    rs.getString("ukuran"), 
                    rs.getString("unit"),
                    
                });
            }
        }
        
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "2"+e.getMessage());
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        background = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabel);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 890, 260));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/Panel.png"))); // NOI18N
        add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}
