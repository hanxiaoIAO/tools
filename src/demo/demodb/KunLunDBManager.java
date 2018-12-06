package demo.demodb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class KunLunDBManager {

	private static final String CLASSNAME="com.kunlun.jdbc.Driver";
	
	private Connection conn = null;

	public Connection getConnection(String url, String user, String password) throws Throwable {  
		if(conn == null){
            Class.forName(CLASSNAME);//指定连接类型  
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
