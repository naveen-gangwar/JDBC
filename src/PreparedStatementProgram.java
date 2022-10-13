import java.sql.Connection;
import java.sql.*;

public class PreparedStatementProgram {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/youtube";
            Connection con = DriverManager.getConnection(url, "root", "root1");
            // create a query , ? means we insert value dynamically
            String q = "insert into table1(tName,tCity) values(?,?)";

            //get the PreparedStatement object

            PreparedStatement pstmt =  con.prepareStatement(q);

            // set the value to query
            pstmt.setString(1,"Naveen");
            pstmt.setString(2,"Bisalpur");
            pstmt.setString(1,"Praveen");
            pstmt.setString(2,"Bisalpur");
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
            +-----+--------+---------+
            | tId | tName  | tCity   |
            +-----+--------+---------+
            |   1 | Naveen | Praveen |

            mysql> select * from table1;
            +-----+---------+----------+
            | tId | tName   | tCity    |
            +-----+---------+----------+
            |   1 | Naveen  | Praveen  |
            |   2 | Praveen | Bisalpur |
            +-----+---------+----------+
         */
    }
}
