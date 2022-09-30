package c2_sorting;

public class SelectionSort {
	public static void sort(int[] array) {
	    for (var i = 0; i < array.length; i++) {
	      var minIndex = i;
	      for (var j = i; j < array.length; j++) if (array[j] < array[minIndex]) minIndex = j;
	      swap(array, minIndex, i);
	    }
	  }

	public static void sort2(int[] array) {
		for(var i = 0; i < array.length; ++i) {
			var minIndex = findMinIndex(array, i);
			swap(array, i, minIndex);
		}
	} 
	private static int findMinIndex(int[] array, int i) {
		int min = i;
		for(var j = i; j < array.length; ++j) {
			if(array[j] < array[min]) min = j;
		}
		return min;
	}

	private static void swap(int[] array, int index1, int index2) {
		if(index1 == index2) return;
	    var temp = array[index1];
	    array[index1] = array[index2];
	    array[index2] = temp;
	}
}
