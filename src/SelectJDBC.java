
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.sql.Statement;

public class SelectJDBC {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/youtube";
            Connection con = DriverManager.getConnection(url, "root", "root1");
            // create a query , ? means we insert value dynamically
            String q = "select * from table1";

            //get the tatement object

            Statement stmt = con.createStatement();
            ResultSet set=  stmt.executeQuery(q);
            while (set.next()){
                int id=set.getInt(1);
                String name=set.getString(2);
                String city=set.getString(3);
                System.out.println(id + name +city);
            }

            System.out.println("Table value updated in database....");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
