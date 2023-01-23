
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Deletion {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
          Connection con = null;
       try{
           Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
           System.out.println("Connection established successfully");
       }
       catch(Exception e){
           System.out.println("Connection could not be established successfully");
           System.out.println(e);
       }
        System.out.println("Enter Id of student whose data you want to delete");
        int sid=sc.nextInt();
         try{
             String sql="delete from student where sid=?";
             PreparedStatement ps=con.prepareStatement(sql);
             ps.setInt(1, sid);
             ps.executeUpdate();
             System.out.println("One record Deleted Successfully");
         }
         catch(Exception e){
             System.out.println(e);
         }
    }
}
