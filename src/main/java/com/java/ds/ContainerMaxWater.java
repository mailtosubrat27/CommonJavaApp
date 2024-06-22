package com.java.ds;

public class ContainerMaxWater {

	public static void main(String[] args) {
		int arr[] = {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(arr));
	}
	 public static int maxArea(int[] height) {
	        int l = 0;
	        int r = height.length-1;
	        int max_area = 0;

	        while(l < r) {
	            int area = Math.min(height[l], height[r]) * (r-l);
	            if(height[l]<height[r]){
	                l++;
	            } else {
	                r--;
	            }
	            max_area = Math.max(area, max_area);
	        }
	        return max_area;
	    }
}
