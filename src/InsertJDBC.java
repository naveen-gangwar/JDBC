import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertJDBC {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/youtube";
            Connection con = DriverManager.getConnection(url, "root", "root1");
            // create a query
            String q = "create table table1(tId int(20) primary key auto_increment,tName varchar(200) not null , tCity varchar(400))";

            //create a statement

            Statement stmt = con.createStatement();
            stmt.executeUpdate(q);
            System.out.println("Table created in database....");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Mysql commands
         use youtube
         show tables;
         desc table1;
         */

    }
}