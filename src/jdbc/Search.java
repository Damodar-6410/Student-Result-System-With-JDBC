
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Search {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
          try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
            System.out.println("Connection established successfully");
            String sql="select * from student where sid=?";
            PreparedStatement ps=con.prepareStatement(sql);
              System.out.println("Enter student id");
              int id=sc.nextInt();
              ps.setInt(1, id);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                System.out.println("Sid   Sname      Class     Age    Total   percent   Grade ");
                int sid=rs.getInt(1);
                String sname=rs.getString(2);
                String class_n=rs.getString(3);
                int age=rs.getInt(4);
                int total=rs.getInt(5);
                float percent=rs.getFloat(6);
                String grade=rs.getString(7);
                System.out.println(sid+"     "+sname+"    "+class_n+"       "+age+"     "+total+"     "+percent+"      "+grade);
            }else{
                System.out.println("There is no Student available of this ID number");
            }
        }
        catch(Exception e){
             System.out.println("Connection could not be established successfully");
             System.out.println(e);
        }
    }
}
