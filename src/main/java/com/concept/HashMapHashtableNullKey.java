package com.concept;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class HashMapHashtableNullKey {

	public static void main(String[] args) {
		Map<String, Integer> table = new Hashtable<String, Integer>(); // does not allow null key and null value
//		table.put(null, null); // throws NPE
		table.put("aa", 1);
//		table.put(null, 2); // Throws NPE

		Map<String, Integer> map = new HashMap<String, Integer>();// allow null key but allows null value
		map.put(null, null);
		map.put(null, null);
		map.put("aa", null);

		System.out.println("Hash Table :" + table.toString());
		System.out.println("Hash Map :" + map.toString());

	}

}
