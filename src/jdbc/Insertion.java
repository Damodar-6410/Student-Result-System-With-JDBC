
package jdbc;

import java.sql.*;
import java.util.Scanner;

public class Insertion {
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
        System.out.println("Enter student id");
        int sid=sc.nextInt();
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
         String sql="insert into student values(?,?,?,?,?,?,?)";
         PreparedStatement ps=con.prepareStatement(sql);
         ps.setInt(1,sid);
         ps.setString(2,sname);
         ps.setString(3,class_name);
         ps.setInt(4,age);
         ps.setInt(5,total);
         ps.setFloat(6,percent);
         ps.setString(7,grade);
         ps.executeUpdate();
           System.out.println("One record added successfully");
       }catch(Exception e){
           System.out.println(e);
       }
      
    }
}
