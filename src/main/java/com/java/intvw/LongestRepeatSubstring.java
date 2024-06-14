package com.java.intvw;

import java.util.HashSet;
import java.util.Set;

/**
 * Longest substring, substring should be present minimum twice
 * 
 * input = aabecaa
 * output = aa
 * 
 * Ip = aabcdabcaa
 * OP= abc //long substring 2 times
 * 
 * Ip = aabcdabcaampaat
 * Op = aa // repeating 3 times
 */


public class LongestRepeatSubstring {

	public static void main(String[] args) {
		String str = "aabcdabcaampaat";

		System.out.println("Longest repeated substring: " +longestSubstring(str));
		
		//sks
//		repeatSubstring("aabecaa");

	}

	private static void repeatSubstring(String str) {
		String sub = "aa";
		int count = 0;
		int stIndex = 0;
		while(true) {
			int index = str.indexOf(sub, stIndex);
			if(index == -1) {
				break;
			}
			count ++;
			stIndex = index+1;
		}
		System.out.println(count);
	}

	private static String longestSubstring(String str) {
		int n = str.length();
        String longestSubstring = "";

        for (int length = 1; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                String substring = str.substring(i, i + length);
                int count = countOccurrences(str, substring);

                if (count >= 2 && substring.length() > longestSubstring.length()) {
                    longestSubstring = substring;
                }
            }
        }

        return longestSubstring;
    }

    public static int countOccurrences(String str, String subStr) {
        if (subStr.length() == 0) {
            return 0;
        }

        int count = 0;
        int index = 0;

        while ((index = str.indexOf(subStr, index)) != -1) {
            count++;
            index += subStr.length(); // Move past the last occurrence
        }

        return count;
    }
}