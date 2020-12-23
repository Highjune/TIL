package com.gym.dao;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	public static Connection getConnection(String filename) {
		Connection conn=null;
		try {
			Properties info=new Properties();
			info.load(new FileInputStream(new File(filename)));
			Class.forName(info.getProperty("db.driver"));
			conn=DriverManager.getConnection(info.getProperty("db.url"),info.getProperty("db.user"),info.getProperty("db.password"));
		}catch(IOException|ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		return conn;
			
	}

}
