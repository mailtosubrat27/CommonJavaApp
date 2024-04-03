package com.concept;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class LongestSubstring {

	public static void main(String[] args) {
		String s = "This is my string. Find out the longest and shortest substring";
		findLongestWord(s);
		
		// Find longest substring
		// Input : ABCDEFGABEF
		// Output : ABCDEFG, BCDEFGA, CDEFGAB
		String word = "ABCDEFGABEF";
		longestSubstring(word);
		
	}

	private static void longestSubstring(String word) {
		char chArr[] = word.toUpperCase().toCharArray();
		List<Character> chs = new ArrayList<Character>();
		List<String> wordList = new ArrayList<String>();
		for (char c : chArr) {
			if(chs == null || chs.isEmpty() || !chs.contains(c)) {
				chs.add(c);
			} else {
				for (char ch : chs) {
					
					if(ch == c) {
						int start = chs.indexOf(ch);
						wordList.add(getStringFromChList(start, chs));
						break;
					}
				}
			}
		}
		
		System.out.println(wordList);
 		
		
	}

	private static String getStringFromChList(int start, List<Character> chs) {
		String st = "";
		for (int i= start; i < chs.size(); i++) {
			st = st + chs.get(i);
		}
		return st;
	}

	private static void findLongestWord(String s) {
		if(s == null)
			return;
		String subStrs[] = s.split(" ");
		String longstr = "";
		Integer len = 0;
		for (String sub : subStrs) {
			if(sub.length() > len) {
				len = sub.length();
				longstr = sub;
			}
		}
		System.out.println("Longest Substring: "+ longstr);
		
		//using java8

	}

}
