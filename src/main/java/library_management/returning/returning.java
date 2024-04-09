package library_management.returning;

import java.sql.*;
import java.io.*;

import library_management.connection.connection;

public class returning extends connection {
    public void returnbook() {
        String query2 = "update book set book_available= (book_available+1) where book_id=?";
        String query = "insert into book (book_id, book_name) select book_id,book_name from book where book_id=? ";
        

        try {  
            Connection connection = connect();
            PreparedStatement ptm = connection.prepareStatement(query);
            PreparedStatement ptm2 = connection.prepareStatement(query2);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("enter the book id :"); 
            String book_id = br.readLine();
            ptm.setString(1, book_id);
            ptm2.setString(1, book_id);

            ptm.executeUpdate();
            ptm2.executeUpdate();


            System.out.println("Book Returned Successfully\n Have a Great Day Ahead!");
            connection.close();
            ptm.close();
            ptm2.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
