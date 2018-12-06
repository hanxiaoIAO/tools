package yigo.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import tools.fileTool.WriteFileTools;
import tools.fileTool.ReadFileTools;

public class DealAllMenues {

	public static void main(String[] args) throws Throwable {
		List<String> strList = ReadFileTools.readFileToStrList("E:\\Allmenus.xml");
		List<String> newStrList = new ArrayList<String>();
		for (String str : strList) {
			newStrList.add(removeorgPath(str) + "\n");
		}
		WriteFileTools.WriteToFile(newStrList, "E:\\Allmenus.xml");
	}

	private static String removeorgPath(String str) throws Exception {
		HashMap<String, String> attrMap = new HashMap<String, String>();
		if (!str.contains("orgPath")) {
			return str;
		}
		String[] strs = str.split(" ");
		for (int i = 0; i < strs.length; i++) {
			if (strs[i].contains("<"))
				continue;
			strs[i] = strs[i].replace("/>", "");
			strs[i] = strs[i].replace(">", "");
			String[] attr = strs[i].split("=", 2);
			if (attr.length != 2)
				throw new Exception("");
			attrMap.put(attr[0], attr[1]);
		}

		return str.replace(" orgPath" + "=" + attrMap.get("orgPath"), "");
	}
}
