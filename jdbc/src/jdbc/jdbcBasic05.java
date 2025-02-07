
    	package jdbc;

    	import java.sql.Connection;
    	import java.sql.DriverManager;
    	import java.sql.PreparedStatement;
    	import java.sql.ResultSet;
    	import java.sql.SQLException;
    	import java.sql.Statement;

    	public class jdbcBasic05 {
    	    public static void main(String[] args) {
    	        StudentDAO dao = new StudentDAO();

    	        // Uncomment to test getStudent method
    	        
    	          // select 
//    	         dao.connect();
//    	         Student s1 = dao.getStudent(104);
//    	         System.out.println(s1.name);
    	        
    	        
    	          // update or insert a row
//    	        Student s2 = new Student();
//    	        s2.rollno = 111;
//    	        s2.name = "sonu";
//    	        s2.age = 23;
//    	        dao.connect();
//    	        dao.addStudent(s2);
    	        
    	        // Remove student with rollno 110
    	      dao.connect();
    	      dao.removeStudent(104);
    	        
    	    }
    	}

    	class StudentDAO {
    		
    	    Connection con = null;

    	    public void connect() {
    	        try {
    	            Class.forName("com.mysql.cj.jdbc.Driver");
    	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/collage", "root", "nitesh@123");
    	        } catch (Exception e) {
    	            System.err.println("Error occurred while connecting to the database.");
    	            e.printStackTrace();
    	        }
    	    }

    	    public Student getStudent(int rollno) {
    	    	try {
    				
    	    		String query = "select name from student where id = "+rollno;
    	    		Student s = new Student();
    	    		s.rollno = rollno;
    	    		
    	            
    	    		Statement st = con.createStatement();
    	    		
    	    	    ResultSet rs = st.executeQuery(query);
    	    	    
    	    	    rs.next();
    	    	    String name = rs.getString(1);
    	    	    s.name = name;
    	    		
    	    		return s;
    	    		
    	    	    
    	    	  }catch (SQLException e) {
    	    	      System.err.println("SQL error occurred.");
//    	    	      e.printStackTrace();
    	    	  }
    	    		return null;
    	    	
    	    	}
    	    
    	    
    	    public void addStudent(Student s) {
    	        try {
    	        	 String query = "insert into student values(?, ?, ?)";

    	            PreparedStatement pst = con.prepareStatement(query);

    	            pst.setInt(1, s.rollno);
    	            pst.setString(2, s.name);
    	            pst.setInt(3, s.age);

    	            pst.executeUpdate();

    	        } catch (SQLException e) {
    	            System.err.println("SQL error occurred while adding student.");
    	            e.printStackTrace();
    	        }
    	    }


    	    public void removeStudent(int rollno) {
    	        try {
    	            String query = "DELETE FROM student WHERE id = " + rollno;
    	            Statement st = con.createStatement();
    	            int affectedRows = st.executeUpdate(query);

    	            if (affectedRows > 0) {
    	                System.out.println("Student with rollno " + rollno + " was successfully deleted.");
    	            } else {
    	                System.out.println("Student with rollno " + rollno + " does not exist.");
    	            }

    	        } catch (SQLException e) {
    	            System.err.println("SQL error occurred while deleting student.");
    	            e.printStackTrace();
    	        }
    	    }

    	class Student {
    	    
    	    int rollno;
    	    String name;
    	    int age;
    	}
   }
       