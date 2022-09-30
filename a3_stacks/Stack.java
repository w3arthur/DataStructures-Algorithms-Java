package a3_stacks;

import java.util.Arrays;

public class Stack {
	private int[] items;
	private int count;
	private final int increment = 2;
	
	public Stack() {
		items = new int[5];
		count = 0;
	}
	
	/*
	 * private void increaseArraySize() { int[] arr = new
	 * int[(int)(count*increment)]; for(int i = 0; i < items.length; ++i) arr[i] =
	 * items[i]; items = arr; }
	 */
	private boolean isEmpty() {
		return count == 0;
	}

	public void push(int item) {
		if(items.length == count) throw new IllegalStateException();
		items[count] = item;
		count ++;
	}
	public int peek() {
		if( isEmpty() ) throw new IllegalStateException();
		return items[count-1];
	}
	public int pop() {
		int peek = peek();
		count--;
		return peek;
	}
	
	@Override
	public String toString() {
		var contant = Arrays.copyOfRange(items, 0, count);
		return Arrays.toString(contant);
	}
}
