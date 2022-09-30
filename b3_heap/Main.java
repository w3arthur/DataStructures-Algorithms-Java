
package b3_heap;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Heap");
		Heap heap2 = new Heap();
		heap2.insert(10);
		heap2.insert(5);
		heap2.insert(17);
		heap2.insert(4);
		heap2.insert(22);
		System.out.println(heap2);
		System.out.println(heap2.remove());
		System.out.println(heap2.remove());
		System.out.println(heap2.remove());

		
		System.out.println("");
		System.out.println(heap2);
		
		int[] numbers = {5, 3, 10, 1, 4, 2};
		Heap heap = new Heap();
		//Heap Sort > maximum heap
		for(var number: numbers) heap.insert(number);
		for(var i = 0 ; i < numbers.length ; i++) numbers[i] = heap.remove();
		
		System.out.println("sorted array with heap: "+Arrays.toString(numbers));
		//Heap Sort < minimum heap
		for(var number: numbers) heap.insert(number);
		for(var i = numbers.length - 1; i >= 0 ; i--) numbers[i] = heap.remove();
		System.out.println(Arrays.toString(numbers));
		System.out.println("");
		
		
		int[] numbers2 = {5, 3, 8, 4, 1, 2};
		MaxHeap.heapify(numbers2);
		System.out.println("heapify= " + Arrays.toString(numbers2) );
		
		int kth = 1;
		int[] numbers3 = {5, 3, 8, 4, 1, 2};

		System.out.println("kth= " + getKthLargest(numbers3, kth) );
	}
	
	public static int getKthLargest(int[] array, int kth) {
		if(kth > array.length || kth < 1) throw new IllegalStateException();
		var heap = new Heap();
		for (var number: array) heap.insert(number);
		
		for(int i = 0; i < kth -1; i++) heap.remove();
		return heap.max();//heap.remove();
	}

}
