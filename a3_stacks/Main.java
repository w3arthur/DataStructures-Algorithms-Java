package a3_stacks;

//Stacks
// LIFO
// by arrays or linkedList
// all operations in O(1)

public class Main {
	public static void main(String args[]) {
		String strToRevers = "abcd";
		//Stack<char> stk = new Stake<char>();
		StringReverser reverser = new StringReverser();
		System.out.println(reverser.reverse(strToRevers));
		
		String str2 = "(([1] + <2>))[a]";	//match expression
		String str3 = "((<1] + <2>))[a]";	//unMatch expression
		
		String str1 = "(1 + 2)";
		//Edge Cases ?
		String str1_1 = "(1 + 2"; // ( //also (( )
		String str1_2 = "1 + 2)"; // )
		String str1_3 = ")1 + 2("; //) (
		String str1_4 = "1 + 2";
		String str1_5 = "(1 + 2[])()";
		BalancedExpression exp = new BalancedExpression();
		System.out.println( exp.isBalanced(str1) );
		//Edge Cases
		System.out.println( exp.isBalanced(str1_1) );
		System.out.println( exp.isBalanced(str1_2) );
		System.out.println( exp.isBalanced(str1_3) );
		System.out.println( exp.isBalanced(str1_4) );
		System.out.println( exp.isBalanced(str1_5) );
		
		System.out.println();
		
		Stack stack = new Stack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.push(60);
		stack.push(70);
		System.out.println( stack.pop() );
		System.out.println( stack.peek() );
		System.out.println( stack );
	}
}
// Stack is a linkedL ist
//operations:
// push(item)	o(1)
// pop()		o(1)
// peek() 	 o(1)
// isEmpty()	o(1)