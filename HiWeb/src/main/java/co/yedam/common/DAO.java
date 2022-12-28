package co.yedam.common;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DAO {
	public static Connection getConn() {
		String path = ""; //정보를 읽어와서 하도록
		path = DAO.class.getResource("/config/db.properties").getPath();
		Properties prop = new Properties(); //key: val
		
		try {
			prop.load(new FileReader(path));
			String url = prop.getProperty("jdbc.url");
			String driver = prop.getProperty("jdbc.driver");
			String user = prop.getProperty("jdbc.user");
			String pass = prop.getProperty("jdbc.password");
			
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, pass);
			System.out.println("연결성공!");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
