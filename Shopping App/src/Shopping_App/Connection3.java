package Shopping_App;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connection3 {

	private static Connection NULL;
	
	public   java.sql.Connection getConnection() throws ClassNotFoundException, SQLException {
	
		Class.forName("com.mysql.jdbc.Driver");
		java.sql.Connection  c=null;
		c=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopping","root","");
		if(c!=null)
		{
			return c;
		}
		else
		{
			return null;
		}

	}

}
