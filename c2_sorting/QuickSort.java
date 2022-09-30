package c2_sorting;
import javax.management.loading.PrivateClassLoader;

public class QuickSort {	//לחזור
	public static void sort(int[] array) {
		sort(array ,0 ,array.length - 1);
	}
	private static void sort(int[] array, int start, int end) { // which part we trying to sort
		// choose pivot	[6 3 1 10] [13] [15 22] [left] [pivot] [right]
		// arrange items, the smallest in the right of it [6 3 1 10 15 22] [13]
		// pivot section by: *randomly *middle-index *average = (first + middle + last) /3
		
		//edge case
		if(start >= end) return;
		
		//Partition the array
		var pivot = pivotRange(array, start, end);
		//Sort left
		sort(array, start, pivot - 1);
		//Sort right
		sort(array, pivot + 1, end);

	}
	
	private static int pivotRange(int[] array, int start, int end) {
		var pivotStart = array[end];
		var getPivot = start - 1; // will be the new partition // right partition starts from index 0
		for (var i = start; i <= end; i++) if (array[i] <= pivotStart) swap(array, i, ++getPivot);
		return getPivot;	//index of the pivot after its move
	}
	
	
	private static void swap(int[] array, int index1, int index2) {
	    var temp = array[index1];
	    array[index1] = array[index2];
	    array[index2] = temp;
	}
}
