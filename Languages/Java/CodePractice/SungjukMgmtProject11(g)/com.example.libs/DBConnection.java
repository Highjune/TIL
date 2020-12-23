package com.example.libs;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection { //Connection을 리턴해주기 때문에 이렇게 만들어두면 활용도 높다.
	public static Connection getConnection(String filename) { //파일의 이름에 따라(oracle.properties / maria.properties 등에 따라 다 이것으로만 다 활용할 수 있다)
		
		Connection conn = null;
		try {
			Properties info = new Properties();  //.properties파일이 properties객체가 되는 것임.
			info.load(new FileInputStream(new File(filename))); //properties에는 이렇게 파일을 불러오는 load가 있다.
			Class.forName(info.getProperty("db.driver"));
		    conn = DriverManager.getConnection(
					info.getProperty("db.url"), info.getProperty("db.user"),
					info.getProperty("db.password"));
		}catch(IOException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
