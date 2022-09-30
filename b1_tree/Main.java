package b1_tree;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Non linear data structure");
		Tree tree = new Tree();
		tree.insert( 7 );
		tree.insert( 4 );
		tree.insert( 9 );
		tree.insert( 1 );
		tree.insert( 6 );
		tree.insert( 8 );
		tree.insert( 10 );
		System.out.println( tree.find( 10 ) );
		System.out.println( tree.find( 5 ));
		System.out.println("");
		// Pre-Order	Root, left, right
		// In-Order		left, Root, right
		// Post-Order	left, right, Root
		
		System.out.println( factorial_it(4) );
		System.out.println( factorial_re(5) );
		System.out.println("//////");
		System.out.println("");
		//DEPTH FIRST
		tree.traversePreOrder();
		tree.traverseInOrder();
		tree.traversePostOrder();
		System.out.println("//////");
		System.out.println("");
		System.out.println( tree.height() );
		System.out.println( tree.min() );
		System.out.println( tree.min_binarySearchTree() );
		
		Tree tree2 = new Tree();
		tree2.insert( 7 );
		tree2.insert( 4 );
		tree2.insert( 9 );
		tree2.insert( 1 );
		tree2.insert( 6 );
		tree2.insert( 8 );
		tree2.insert( 10 );
		System.out.println( tree.equals(tree2) );
		Tree tree3 = new Tree();
		tree3.insert( 7 );
		tree3.insert( 4 );
		tree3.insert( 9 );
		tree3.insert( 1 );
		tree3.insert( 6 );
		tree3.insert( 8 );
		
		System.out.println( tree.equals(tree3) );
		System.out.println( tree.equals(null) );
		
		System.out.println( tree.isBinarySearchTree() );
		tree2.swapRoot();
		System.out.println( tree2.isBinarySearchTree() );
		System.out.println( tree.isBinarySearchTree() );
		System.out.println( tree2.isBinarySearchTree2() );
		
		System.out.println( tree.getNodesAtDistance(0) );
		System.out.println( tree.getNodesAtDistance(1) );
		System.out.println( tree.getNodesAtDistance(2) );
		System.out.println( tree.getNodesAtDistance(3) );
		System.out.println( tree.getNodesAtDistance(30) );
		//BREADTH FIRST
		tree.traverseLevelOrder();
		System.out.println( tree.size1() );
		System.out.println( tree.size() );
		Tree tree4 = new Tree();
		System.out.println( tree4.size() );
		System.out.println(  );

		tree3.insert(5);
		System.out.println( tree3.countLeavels() );
		System.out.println( "max" );
		System.out.println( tree.max() );
		System.out.println( tree.contains(4) );
	}
	
	// 4! = 4 x 3 x 2 x 1
	// 3! = 3 x 2 x 1	
	public static int factorial_it(int n) { // iteration
		var factorial = 1;
		for (var i = n; i > 1; i--) factorial *= i;
		return factorial;
	}
	// 4! = 4 x 3!
	// 3! = 3 x 2!
	// n! = n x (n-1)!	// f(n) = n x f(n-1)
	public static int factorial_re(int n) { // recursion
		if(n == 1) return 1;	//base condition for recursion
		return n * factorial_re(n-1);
	}
}
