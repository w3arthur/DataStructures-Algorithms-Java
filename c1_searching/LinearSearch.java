package c1_searching;

public class LinearSearch {
	public static int search(int[] array, int target) {
		for(var i = 0; i < array.length; ++i) if(array[i] == target) return i;
		return -1;
	}
}
