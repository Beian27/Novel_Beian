package www.novel.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbHelp {
	static Connection connection = null;
	static String driver = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/novel?serverTimezone=UTC";
	static String user = "root";
	static String password = "123456";

	public static Connection getConnection() {
		if (connection == null) {
			try {
				// 加载驱动程序
				Class.forName(driver);
				// 获得数据库连接对象
				connection = DriverManager.getConnection(url, user, password);
				return connection;

			} catch (ClassNotFoundException e) {
				System.out.println("对不起，找不到这个Driver");
				e.printStackTrace();
				return connection;
			} catch (SQLException e) {
				e.printStackTrace();
				return connection;
			}
		} else
			return connection;
	}

}
