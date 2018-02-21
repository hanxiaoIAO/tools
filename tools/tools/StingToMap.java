package tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.bokesoft.myerp.common.datatype.VarUtil;

public class StingToMap {
	public static HashMap<Integer, List<Integer>> StringToHashMap(String mapString) {
		HashMap<Integer, List<Integer>> hashMap = new HashMap<Integer, List<Integer>>();
		mapString = mapString.substring(0, mapString.length() - 1);
		String[] stringMaps = mapString.split("],");
		for (String stringMap : stringMaps) {
			String[] maps = stringMap.split("=\\[");
			int key = VarUtil.toInt(maps[0]);
			String stringValue = maps[1];
			String[] values = stringValue.split(",");
			List<Integer> valueList = new ArrayList<Integer>();
			for (String value : values) {
				valueList.add(VarUtil.toInt(value));
			}
			hashMap.put(key, valueList);
		}
		return hashMap;
	}
}
