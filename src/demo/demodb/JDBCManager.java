package demo.demodb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCManager {

	private Connection conn = null;

	public Connection getConnection(String className, String url, String user, String password) throws Throwable {  
		if(conn == null){
            Class.forName(className);//指定连接类型  
            conn = DriverManager.getConnection(url, user, password);//获取连接   
		}
		return conn;
    }

	public void close() {
		try {
			this.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}