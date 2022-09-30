package c2_sorting;
import java.util.Arrays;

public class CountingSort {
	//range: [0, K]
	// [2 3 2 5 4 4 5 5]
	// [0, 0, 1, 1, 2, 3] # 0 1 2 3 4 5 
	// only positive numbers
	public static void sort(int[] array) {
		sort(array, Arrays.stream(array).max().getAsInt());
	}
	 public static void sort(int[] array, int max) {
		 int[] counts = new int[max + 1];
		 for (var item : array) counts[item]++; //increment
		 var index = 0;
		 for (var i = 0; i < counts.length; ++i) 
			 for(var j = 0; j < counts[i]; j++) array[index++] = i;	//coping x times
	 }
}
