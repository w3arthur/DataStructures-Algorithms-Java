package c1_searching;

import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardDownRightHandler;

public class BinarySearch {
	public static int searchIterative(int[] array, int target) {
		var left = 0;
		var right = array.length -1;
		while(left <= right) {
			var middle = (left + right) / 2;
			if (array[middle] == target) return middle;
			else if (array[middle] > target) right = middle - 1;
			else left = middle + 1;
		}
		return -1;
	}
	
	public static int searchRecursion(int[] array, int target) {
		return searchRecursion(array, target, 0, array.length - 1);
	}
	private static int searchRecursion(int[] array, int target, int left, int right) {	
		if (right < left) return -1; //edge race condition
		int middle = (left + right) / 2;
		if (array[middle] == target) return middle;
		else if (target < array[middle]) return searchRecursion(array, target, left, middle - 1);
		else  return searchRecursion(array, target, middle + 1, right);
	}
	
	
}
