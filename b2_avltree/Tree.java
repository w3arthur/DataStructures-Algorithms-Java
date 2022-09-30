package b2_avltree;
import java.util.ArrayList;

public class Tree {
	private class Node{
		public int value;
		public int height;
		public Node leftChild;
		public Node rightChild;
		public Node(int value){
			this.value = value;
		}
	}
	private Node root;
	private boolean isNull(Node node) { return node == null;}
	private boolean isLeaf(Node node) { return node.leftChild == null && node.rightChild == null; }
	private int getHeightValue(Node node) { return isNull(node) ? -1 : node.height; }
	private int getMaxHeight(Node node) { return 1 + Math.max(getHeightValue(node.leftChild), getHeightValue(node.rightChild)); }	
	private int balanceFactor(Node node) { return isNull(node) ? 0 : getHeightValue(node.leftChild) - getHeightValue(node.rightChild) ; }
	 // 1 left heavy // -1 right heavy
	// 10		right heavy tree			  20
	//   20	(-1)!						=>	10  30
	//     30	lefRotate(10)				
	// ------	10	20	30
	// 10		right heavy tree			10			  20
	//   30	(1)!						=>	  20	+>	10  30
	// 20		lefRotate(30) + RightRotate(10)	    30		
	// --		
	
	public void insert(int value) {	//recursive insert
		if(isNull(root)) {root = new Node(value); return;}
		root = insert(root, value);
	}
	private Node insert(Node node, int value) {
		if(isNull(node)) node = new Node(value);
		else if( value < node.value) node.leftChild = insert(node.leftChild, value);
		else if(value > node.value) node.rightChild = insert(node.rightChild, value);
		else throw new IllegalStateException();
		node.height = getMaxHeight(node);
		return balance(node);	//node
	}
	//private int getMaxHeight(Node node) { return Math.max(node.rightChild.height, node.leftChild.height); }
	//getMaxHeightMosh

	
	
	
	private Node balance(Node node) {
		if( balanceFactor(node) > 1 ) {
			if(balanceFactor(node.leftChild) < 0) {node.leftChild = rotateLeft(node);/*System.out.println("Left Route" + node.leftChild.value);*/}
			return rotateRight(node);/*System.out.println("Right Route" + node.value);*/
		} else if( balanceFactor(node) < -1 ) {
			if(balanceFactor(node.rightChild) > 0) {node.rightChild = rotateRight(node);/*System.out.println("Right Route" + node.rightChild.value);*/}
			return rotateLeft(node);/*System.out.println("Left Route" + node.value);*/
		} else return node;
	}
	
	private Node rotateLeft(Node node) {	//maybe new root
		var topNode = node.rightChild;
		node.rightChild = topNode.leftChild;
		topNode.leftChild = node;
		node.height = getMaxHeight(node);
		topNode.height = getMaxHeight(topNode);
		return topNode;
		// 10		  20
		//  20	=>	10  30
		//   30		
	}
	private Node rotateRight(Node node) {	//maybe new root
		var topNode = node.leftChild;
		node.leftChild = topNode.rightChild;
		topNode.rightChild = node;
		node.height = getMaxHeight(node);
		topNode.height = getMaxHeight(topNode);
		return topNode;
		//   30		  20
		//  20	=>	10  30
		// 10		
	}



	
	
	
	
	
	
	/*1*/ public boolean isBalanced() { return balanceFactor(root) <= 1 && balanceFactor(root) >= -1; }
	/*2*/ public boolean isPerfect() { return isPerfect(root); }
	private boolean isPerfect(Node node) {
		if(isNull(node)) return true;
		if( isNull(node.leftChild) && !isNull(node.rightChild) || !isNull(node.rightChild) && isNull(node.leftChild)) return false;
		return isPerfect(node.leftChild) && isPerfect(node.rightChild) ;
	}
	
	public String traverseLevelOrder() {
		String string = "";
		for(var i = 0; i <= height(); i++) string +=( i + "| "+ getNodesAtDistance(i) + "\n");
		return string;
	}
	public ArrayList<Integer> getNodesAtDistance(int distance){ 
		var list = new ArrayList<Integer>();
		getNodesAtDistance(root, distance, list); /*System.out.println("");*/
		return list;
	}
	private void getNodesAtDistance(Node node, int distance, ArrayList<Integer> list){
		if (isNull(node)) return;
		if (distance == 0) {list.add( node.value ); /*System.out.print( node.value + " " );*/ return;}
		getNodesAtDistance(node.leftChild, distance - 1, list);
		getNodesAtDistance(node.rightChild, distance - 1, list);
	}
	public int height() { return height(root); }
	private int height(Node node) {
		if(isNull(node)) return Integer.MIN_VALUE;//-1;
		if(isLeaf(node)) return 0; // base condition
		return 1 + Math.max( height(node.leftChild), height(node.rightChild) );
	}
	@Override
	public String toString() { return traverseLevelOrder(); }


}