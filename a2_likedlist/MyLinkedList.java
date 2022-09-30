package a2_likedlist;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyLinkedList {
	
	private class Node {
		public int value;
		public Node next;
		public Node(int value) { //constructor
			this.value = value;
		}
	}

	private Node first; //head
	private Node last; //tail
	private int size;
	
	public MyLinkedList() {
		resetList();
	}
	
	private boolean isEmpty() {
		return first == null;
	}
	private void resetList() {
		first = null;
		last = null;
		size = 0;
	}
	private Node getPrevius(Node node) {	//n-1	n=last
		var current = first;
		while (current != null) {
			if(current.next == node) return current;
			current = current.next;
		}
		return null;
	}
	
	public void addLast(int item) {
		Node node = new Node(item);
		if (isEmpty()) {first = node; last = node;}
		else {last.next = node; last = node;}
		size++;
	}
	public void addFirst(int item) {
		Node node = new Node(item);
		if (isEmpty()) {first = node; last = node;}
		else {node.next = first; first = node;}	
		size++;
	}
	public int indexOf(int item) {
		int index = 0;
		var current = first;
		while (current != null) {
			if(current.value == item) return index;
			current = current.next;
			index ++;
		}
		return -1;
	}
	public boolean contains(int item) {
		return indexOf(item) != -1;
	}
	public void removeFirst() {
		if(isEmpty()) throw new NoSuchElementException();
		if(first == last) {resetList(); return;} //1 element only;
		//[10 20 -> 30]
		var second = first.next;
		first.next = null;
		first = second;
		size--;
	}
	public void removeLast() {
		//edge cases:
		if(isEmpty()) throw new NoSuchElementException();
		if(first == last) {resetList(); return;}
		//[10 -> 20  30]
		var previus = getPrevius(last);
		last = previus;
		last.next = null;
		size--;
	}
	public int size() {
		return size;
	}
	
	
	public int[] toArray() {
		int[] array = new int[size];
		var current = first;
		var index = 0;
		while (current != null) {
			array[index] = current.value;
			current = current.next;
			index++;
		}
		return array;
	}
	public void reverse() {
		if(isEmpty()) return;
		MyLinkedList linkedList = new MyLinkedList();
		var current = first;
		while(current != null) {
			linkedList.addFirst(current.value);
			current = current.next;
		}
		this.first = linkedList.first;
		this.last = linkedList.last;
		//linkedList = null;
	}
	public void reverseMosh() { //Mosh
		//[10 <- 20 30]
		// p     c		
		if(isEmpty()) return;
		var previus= first;
		var current = first.next;
		last = first;	//focus!
		last.next = null;	//focus!
		while(current != null) {
			var next = current.next;
			current.next = previus;
			previus = current;
			current = next;
		}
		first = previus;	//focus!
	}
	//Kth in one loop!
	public int Kth(int place)  {	//from the end value
		if(isEmpty()) throw new IllegalStateException();
		if(place <= 0 || place > size) throw new IllegalArgumentException();
		var currentA = first;
		var currentB = first;
		for(int i = 0; i < place - 1; ++i) {
			currentB = currentB.next;
			//if(currentB == null) throw new IllegalArgumentException();
		}
		while(currentB != last) {
			currentA = currentA.next;
			currentB = currentB.next;
		}
		return currentA.value;
	}
	public String toString2(){
		int[] arr = this.toArray();
	    return "the array is: " + Arrays.toString(arr);
	}
	
	@Override
	public String toString(){
			String str = "[";
			var current = first;
			while(current != null) {
				str += current.value + (current.next != null ? ", " : "");
				current = current.next;
			}
			str += "]";
		    return "the array is: " + str;
	}
	
}


// methods to apply:
// addFirst
// addLast
// deleteFirst
// deleteLast
// contains
// indexOf