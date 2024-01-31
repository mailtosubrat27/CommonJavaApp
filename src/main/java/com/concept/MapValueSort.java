package com.concept;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapValueSort {
	//Sorting based on value - Normal order and reverse order
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("Ram", "Nayak");
		map.put("Ananat", "Pattanaik");
		map.put("Hari", "Patra");
		map.put("Anand", "Nath");
		map.put("Sanan", "Mishra");
		
		System.out.println(map);
		
		Map<String, String> trMap = new TreeMap<String, String>();
		trMap.putAll(map);
		System.out.println(trMap);
		
		// Iterate Map
		trMap.forEach((x,y) -> {
			System.out.println(x +"    " + y);
		});
		
		map.entrySet().forEach(x -> 
		{System.out.println(x+" :----: "+ trMap.get(x));});
		
	}

}
