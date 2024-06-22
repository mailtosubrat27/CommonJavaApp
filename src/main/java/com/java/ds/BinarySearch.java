package com.java.ds;

public class BinarySearch {

	public static void main(String[] args) {
//		Scanner sc= new Scanner(System.in);
//		System.out.println(sc.nextLine());
		int a[] = {8, 10, 22, 27, 37, 44, 49, 55, 69}; // given array  
        int val = 22;
        
        //sks
        binarySearch(a,val);
        
        int result = binarySearch2(a,val);
        if (result == -1)
            System.out.println(
                "Element is not present in array");
        else
            System.out.println("Element is present at "
                               + "index " + result);
        System.out.println("done..");
	}

	private static int binarySearch2(int[] a, int x) {
		int low = 0, high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Check if x is present at mid
            if (a[mid] == x)
                return mid;

            // If x greater, ignore left half
            if (a[mid] < x)
                low = mid + 1;

            // If x is smaller, ignore right half
            else
                high = mid - 1;
        }

        // If we reach here, then element was
        // not present
        return -1;
		
	}

	private static void binarySearch(int[] a, int val) {
		int low =0;
		int high = a.length-1;
		int mid = a.length/2;
		
		while(true) {
			if(val <= a[mid]) {
				high = mid;
			} else {
				low = mid;
			}
			System.out.println("Low- "+low +" -Mid- "+mid +" - High- "+high);
			if(a[low] == val || a[high] == val) {
				System.out.println("Value present in array.");
				break;
			}
			
			if(low == high || low == high-1) {
				System.out.println("Value not present in array.");
				break;
			}
			mid = (low+high)/2;
		}
		
		
	}

}
