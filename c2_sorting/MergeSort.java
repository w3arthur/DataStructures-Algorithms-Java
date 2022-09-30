package c2_sorting;

public class MergeSort {
	public static void sort(int[] array) {
		// Divide to half		[8 2] [4 1]
		// Sort each half		[2 8]	[1 4]
		// Merge the results	[1 2 4 8]
		
		//edge cases
		if(array.length <2) return;
		
		final var  middle = array.length / 2;
		int[] left = new int[middle];

		for (var i = 0; i < middle; i++) {
			left[i] = array[i];
		}
		int[] right = new int[array.length - middle];
		for (var i = middle; i < array.length; i++) {
			right[i - middle] = array[i];
		}
		sort(left);
		sort(right);
		//Merge the result to array
		sortAndMerge(left, right, array);
	}
	
	private static void sortAndMerge(int[] left, int[] right, int[] result) {
		int l = 0, r = 0, res = 0;
		while (l < left.length && r < right.length) {
			if(left[l] <= right[r]) result[res ++] = left[l ++];
			else result[res ++] = right[r ++];
		}
		// copy remaining items
		while (l < left.length) result[res ++] = left[l ++];
		while (r < right.length) result[res ++] = right[r ++];
		
	}
	
}
