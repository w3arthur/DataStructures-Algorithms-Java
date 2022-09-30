package a1_array;
import java.util.ArrayList;

//lookup by index o(1)
//lookup by value o(n)
//insert o(n)
//delete o(n)

public class Main {
	public static void main(String args[]) {
		System.out.println("inside Main of datastructure.array package");
//		int[] number = {10, 20, 30}; //new int[3];
//		// number[0] = 10; numbers[1] = 20; numbers[2] = 30;
//		System.out.println(Arrays.toString(number)); // [10, 20, 30] // [0, 0, 0]
		Array numbers = new Array(3);
		numbers.insert(10);
		numbers.insert(20);
		numbers.insert(30);
		numbers.insert(40);
		numbers.removeAt(0);
		
		numbers.print();
		System.out.println( "the index of:" + numbers.indexOf(40) );
		
		System.out.println("/////");
		
		// Vector : increased by 100%, synchronized, only for 1 core
		// ArrayList: increased by 50%
		ArrayList<Integer> list = new ArrayList<>(); //byte
		list.add(10);
		list.add(20);
		list.add(30);
		list.remove(0);
		
		System.out.println( list );
		System.out.println( list.indexOf(20) );	//0
		System.out.println( list.lastIndexOf(20) );	//0
		System.out.println( list.size() );	//2
		Object[] arr = list.toArray();
		
		
	}
}
