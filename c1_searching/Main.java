package c1_searching;

import java.util.Arrays;


public class Main {

	public static void main(String[] args) {
		int target = 4;
		int resultIndex;
		int[] numbers= new int[]{ 7, 3, 1, 4, 6, 2, 3 };
		
		resultIndex = LinearSearch.search(numbers, target);
		System.out.println("LinearSearch.search \t\t" + resultIndex);
		System.out.println("");
		
		numbers = new int[]{ 1, 2, 3, 3, 4, 6, 7 }; // sorted !!!
		
		resultIndex = BinarySearch.searchRecursion(numbers, target);
		System.out.println("BinarySearch.searchRecursion \t" + resultIndex);
		resultIndex = BinarySearch.searchIterative(numbers, target);
		System.out.println("BinarySearch.searchIterative \t" + resultIndex);
		System.out.println("");
		
		resultIndex = TernarySearch.search(numbers, target);
		System.out.println("TernarySearch.search \t\t" + resultIndex);
		System.out.println("");
		
		resultIndex = TernarySearch.search(numbers, target);
		System.out.println("TernarySearch.search \t\t" + resultIndex);
		System.out.println("");
		
		resultIndex = JumpSearch.search(numbers, target);
		System.out.println("JumpSearch.search \t\t" + resultIndex);
		System.out.println("");
		
		resultIndex = ExponentialSearch.search(numbers, target);
		System.out.println("ExponentialSearch.search \t" + resultIndex);
		System.out.println("");
	}

}
