
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class RSMD {
    public static void main(String[] args) {
          try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db","root","root");
            System.out.println("Connection established successfully");
            String sql="select * from student";
            PreparedStatement ps=con.prepareStatement(sql);
              ResultSetMetaData rsmd=ps.getMetaData();
               System.out.println(rsmd.getTableName(2));
              System.out.println(rsmd.getColumnCount());
              System.out.println(rsmd.getColumnLabel(2));
              System.out.println(rsmd.getColumnClassName(2));
              System.out.println(rsmd.getColumnTypeName(2));
              System.out.println(rsmd.getColumnDisplaySize(2));
        }
        catch(Exception e){
             System.out.println("Connection could not be established successfully");
             System.out.println(e);
        }
    }
}
