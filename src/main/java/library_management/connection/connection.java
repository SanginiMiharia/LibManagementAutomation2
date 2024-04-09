package library_management.connection;
import java.sql.*;
public class connection {
    public static Connection connect() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver"); // removed .cj
            String url = "jdbc:mysql://localhost:3306/library";
            String username = "root";
            String password = "666ujg666*";

            Connection con = DriverManager.getConnection(url, username, password);

            // System.out.println("Connection Succesful");
            return con;

        } catch (Exception e) {
            System.out.println(e);

        }
        return null;
    }

}
