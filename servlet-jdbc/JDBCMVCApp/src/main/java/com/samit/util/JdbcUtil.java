package com.samit.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtil {

	private JdbcUtil() {
	}

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection physicalConnection() throws FileNotFoundException, IOException, SQLException {
		String dbLoc = "C:\\Users\\HP\\Desktop\\java-development\\servlet-jdbc\\JDBCMVCApp\\src\\main\\java\\com\\samit\\properties\\db.properties";
		FileInputStream fis = new FileInputStream(dbLoc);
		Properties properties = new Properties();
		properties.load(fis);
		String url = properties.getProperty("url");
		String username = properties.getProperty("user");
		String password = properties.getProperty("password");
		Connection connection = DriverManager.getConnection(url, username, password);
		return connection;
	}

}
