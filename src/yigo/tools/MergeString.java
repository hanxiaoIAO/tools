package yigo.tools;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import tools.iniTool.INI;
import tools.iniTool.Property;
import tools.iniTool.Section;

public class MergeString {
	static List<String> optStrList = new ArrayList<String>();
	static String mainOptStr;
	static List<String> addList = new ArrayList<String>();

	static String path = "E:\\web\\BokeERP\\config";
	static String optRight = "\\Module\\SCM\\OptRight.ini";
	// static String sectionName = "NoBillOpt";
	// static String propertyKey = "NoNeedOpt";
	// static String sectionName = "NoDict";
	// static String propertyKey = "NoNeedDict";
	static String sectionName = "NoBill";
	static String propertyKey = "NoNeedBill";

	public static void main(String args[]) throws Throwable {
		File config = new File(path);
		File[] configs = config.listFiles();

		for (File moduleConfig : configs) {
			String optRightPath = moduleConfig.getAbsolutePath() + optRight;
			INI ini = new INI(optRightPath);
			if (!optRightPath.contains("basis")) {
				Section section = ini.getSection(sectionName);
				Property property = section.getProperty(propertyKey);
				String optStr = property.getValue();
				optStrList.add(optStr);
				// optStrList.add(optRightPath+"\n;"+optStr+"\n");
			} else {
				Section section = ini.getSection(sectionName);
				Property property = section.getProperty(propertyKey);
				mainOptStr = property.getValue();
			}
		}

		String[] mainStrs = mainOptStr.split(";");
		List<String> mainList = new ArrayList<String>(Arrays.asList(mainStrs));
		// System.out.println(mainList.size());

		for (String optStr : optStrList) {
			String[] strs = optStr.split(";");
			// System.out.println(strs.length);
			for (int i = 0; i < strs.length; i++) {
				if (!mainList.contains(strs[i])) {
					addList.add(strs[i]);
					mainList.add(strs[i]);
				}
			}
		}

		for (String addstr : addList) {
			System.out.print(addstr + ";");
		}

	}

	// public static String getProfileString(String file, String section,
	// String variable, String defaultValue) throws Throwable {
	//// String fileString = "";
	//
	// String strLine = "";
	// InputStreamReader isr = new InputStreamReader(new FileInputStream(file),
	// "utf-8");
	// BufferedReader bufferedReader = new BufferedReader(isr);
	// try {
	// while ((strLine = bufferedReader.readLine()) != null) {
	// strLine = strLine.trim();
	// if(strLine.startsWith("[")&&strLine.endsWith("]")){
	//
	// }
	//// fileString = fileString+strLine;
	// }
	// } finally {
	// bufferedReader.close();
	// }
	//
	// // fileString;
	//// String[] sectionStrs = fileString.split("[");
	//// String sectionStr = "";
	//// for(int i=0;i<sectionStrs.length;i++){
	//// if(sectionStrs[i].contains(section+"]")){
	//// sectionStr = sectionStrs[i];
	//// break;
	//// }
	//// }
	////
	//// if(sectionStr!=""){
	//// String[] variableStrs = sectionStr.split("]");
	//// variableStrs[1]
	//// }else{
	//// throw new Throwable("不存在section ["+section+"]");
	//// }
	//
	// return defaultValue;
	// }

}
