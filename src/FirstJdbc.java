import java.sql.Connection;
import java.sql.DriverManager;

public class FirstJdbc {
    public static void main(String[] args) {
        try {
//           load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");
//          creating a connection
            String url = "jdbc:mysql://localhost:3306/youtube";
            Connection con = DriverManager.getConnection(url, "root", "root1");
            con.close();
            if (con.isClosed())
                System.out.println("connection is closed");
            else
                System.out.println("connection created");
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}
