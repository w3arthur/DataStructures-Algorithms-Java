package a4_queue;

import java.util.Stack;


////// !!!!!! EDGE CASES !!!!!!!

//enqueue
//dequeue
//peek
//isEmpty
//isFull
//	Q [10, 20, 30]
// S1 [10, 20, 30]
// S2 []


//	queue (fifo)
// -->	[  ]
//		[  ] -->

//stack (lifo)
//-->	[  ]	-->
//		[  ]

//run time O(n)

public class QueueStack {	//of array
	
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;

	private final double extendBy = 2.0;
	
	public QueueStack() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}

	private void exchangeStacks(Stack<Integer> stack1, Stack<Integer> stack2 ) {
		while(!stack1.isEmpty()) stack2.push( stack1.pop() );
	}
	
	public void enqueue(int value) {	//O(1)
		stack1.push(value);
	}
	public int peek() {			// O(n)
		if(stack1.isEmpty()) throw new IllegalStateException();
		exchangeStacks(stack1, stack2);
		int value = stack1.peek();
		exchangeStacks(stack2, stack1);
		return value;
	}
	public int dequeue() {
		if(stack1.isEmpty()) throw new IllegalStateException();
		exchangeStacks(stack1, stack2);
		int value = stack1.pop();
		exchangeStacks(stack2, stack1);
		return value;
	}
	
	@Override
	public String toString() { return stack1.toString(); }
}
