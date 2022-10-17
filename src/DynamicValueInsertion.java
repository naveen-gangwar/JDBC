import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DynamicValueInsertion {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/youtube";
            Connection con = DriverManager.getConnection(url, "root", "root1");
            // create a query , ? means we insert value dynamically
            String q = "insert into table1(tName,tCity) values(?,?)";

            //get the PreparedStatement object

            PreparedStatement pstmt = con.prepareStatement(q);

            // set the value to query using console

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter name");
            String name = br.readLine();

            System.out.println("Entr city");
            String city = br.readLine();

            pstmt.setString(1, name);
            pstmt.setString(2, city);

            pstmt.executeUpdate();

            System.out.println("Table value updated in database....");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Mysql commands
         use youtube
         show tables;
         desc table1;
         mysql> select * from table1;
            +-----+----------+----------+
            | tId | tName    | tCity    |
            +-----+----------+----------+
            |   1 | Naveen   | Praveen  |
            |   2 | Praveen  | Bisalpur |
            |   3 | Yogendra | Bisalpur |
            +-----+----------+----------+
            3 rows in set (0.00 sec)
            */
    }
}

