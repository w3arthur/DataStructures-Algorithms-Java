package c2_sorting;

public class BubbleSort {
	public static void sort(int[] array) {
	    for (var i = 0; i < array.length; i++) 
		      for (var j = 1; j < array.length - i; j++)
		        if (array[j] < array[j - 1]) 
		        	swap(array, j, j - 1);
	}
	
	
	public static void sort2(int[] array) {
	    for (var i = 0; i < array.length; i++) 
		      for (var j = i; j < array.length; j++)
		        if (array[j] < array[i]) swap(array, i, j);
	}
	
	//לנסות ליישם ברקורסיה
	
	public static void sortImproved(int[] array) {
	    for (var i = 0; i < array.length; i++) {
	      boolean  isSorted = true;
	      for (var j = 1; j < array.length - i; j++)
	        if (array[j] < array[j - 1]) {
	          swap(array, j, j - 1);
	          isSorted = false;
	        }
	      if (isSorted) return;
	    }
	}


	private static void swap(int[] array, int index1, int index2) {
	    var temp = array[index1];
	    array[index1] = array[index2];
	    array[index2] = temp;
	}
}
