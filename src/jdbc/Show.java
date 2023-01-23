
package jdbc;

import java.sql.*;
import java.util.Scanner;

public class Show {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
            System.out.println("Connection established successfully");
            String sql="select * from student";
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            System.out.println("Sid   Sname      Class     Age    Total   percent   Grade ");
            while(rs.next()){
                int sid=rs.getInt(1);
                String sname=rs.getString(2);
                String class_n=rs.getString(3);
                int age=rs.getInt(4);
                int total=rs.getInt(5);
                float percent=rs.getFloat(6);
                String grade=rs.getString(7);
                System.out.println(sid+"     "+sname+"    "+class_n+"       "+age+"     "+total+"     "+percent+"      "+grade);
            }
        }
        catch(Exception e){
             System.out.println("Connection could not be established successfully");
             System.out.println(e);
        }
        
    }
}
