import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ImageInsert {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/youtube";
            Connection con = DriverManager.getConnection(url, "root", "root1");
            // create a query , ? means we insert value dynamically
            String q = "insert into images(pic) value(?)";

            //get the PreparedStatement object

            PreparedStatement pstmt = con.prepareStatement(q);

            // It is use for selecting image file
            JFileChooser jf = new JFileChooser();
            jf.showOpenDialog(null);

            File file = jf.getSelectedFile();
            FileInputStream fis = new FileInputStream(file);
            pstmt.setBinaryStream(1, fis, fis.available());

            pstmt.executeUpdate();

            System.out.println("Table value updated in database....");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        /* create table images(id int primary key auto_increment,pic blob);
            alter table images modify pic longblob;

         */

    }
}
