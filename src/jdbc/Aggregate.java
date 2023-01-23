
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Aggregate {
    public static void main(String[] args) {
          Scanner sc=new Scanner(System.in);
          try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
            System.out.println("Connection established successfully");
            
            
             //Total no of student
            String sql4="select count(sid) from student";
            PreparedStatement ps4=con.prepareStatement(sql4);
            ResultSet rs4=ps4.executeQuery();
             rs4.next();
             int count=rs4.getInt(1);
             System.out.println("Total Number of student =>"+count);
            
            //percentage sum of All student
            String sql="select sum(percent) from student";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
             rs.next();
             float sum=rs.getFloat(1);
             System.out.println("percentage sum of All student=>"+sum);
             
             //percentage avg of All student
            String sql1="select avg(percent) from student";
            PreparedStatement ps1=con.prepareStatement(sql1);
            ResultSet rs1=ps1.executeQuery();
             rs1.next();
             float avg=rs1.getFloat(1);
             System.out.println("percentage avg of All student=>"+avg);
             
             //percentage min of All student
            String sql2="select min(percent) from student";
            PreparedStatement ps2=con.prepareStatement(sql2);
            ResultSet rs2=ps2.executeQuery();
             rs2.next();
             float min=rs2.getFloat(1);
             System.out.println("percentage min of All student=>"+min);
             
             //percentage Max of All student
            String sql3="select max(percent) from student";
            PreparedStatement ps3=con.prepareStatement(sql3);
            ResultSet rs3=ps3.executeQuery();
             rs3.next();
             float max=rs3.getFloat(1);
             System.out.println("percentage max of All student=>"+max);
            
          }
        catch(Exception e){
             System.out.println("Connection could not be established successfully");
             System.out.println(e);
        }
    }
}
