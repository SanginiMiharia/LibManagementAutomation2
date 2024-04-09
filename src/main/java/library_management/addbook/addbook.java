package library_management.addbook;
import library_management.connection.connection;
import java.sql.*;
import java.io.*;
public class addbook extends connection {
    public void addnewbook() {
        String sql = "insert into book (book_id, book_name,book_available,book_quantity) values (?,?,?,?)";
        try {
            Connection connection = connect();
            PreparedStatement ptm = connection.prepareStatement(sql);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter the Book Id :");
            String book_id = br.readLine();
            System.out.println("Enter the Book Name :");
            String book_name = br.readLine();
            System.out.println("Enter the Book Quantity :");
            String book_quantity = br.readLine();
            System.out.println("Enter the book availibility status:");
            String book_available = br.readLine();
            ptm.setString(1, book_id);
            ptm.setString(2, book_name);
            ptm.setString(3, book_available);
            ptm.setString(4, book_quantity);

            ptm.executeUpdate();
            System.out.println("New Book Added!\n-----------");
            ptm.close();
            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
