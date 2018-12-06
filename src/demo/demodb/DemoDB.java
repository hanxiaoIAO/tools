package demo.demodb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DemoDB {

//	public static final String URL = "jdbc:mysql://localhost:3306/eri?useUnicode=true&amp;characterEncoding=UTF-8";
//	public static final String USER = "root";
//	public static final String PASSWORD = "";
	
	public static final String URL = "jdbc:kunlun://localhost:6688/ERP";
	public static final String USER = "SYSDBA";
	public static final String PASSWORD = "SYSDBA";
	public static final String TESTSQL = "select * from user_tables";

	public static void main(String[] args) throws Throwable {
		KunLunDBManager dbmanager = new KunLunDBManager();
		Connection conn = dbmanager.getConnection(URL, USER, PASSWORD);
//		conn.createStatement();
		
		PreparedStatement pst = conn.prepareStatement(TESTSQL);
		ResultSet ret = pst.executeQuery();


//		while (ret.next()) {
//			String uid = ret.getString(1);
//			String ufname = ret.getString(2);
//			String ulname = ret.getString(3);
//			String udate = ret.getString(4);
//			System.out.println(uid + "\t" + ufname + "\t" + ulname + "\t" + udate);
//		} // 显示数据

		dbmanager.close();// 关闭连接
	}

}