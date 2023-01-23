
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class JDBC {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Connection con;
        PreparedStatement ps;
       try{
           Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
           System.out.println("Connection established successfully");
       }catch(Exception e){
           System.out.println("Connection could not be established successfully");
           System.out.println(e);
       }
       System.out.println("enter your choice");
       System.out.println("1.Insertion");
       System.out.println("2.Deletion");
       System.out.println("3.Updation");
       System.out.println("4.Show");
       System.out.println("5.Seraching");
       int ch=sc.nextInt();
       switch(ch){
           case 1:
           {
               String sql="insert into student(?,?,?,?,?,?,?)";
               break;
           }
           case 2:
           {
               break;
           }
           case 3:
           {
               break;
           }
           case 4:
           {
               break;
           }
           case 5:
           {
               break;
           }
       }
       
    }
    
}
