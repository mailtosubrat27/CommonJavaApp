package com.java.test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class LongestSubstring {

	public static void main(String[] args) {

		String str = "afdatyuioagd";//"adfaytrui";
		//not working
		//lengthofLongestSubString(str);
		
		//sks - logest substring
		lengthofLongestSubString2(str);
		lengthofLongestSubString3(str);
		

	}

	private static void lengthofLongestSubString3(String str) {
		List<Character> chList = new ArrayList<Character>();
		char[] charArray = str.toCharArray();
		int subStrLength = 0;
		String subStr = "";
		
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			
			if(chList != null && !chList.contains(c)) {
				chList.add(c);
			} else {
				i--;
				subStrLength = Math.max(chList.size(), subStrLength);
				if(chList.size() == subStrLength)
				subStr = chList.stream()
						.map(e -> e.toString())
						.collect(Collectors.joining());
				chList.clear();
			}
		}
		if(subStrLength <= chList.size()) {
			subStrLength = Math.max(chList.size(), subStrLength);
			subStr = chList.stream()
					.map(e -> e.toString())
					.collect(Collectors.joining());
		}
		System.out.println("Length :"+subStrLength);
		System.out.println("Sub String :"+subStr);
	}

	private static void lengthofLongestSubString2(String str) {
		Map<Integer, String> map = new TreeMap<Integer, String>();
		List<Character> chList = new ArrayList<Character>();
		char[] charArray = str.toCharArray();
		
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			if(chList != null && !chList.contains(c)) {
				chList.add(c);
			} else {
				map.put(chList.size(), chList.toString());
				chList.clear();
				chList.add(c);
				
			}
			if(i == charArray.length-1)
				map.put(chList.size(), chList.toString());
			
			
		}

		System.out.println(map);
		
		
	}

	private static void lengthofLongestSubString(String str) {
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		char[] charArray = str.toCharArray();
		
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			
			if(!map.containsKey(c)){
				map.put(c, i);
			} else {
				i = map.get(c);
				map.clear();
			}
		}
		
		System.out.println("Longest Substring :"+ map.toString());
		
		
	}

}
