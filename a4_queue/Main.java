package a4_queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

//Queque
//FIFO
// enqueue  O(1)	offer//add
// dequeue  O(1)	pull//remove
// peek  O(1)		peek/element
// isEmpty  O(1) 
// isFull O(1)

public class Main {
	public static void main(String args[]) {
		// Queue in java is an interface == construct
		/*Interface to use ArrayDeque class*/ Queue<Integer> javaQueue = new ArrayDeque<>();	//Interface = Class, Implementation
		javaQueue.add(10);
		javaQueue.add(20);
		javaQueue.add(30);
		javaQueue.add(40);
		var front = javaQueue.remove();
		System.out.println(front);
		System.out.println(javaQueue);
	
		reverse(javaQueue);
		System.out.println("reversed: " + javaQueue);
		//Reverse queue
			//allowed to use methods:
			// add
			// remove
			// isEmpty
		
		System.out.println("////////////");
		System.out.println("");
		QueueArray queueArray = new QueueArray();
		queueArray.enqueue(10);
		queueArray.enqueue(20);
		queueArray.enqueue(30);
		queueArray.enqueue(40);
		queueArray.enqueue(50);
		queueArray.enqueue(60);
		
		System.out.println( queueArray.dequeue() );
		System.out.println( queueArray );
		
		System.out.println("////////////");
		System.out.println("");
		QueueCyrcular queueCyrcular = new QueueCyrcular();
		queueCyrcular.enqueue(10);
		queueCyrcular.enqueue(20);
		queueCyrcular.enqueue(30);
		queueCyrcular.enqueue(40);
		queueCyrcular.enqueue(50);
		System.out.println( queueCyrcular.dequeue() );
		queueCyrcular.enqueue(60);
		System.out.println( queueCyrcular.dequeue() );
		System.out.println( queueCyrcular.dequeue() );
		queueCyrcular.enqueue(70);
		System.out.println( queueCyrcular );
		
		System.out.println("////////////");
		System.out.println("");
		QueueStack queueStack = new QueueStack();
		queueStack.enqueue(10);
		queueStack.enqueue(20);
		queueStack.enqueue(30);
		System.out.println( queueStack.dequeue()  );
		System.out.println(queueStack);
		
		System.out.println("////////////");
		System.out.println("");
		PriorityQueue priorityQueue = new PriorityQueue();
		priorityQueue.enqueue(40);
		priorityQueue.enqueue(20);
		priorityQueue.enqueue(60);
		priorityQueue.enqueue(10);
		priorityQueue.enqueue(5);
		priorityQueue.enqueue(2);
		System.out.println( priorityQueue.dequeue()  );
		System.out.println(priorityQueue);
		
	}
	
	
	public static void reverse(Queue<Integer> queue) {
		//q [10, 20, 30]		[]					[30, 20, 10]
		//s						[10, 20, 30]		[]
		Stack<Integer> stack = new Stack<>();
		while(!queue.isEmpty()) stack.push(queue.remove());
		while(!stack.isEmpty()) queue.add(stack.pop());
	}
}
