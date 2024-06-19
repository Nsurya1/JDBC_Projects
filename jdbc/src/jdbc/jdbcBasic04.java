package jdbc;

import java.sql.DriverManager;

//class.forName();

public class jdbcBasic04 {
 public static void main(String[] args) throws Exception {

//	 Class.forName("jdbc.Pqr").newInstance();
	 
         //	 both are same
	 
	 Class.forName("com.mysql.cj.jdbc.Driver()");
	 
	 DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
 }
}
 
 class Pqr{
	 static {
		 System.out.println("in static");	 
		}
	 
	 //instance  
	 
	 {
		 System.out.println("in instance");
	 }
 }

