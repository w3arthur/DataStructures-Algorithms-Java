package a2_likedlist;

import java.util.Arrays;
import java.util.LinkedList;


public class Main {
	public static void main(String args[]) {
		//declare t inside your version
//		LinkedList<Integer> list1 = new LinkedList<Integer>();
//		list1.addFirst(10);
//		list1.addLast(20);
//		list1.addLast(30);
//		list1.addLast(40);
//		list1.remove(2);
//		list1.removeFirst();
//		//list.removeAll(list);
//		var arr = list1.toArray();
//		System.out.println( list1.contains(20) );
//		System.out.println( list1 );
//		System.out.println( Arrays.toString(arr) );
		
		MyLinkedList list = new MyLinkedList();
		System.out.println( list.size() );	//0
		list.addLast(10);	//deleted
		list.addLast(20);
		list.addLast(30);
		list.addLast(50);	//deleted
		System.out.println( list.size() );	//3
		list.removeFirst();
		list.removeLast();

		System.out.println();	
		
		System.out.println( list.indexOf(20) );	//0
		System.out.println( list.indexOf(40) );	//-1
		System.out.println( list.contains(40) );	//false
		System.out.println( list.contains(20) );	//true
		
		var array1 = list.toArray();
		System.out.println( Arrays.toString( array1 ) );
		
		
		list.reverse();
		list.addLast(10);
		
		var array2 = list.toArray();
		System.out.println( Arrays.toString( array2 ) );
		
		System.out.println();
		System.out.println( list.Kth(2) );
		System.out.println( list );
	}
}
