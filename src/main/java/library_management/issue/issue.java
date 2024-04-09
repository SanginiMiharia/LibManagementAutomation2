package library_management.issue;

import java.sql.*;

import library_management.connection.connection;
import java.io.*;

public class issue extends connection {
    String book_id;

    public void issuebook() {
        String checkAvailabilityQuery = "SELECT book_available FROM book WHERE book_id=?";
        String query = "update book set book_available =(book_available-1) where book_id=? AND book_available > 0 ";
        String query2 = "insert into issued (book_id, book_name) select book_id,book_name from book where book_id=? ";

        try {
            Connection connection = connect();

            PreparedStatement ptm3 = connection.prepareStatement(checkAvailabilityQuery);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("enter the book id :");
            book_id = br.readLine();

            ptm3.setString(1, book_id);
            ResultSet rs = ptm3.executeQuery();
            if (rs.next()) {
                int available = rs.getInt("book_available");
                if (available > 0) {
                    PreparedStatement ptm = connection.prepareStatement(query);
                    ptm.setString(1, book_id);
                    int rowsUpdate = ptm.executeUpdate();
                    if (rowsUpdate > 0) {
                        PreparedStatement ptm2 = connection.prepareStatement(query2);
                        ptm2.setString(1, book_id);
                        ptm2.executeUpdate();
                        System.out.println("BOOK ISSUED SUCCESSFULLY!\n Have a Nice Day Ahead ");
                        ptm2.close();

                    } else {
                        System.out.println("book can't be issued");

                    }
                    ptm.close();

                }

                else {
                    System.out.println("This Book is out of stock");
                }

            }

            // ptm3.executeQuery();

            connection.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

