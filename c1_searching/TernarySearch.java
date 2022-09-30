package c1_searching;

import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardDownRightHandler;

public class TernarySearch {
	public static int search(int[] array, int target) {
		return search(array, target, 0,  array.length - 1);
	}
	private static int search(int[] array, int target, int left, int right) {
		if(right < left) return -1;
		int partitionSize = (right -left)/3;
		int mid1 = left + partitionSize;
		int mid2 = right - partitionSize;
		if(array[mid1] == target) return mid1;
		else if(array[mid2] == target) return mid2;
		else  if(target < array[mid1]) return search(array, target, left, mid1 - 1);
		else  if(target < array[mid2]) return search(array, target, mid1, mid2 - 1);
		else return search(array, target, mid2 + 1, right);
	}
	
}
