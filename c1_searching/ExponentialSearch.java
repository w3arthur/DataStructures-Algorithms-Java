package c1_searching;

import java.util.Arrays;

public class ExponentialSearch {
	public static int search(int[] array, int target) {
		int right = 1;
		while(array[right] < target) {
			right *= 2;
			if (right >= array.length) { right = array.length - 1; break; }
		}
		int[] newArray = Arrays.copyOfRange(array, right/2, right + 1);
		int search = BinarySearch.searchRecursion(newArray, target);
		return search >= 0 ?  right /2 + search : -1 ;
	}
}
