import java.sql.SQLException;

public interface CRUD {
	
	public void Access();
	public void AddInfo(String name,String surname)throws SQLException;
	public void DeleteInfo()throws SQLException;
	public void UpdateInfo(String newname,String newsurname)throws SQLException;
	//return table row for Person
	public String GetInfo(String name,String surname)throws SQLException;
	public void CloseConnection() throws SQLException;

}
