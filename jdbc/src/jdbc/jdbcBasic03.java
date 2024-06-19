package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class jdbcBasic03 {
	public static void main(String arg[]) throws Exception{
	String url = "jdbc:mysql://localhost:3306/collage";

    String username = "root";
    String password = "nitesh@123";
    
    int userId  = 107;
    String userName = "mit";
    int age = 20;
    
    String query = "insert into student values(?, ?, ?)";
    
    // Load and register the driver
    Class.forName("com.mysql.cj.jdbc.Driver");
    
    // Create a connection
    Connection con = DriverManager.getConnection(url, username, password);
    
    // Create a statement
    PreparedStatement st = con.prepareStatement(query); //Prepared Statement
    st.setInt(1, userId);
    st.setString(2, userName);
    st.setInt(3, age);
    
    int count = st.executeUpdate();
    
   System.out.print(count + "row's affected");
    st.close();
    con.close();
  }
}
