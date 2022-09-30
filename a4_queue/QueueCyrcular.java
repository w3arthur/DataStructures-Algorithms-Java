package a4_queue;

import java.util.Arrays;

public class QueueCyrcular {	//of array
	private int[] items;
	private int front;
	private int rear;
	private int count;
	private final double extendBy = 2.0;
	
	public QueueCyrcular() {
		items = new int[5];
		front = 0;
		rear = 0;
		count = 0;
	}

//	private void extendArray() {
//		int[] array = new int[(int)(rear*extendBy)];
//		int j=0;
//		for(int i = front; i < rear; i++) {
//			array[j] = items[i];
//			j++;
//		}
//		front = 0;
//		rear = j;
//		items = array;
//	}
	
	private boolean isEmpty() { return front == rear; }
	private boolean isFull() { return items.length == count; }
	public void enqueue(int value) {
		if(isFull()) throw new Error();
		items[rear] = value;
		rear = (rear +1) % items.length;
		count++;
		//rear++;
	}
	public int peek() {
		// if(isEmpty()) throw new Error();
		return items[front];
	}
	public int dequeue() {
		int peek = peek();
		items[front] = 0;
		front = (front + 1) % items.length;
		count--;
		return peek;
	}
	
	@Override
	public String toString() { return Arrays.toString( items ); }
}
