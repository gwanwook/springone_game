package ex01.database;

public class DatabaseServiceImpl implements DatabaseService{

	String url = "jdbc:oracle:thin:@210.108.48.214:1521:xe";
	String id = "springone"; //jsp
	String pwd = "1234";  //1234
	
	public DatabaseServiceImpl() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
