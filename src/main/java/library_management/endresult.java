package library_management;
import library_management.addbook.*;
import library_management.connection.*;
import library_management.details.*;
import library_management.issue.*;
import library_management.returning.*;
import java.util.*;
public class endresult {
    public static void main(String[] args) {
        addbook a1 = new addbook();
        details d1 = new details();
        issue i1 = new issue();
        returning r1 = new returning();
        System.out.println("\n Welcome to the Library Management System :");
        System.out.println("----------------------------------------------");
        System.out.println("1: ADD NEW BOOK \n2: DETAILS \n3: ISSUE BOOK\n4: RETURN BOOK");
        System.out.println("Choose what action do you want to perfrom on library system :");
        Scanner s1 = new Scanner(System.in);
        int number = s1.nextInt();
        switch (number) {
            case 1:
                a1.addnewbook();
                break;
            case 2:
                d1.printdetails(); 
                break;
            case 3:
                i1.issuebook();
                break;
            case 4:
                r1.returnbook(); 
                break;
        }
        s1.close();
    } 
}
