package b3_heap;

public class MaxHeap {
	public static void heapify(int[] array) {
		for(var i = array.length / 2 - 1; i  >=0 ; i--) heapify(array, i);
		//for(var i = 0; i < array.length; i++) heapify(array, i);
	}
	private static void heapify(int[] array, int i) {
		var largerIndex = i;
		var leftIndex = i * 2 + 1;
		var rightIndex = i * 2 + 2;
		if(leftIndex < array.length && array[leftIndex] > array [largerIndex]) largerIndex = leftIndex;
		if(rightIndex < array.length && array[rightIndex] > array [largerIndex]) largerIndex = rightIndex;
		if(i == largerIndex) return;
		swap(array, i, largerIndex);
		
	}
	private static void swap(int[] array, int first, int second) {
		var temp = array[first];
		array[first] = array[second];
		array[second] = temp;
	}
}
