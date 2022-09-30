package c2_sorting;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int[] numbers;
		numbers = new int[]{ 7, 3, 1, 4, 6, 2, 3 };
		BubbleSort.sort(numbers);
		System.out.println("BubbleSort.sort \t" + Arrays.toString(numbers));
		numbers = new int[]{ 7, 3, 1, 4, 6, 2, 3 };
		BubbleSort.sort2(numbers);
		System.out.println("BubbleSort.sort2 \t" + Arrays.toString(numbers));
		System.out.println("");
		
		numbers = new int[]{ 7, 3, 1, 4, 6, 2, 3 };
		SelectionSort.sort(numbers);
		System.out.println("SelectionSort.sort \t" + Arrays.toString(numbers));
		numbers = new int[]{ 7, 3, 1, 4, 6, 2, 3 };
		SelectionSort.sort2(numbers);
		System.out.println("SelectionSort.sort2 \t" + Arrays.toString(numbers));
		System.out.println("");
		
		numbers = new int[]{ 7, 3, 1, 4, 6, 2, 3 };
		InsertionSort.sort(numbers);
		System.out.println("InsertionSort.sort \t" + Arrays.toString(numbers));
		System.out.println("");
		
		numbers = new int[]{ 7, 3, 1, 4, 6, 2, 3 };
		MergeSort.sort(numbers);
		System.out.println("MergeSort.sort \t\t" + Arrays.toString(numbers));
		System.out.println("");
		
		numbers = new int[]{ 7, 3, 1, 4, 6, 2, 3 };
		QuickSort.sort(numbers);
		System.out.println("QuickSort.sort \t\t" + Arrays.toString(numbers));
		System.out.println("");
		
		numbers = new int[]{ 7, 3, 1, 4, 6, 2, 3 };
		CountingSort.sort(numbers);
		System.out.println("CountingSortn.sort \t" + Arrays.toString(numbers));
		System.out.println("");
		
		numbers = new int[]{ 7, 3, 1, 4, 6, 2, 3 };
		BucketSort.sort(numbers, 3);
		System.out.println("BucketSort.sort \t" + Arrays.toString(numbers));
		System.out.println("");
	}

}
