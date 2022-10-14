import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
public class UpdateDataInDb {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/youtube";
            Connection con = DriverManager.getConnection(url, "root", "root1");
            // create a query , ? means we insert value dynamically
            String q = "update table1 set tName=?,tCity=? where tId=?";

            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter name,city and student id");

            String name=br.readLine();
            String city= br.readLine();
            int id=Integer.parseInt(br.readLine());
            //get the PreparedStatement object

            PreparedStatement pstmt = con.prepareStatement(q);

            // set the value in the place of ? in query
            pstmt.setString(1, name);
            pstmt.setString(2, city);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();

            System.out.println("Table value updated in database....");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
        mysql> select * from table1;
        +-----+----------+----------+
        | tId | tName    | tCity    |
        +-----+----------+----------+
        |   1 | Naven    | Bareilly |
        |   2 | Praveen  | Bisalpur |
        |   3 | Yogendra | Bisalpur |
        +-----+----------+----------+
         */
    }
}
