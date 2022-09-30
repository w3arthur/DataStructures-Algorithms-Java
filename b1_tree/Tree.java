package b1_tree;

import java.awt.IllegalComponentStateException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

import javax.lang.model.type.NullType;

public class Tree {
	private class Node {
		public int value;
		public Node leftChild; // next
		public Node rightChild; // previous
		public Node(int value) { this.value = value; }
	}
	private Node root;
	
	private boolean isNull(Node node) { return node == null; }
	private boolean isLeaf(Node node) { return node.leftChild == null && node.rightChild == null; }

	public void insert(int value) {
		if(isNull(root)) {root = new Node(value); return;}
		var current = root;
		while (true) {
			if(value < current.value) {
				if(isNull(current.leftChild)) {current.leftChild = new Node(value); break;}
				current = current.leftChild;
			} else if (value > current.value) {
				if(isNull(current.rightChild)) {current.rightChild = new Node(value); break;}
				current = current.rightChild;
			} else /*==*/ return;
		}
	}
	public boolean find(int value) {
		var current = root;
		while ( !isNull(current) ) {
			if(value == current.value) return true;
			current = value < current.value ? current.leftChild : current.rightChild;
//			if(value < current.value) current = current.leftChild;
//			else if(value > current.value) current = current.rightChild;
//			else /*==*/ return true;
		}
		return false;
	}
	
	public void traversePreOrder() { traversePreOrder(root); System.out.println(""); } // Root, Left, Right
	private void traversePreOrder(Node node) {
		if(isNull(node)) return;	//base condition
		System.out.print(node.value + " ");
		traversePreOrder(node.leftChild);
		traversePreOrder(node.rightChild);
	}
	
	
	public void traverseInOrder() { traverseInOrder(root); System.out.println(""); } // Left, Root, Right
	private void traverseInOrder(Node node) {	// from low to high  1 2 3 4 ...
		if(isNull(node)) return;	//base condition
		traverseInOrder(node.leftChild);
		System.out.print(node.value + " ");	//Root
		traverseInOrder(node.rightChild);
	}
	
	public void traversePostOrder() { traversePostOrder(root); System.out.println(""); } // Left, Right, Root
	private void traversePostOrder(Node node) {
		if(isNull(node)) return;	//base condition
		traversePostOrder(node.leftChild);
		traversePostOrder(node.rightChild);
		System.out.print(node.value + " ");	//Root
	}
	
	public int height() { return height(root); }
	private int height(Node node) {
		if(isNull(node)) return Integer.MIN_VALUE;//-1;
		if(isLeaf(node)) return 0; // base condition
		return 1 + Math.max( height(node.leftChild), height(node.rightChild) );
	}
	
	public int min() { return min(root); }
	private int min(Node node) { // O(n)
		if(isLeaf(node)) return node.value;	//base condition
		var left = min(node.leftChild);
		var right = min(node.rightChild);
		return Math.min( Math.min(left,right), node.value );
	}
	
	public int min_binarySearchTree() { // O(log(n)) --> O(n)
		if(isNull(root)) throw new IllegalStateException();
		var current = root;
		while ( !isNull(current.leftChild) ) current = current.leftChild;
		return current.value;
	}
	
	
	public boolean equals(Tree other) {
		if(other == null) return false;
		return equals(this.root, other.root);
	}
	private boolean equals(Node first, Node second) {
		if(isNull(first) && isNull(second)) return true;
		if(!isNull(first) && !isNull(second)) 
			return	first.value == second.value
					&& equals(first.leftChild, second.leftChild)
					&& equals(first.rightChild, second.rightChild);
		return false;
	}
	
	public boolean isBinarySearchTree() { return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE); }
	public void swapRoot() { var temp = root.leftChild; root.leftChild = root.rightChild; root.rightChild = temp; }
	private boolean isBinarySearchTree(Node node, int min, int max) {
		if(isNull(node)) return true;
		if(node.value < min || node.value > max) return false;
		return isBinarySearchTree(node.leftChild, min, node.value) && isBinarySearchTree(node.rightChild, node.value, max );			
	}
	
	private void getNodesAtDistance(Node node, int distance, ArrayList<Integer> list){
		if (isNull(node)) return;
		if (distance == 0) {list.add( node.value ); /*System.out.print( node.value + " " );*/ return;}
		getNodesAtDistance(node.leftChild, distance - 1, list);
		getNodesAtDistance(node.rightChild, distance - 1, list);
	}
	
	public ArrayList<Integer> getNodesAtDistance(int distance){ 
		var list = new ArrayList<Integer>();
		getNodesAtDistance(root, distance, list); /*System.out.println("");*/
		return list;
	}
	
	public void traverseLevelOrder() {
		for(var i = 0; i <= height(); i++) {
			var list = getNodesAtDistance(i);
			System.out.println( i + "| "+ list);
		}
	}
	
	
	
	
	
	
	
	//My isBinarySearchTree;
	
	/*1*/public int size() { return size(root); }
	private int size(Node node) {
		if(isNull(node)) return 0;
		return 1 + (!isNull(node.leftChild) ? size(node.leftChild) : 0)
				 + (!isNull(node.rightChild) ? size(node.rightChild) : 0);
	}

	
	/*2*/public int countLeavels() {
		return countLeavels(root, 0);
	}
	private int countLeavels(Node node, int level) {
		if(isNull(node)) return level;
		return  1 + Math.max(countLeavels(node.leftChild, level), countLeavels(node.rightChild, level));
	}
	
	
	/*3*/public int max() {
		if(isNull(root)) throw new IllegalComponentStateException();
		return Math.max(max(root), root.value);
	}
	private int max(Node node) {
		if(isNull(node)) return Integer.MIN_VALUE;
		return Math.max( isNull(node.leftChild) ? node.value : max(node.leftChild)
						, isNull(node.rightChild) ? node.value : max(node.rightChild)
		);
//				isNull(node.leftChild) ? Math.max(node.value, max(node.rightChild)) 
//					: isNull(node.rightChild) ? Math.max(max(node.leftChild), node.value) 
//					: Math.max(max(node.leftChild), max(node.rightChild));
	}
	
	
	public boolean contains(int value) {
		return contains(root, value);
	}
	private boolean contains(Node node, int value) { //O(log(n))!!! /O(n)
		if(isNull(node)) return false;
		if(value == node.value) return true;
		//return value < node.value ? contains(node.leftChild, value) : contains(node.rightChild, value); //	O(log(n))
		return contains(node.leftChild, value) || contains(node.rightChild, value); //O(n)
	}
	
	
	
	private ArrayList<Integer> tempList;
	public int size1() {
		tempList = new ArrayList<>();
		traverseInOrder2(root);
		int size = tempList.size();
		tempList = null;
		return size;
	}
	
	public boolean isBinarySearchTree2() {	// from low to high  1 2 3 4 ...
		tempList = new ArrayList<>();
		traverseInOrder2(root);
		int[] array = tempList.stream().mapToInt(i->i).toArray();
		int[] sortedArray = array.clone();
		Arrays.sort(sortedArray);
		tempList = null;
		return Arrays.equals(array, sortedArray);
	}
	private void traverseInOrder2(Node node) {	// from low to high  1 2 3 4 ...
		if(isNull(node)) return;	//base condition
		traverseInOrder2(node.leftChild);
		tempList.add(node.value);
		traverseInOrder2(node.rightChild);
	}
	
	
    /*AVL*/
    /*1*/
    private boolean isBalanced(Node node)
    {
        if (isNull(node)) return true;
        return Math.abs(height(node.leftChild) - height(node.rightChild))  <= 1
            && isBalanced(node.leftChild)
            && isBalanced(node.rightChild);
    }
    public boolean isBalanced() 
    {
        if (isNull(root)) return true;
        return isBalanced(root);
    }
    /*2*/
    private boolean isPerfect(Node node)
    {
        if (isNull(node)) return true;
        return height(node.leftChild) - height(node.rightChild) == 0
            && isPerfect(node.leftChild)
            && isPerfect(node.rightChild);
    }
    public boolean isPerfect()
    {
        if (isNull(root)) return true;
        return isPerfect(root);
    }
	
}
