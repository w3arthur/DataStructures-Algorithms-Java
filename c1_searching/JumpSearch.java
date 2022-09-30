package c1_searching;

public class JumpSearch {
	public static int search(int[] array, int target) {
		int blockSize = (int) Math.sqrt(array.length);
		int start = 0;
		int next = blockSize;
		while(start < array.length && array[next -1] < target) {
			start = next;	//if (start >= array.length) break;	//edge case
			next += blockSize;
			if (next > array.length) next = array.length;	
		}
		for (var i = start; i < next; i++) if(array[i] == target) return i;
		return -1;
	}
}
