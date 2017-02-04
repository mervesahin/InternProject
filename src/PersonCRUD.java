import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PersonCRUD implements CRUD {
	 
	 static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
     static final String DB_URL = "jdbc:mysql://localhost/db_merve";
     static final String USER = "root";
     static final String PASS = "1";
	 Connection connect = null;
	 Statement stmt = null;
	 
	 public void Access(){  	    
	    try{
	        //STEP 2: Register JDBC driver
	        Class.forName("com.mysql.jdbc.Driver");
	
	        //STEP 3: Open a connection
	        System.out.println("Connecting to database...");
	        connect= DriverManager.getConnection(DB_URL,USER,PASS);      
	     }catch(SQLException se){
	        //Handle errors for JDBC
	        se.printStackTrace();
	     }catch(Exception e){
	        //Handle errors for Class.forName
	        e.printStackTrace();
	     }     
	}

	
	public void AddInfo(String name,String surname) throws SQLException{
		
		String insertTableSQL = "INSERT INTO Person VALUES(?,?)";
		PreparedStatement preparedStatement = connect.prepareStatement(insertTableSQL);
		preparedStatement.setString(1, name);
		preparedStatement.setString(2, surname);
		preparedStatement.executeUpdate();
		preparedStatement.close();
	
	}
	public void DeleteInfo() throws SQLException{
		
		  System.out.println("Creating statement...");
	      stmt = connect.createStatement();
	      String sql = "DELETE FROM Person WHERE name = 'nuri'";
	      stmt.executeUpdate(sql);
		
		
	}
	public void UpdateInfo(String newname,String newsurname)throws SQLException{
		/* PreparedStatement ps = null;
		  
		 String query = "UPDATE Person SET surname = ?,WHERE name = ?";
	            ps = connect.prepareStatement(query);
	            ps.setString(1,newsurname);
	            ps.setString(2,newname);
	            ps.executeUpdate();*/
      
	}
	//return table row for Person
	public String GetInfo(String name,String surname)throws SQLException{
	
		return "stub";
	}

	public void CloseConnection() throws SQLException{	
		System.out.println("Closeeeeee!");	
		connect.close();		
	}	
	
	

}
