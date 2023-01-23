
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Updation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
             System.out.println("Connection established successfully");
        }
        catch(Exception e){
            System.out.println("Connection could not be established successfully");
            System.out.println(e);
        }
        System.out.println("Enter student id whose data you want to update");
        int id=sc.nextInt();
        System.out.println("Enter Student name");
        String sname=sc.next();
        System.out.println("Enter Class name");
        String class_name=sc.next();
        System.out.println("Enter age");
        int age=sc.nextInt();
        System.out.println("Enter number of five subjects");
        int a[]=new int[5];
        int total=0;
        float percent=0;
        for(int i=0;i<5;i++){
            a[i]=sc.nextInt();
            total=total+a[i];
        }
        percent=(float)total/5;
        String grade;
        if(percent>=75){
            grade="A";
        }else if(percent>=50){
            grade="B";
        }else if(percent>=33){
            grade="C";
        }else{
            grade="F";
        }
          try{
         String sql="update student set sname=?,class=?,age=?,total=?,percent=?,grade=? where sid=?";
         PreparedStatement ps=con.prepareStatement(sql);
         ps.setString(1,sname);
         ps.setString(2,class_name);
         ps.setInt(3,age);
         ps.setInt(4,total);
         ps.setFloat(5,percent);
         ps.setString(6,grade);
         ps.setInt(7,id);
         ps.executeUpdate();
           System.out.println("One record Updated successfully");
       }catch(Exception e){
           System.out.println(e);
       }
    }
}
