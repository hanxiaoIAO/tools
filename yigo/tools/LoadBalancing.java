package tools;

import fileTool.WriteFileTools;

public class LoadBalancing {
	static String path = "C:\\Users\\hanxu\\Desktop\\配置\\";

	static final String NAMESTRING = "NAMESTRING";
	static final String IP = "IP";
	static final String DSNproperties = "DSN.properties";
	static final String createDataBaseSQL = "createDataBase.sql";

	static final String propeitiesTextMould = "DSNTag=\n" + "Name="
			+ NAMESTRING + "\n" + "ConnectionType=jdbc\n" + "DBType=MySqls\n"
			+ "Driver=com.mysql.jdbc.jdbc2.optional.MysqlXADataSource\n"
			+ "DriverExt=com.mysql.jdbc.Driver\n" + "URL=jdbc:mysql://" + IP
			+ ":3306/" + NAMESTRING
			+ "?useUnicode=true&amp;characterEncoding=UTF-8\n" + "User=root\n"
			+ "Password=111111\n" + "ExtConfig=xa\n";
	static final String DatabaseName = "DatabaseName";
	static final String createDataBaseStringMoudle = "create DataBase "
			+ DatabaseName + "\n";

	static String DSNNamed = "";

	static String createDataBaseString = "";

	private static void puechaseMethod() throws Exception {

		String db = "DB000";
		String peuchases[] = { "101", "201", "301", "401", "901", "902" };
		String ip = "1.1.11.126";
		int dates[] = { 20186, 20187, 20188, 20189};
		DSNNamed = DSNNamed+"采购组织DSN\n";
		createDataBaseString = createDataBaseString+"采购组织\n";
		for (String purchase : peuchases) {
			for (int date : dates) {
				String propeitiesText = propeitiesTextMould;
				String fileName = db + purchase + date;
				propeitiesText = propeitiesText
						.replaceAll(NAMESTRING, fileName);
				propeitiesText = propeitiesText.replace(IP, ip);
				WriteFileTools.WriteToFile(propeitiesText, path + fileName
						+ ".properties");

				DSNNamed = DSNNamed + fileName + ";";
				createDataBaseString = createDataBaseString+createDataBaseStringMoudle.replaceAll(
						DatabaseName, fileName);
			}
		}
		createDataBaseString = createDataBaseString + "\n\n\n";
		DSNNamed = DSNNamed + "\n\n\n";
	}

	private static void companyMethod() throws Exception {

		String db = "DB";
		String companys[] = { "0001", "0002", "0003", "0004" };
		String ip[] = { "1.1.11.121", "1.1.11.123", "1.1.11.124", "1.1.11.125" };
		String dates[] = {"2018006", "2018007", "2018008", "2018009"};

		DSNNamed = DSNNamed+"公司DSN\n";
		for (int i = 0; i < companys.length; i++) {
			createDataBaseString = createDataBaseString+"公司" + companys[i] + "\n";
			for (String date : dates) {
				String propeitiesText = propeitiesTextMould;
				String fileName = db + companys[i] + date;

				propeitiesText = propeitiesText.replace(NAMESTRING, fileName);
				propeitiesText = propeitiesText.replace(IP, ip[i]);
				WriteFileTools.WriteToFile(propeitiesText, path + fileName
						+ ".properties");

				DSNNamed = DSNNamed + fileName + ";";
				createDataBaseString = createDataBaseString+createDataBaseStringMoudle.replaceAll(
						DatabaseName, fileName);

			}
			createDataBaseString = createDataBaseString + "\n\n\n";
		}
		DSNNamed = DSNNamed + "\n\n\n";
	}

	public static void main(String[] args) throws Exception {
		puechaseMethod();
		companyMethod();
		WriteFileTools.WriteToFile(createDataBaseString, path
				+ createDataBaseSQL);
		WriteFileTools.WriteToFile(DSNNamed, path
				+ DSNproperties);
	}

}
