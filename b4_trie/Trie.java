package b4_trie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import b3_heap.MaxHeap;

public class Trie {
	//private static final int ALPHABET_SIZE = 26; //A..Z	//array
	private class Node{
		private char value;
		//private Node[] childrenArray;
		private HashMap<Character, Node> children;
		public boolean isEndOfWord;
		public Node(char value){
			this.value = value;
			//childrenArray = new Node[ALPHABET_SIZE];//array
			children = new HashMap();
			isEndOfWord = false;
		}
		@Override
		public String toString() { return "value=" + value; }
		public Node getChild(char ch) { return children.get(ch); }
		public boolean hasChild(char ch) { return children.containsKey(ch); }
		public void addChild(char ch) { children.put(ch, new Node(ch)); }
		
		//array
//		Node getChildArray(char ch) { var index = ch - 'a'; return childrenArray[index]; }
//		boolean hasChildArray(char ch) { return getChildArray(ch) != null; }
//		void addChildArray(char ch) { var index = ch - 'a'; childrenArray[index] = new Node(ch); }
		
		public Node[] getChildren() {
			return children.values().toArray(new Node[0]);
		}
		
		public boolean hasChildren() { return !children.isEmpty(); }
		
		public void removeChild(char ch) {
			children.remove(ch);
		}
		
	}
	private Node root;
	public Trie() { root = new Node(' '); }

	private boolean isNull(Node node) { return node == null; }
	private boolean isNull(String word) { return word == null; }
	public void insert(String word) {
		if(word == null) throw new IllegalStateException();
		var current = root;
		for(var ch : word.toLowerCase().toCharArray()) {
			if (!current.hasChild(ch)) current.addChild(ch);
			current = current.getChild(ch);
		}
		current.isEndOfWord = true;
	}
	

	
	public boolean contains(String word) { //recursion
		if(isNull(word)) return false;  
		return contains(word, 0, root);
	}
	
	private boolean contains(String word, int index, Node node) {
		if(index == word.length()) return node.isEndOfWord;
		char ch = word.toCharArray()[index];
		if(!node.hasChild(ch)) return false;
		else return contains(word, index + 1, node.getChild(ch));
	}
	
	public boolean containsLoop(String word) {
		if(word == null) return false;  
		var current = root;
		for(var ch : word.toLowerCase().toCharArray()) {
			if (!current.hasChild(ch)) return false;
			else current = current.getChild(ch);
		}
		return current.isEndOfWord;// == true;
	}
	
	public void traverse_PreOrder() { traverse_PreOrder(root); }
	
	private void traverse_PreOrder(Node node) {
		System.out.print(node.value);
		for(var ch: node.getChildren()) traverse_PreOrder(ch);
		System.out.print(" ");	
	}
	public void traverse_PostOrder() { traverse_PostOrder(root); }
	private void traverse_PostOrder(Node node) { 
		System.out.print(" ");
		for(var ch: node.getChildren()) traverse_PostOrder(ch);
		System.out.print(node.value);	
	}
	
	public void remove(String word) { if(word == null) return; remove(root, word, 0); }
	private void remove(Node node, String word, int index) { // לחזור
		// לסיים הסרה שתהיה תקפה
		if(index == word.length()) { /*last char*/ // we need preLast child + no -1 because 1st time remove applied on ' ' 
			node.isEndOfWord = false;
			System.out.println("last:" + node.value);
			return; 
		} //
		var ch = word.charAt(index);
		var next = node.getChild( ch );
		if(isNull(next)) return;
		remove(next, word, index + 1);
		if(!next.hasChildren() && !next.isEndOfWord) node.removeChild(ch);
		System.out.println("0:" + node.value);
	}
	
	public List<String> findWords(String prefix){	//לחזור
		List<String> words = new ArrayList<>(); //List = interface ArrayList = implementation
		var lastNode = findLastNodeOf(prefix);
		findWords(lastNode, prefix, words);
		return words;
	}
	private void findWords(Node node, String prefix, List<String> words) {
		if(node.isEndOfWord) words.add(prefix);
		for(var child : node.getChildren()) findWords(child, prefix + child.value, words);
	}
	private Node findLastNodeOf(String prefix) {
		var current = root;
		for(var ch: prefix.toCharArray()) {
			var child = current.getChild(ch);
			if(isNull(child)) return null;
			current = child;
		}
		return current;
	}
	
	public int countWords(String word) { //לתקן
		Node startNode = findLastNodeOf(word);
		return countWords(word, startNode);
	}
	private int countWords(String word, Node node) {
		if(isNull(node)) return 0;
		int count = node.isEndOfWord ? 1 : 0;
		for(var ch: node.getChildren()) {
			count += countWords(word + ch.value, ch );	
		}
		return count;
		
	}
	
	
	
	// לסיים
	//longestCommonPrefix()
	
	//לסיים
	//TraversePreOrder
	//TraversePostOrder
	//FindWords
	//FindWordEnd
	
}
