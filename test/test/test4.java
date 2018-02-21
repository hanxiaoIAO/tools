package test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class test4 {

	public static void main(String args[]) {
		System.out.println("*************************LinkedHashMap*************");
		LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
		map.put(6, "apple");
		map.put(3, "banana");
		map.put(2, "pear");
		map.put(5, "sb");
		map.put(3, "sb");
		map.put(6, "6");
		map.put(5, "5");

		for (Iterator it = map.keySet().iterator(); it.hasNext();) {
			Object key = it.next();
			System.out.println(key + "=" + map.get(key));
		}
	}
}