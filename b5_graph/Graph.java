package b5_graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {
	private class Node{
		public String lable;
		public Node(String lable) { this.lable = lable; }
		@Override
		public String toString() { return lable; }
	}
	private Map<String, Node> nodes;
	private Map<Node, List<Node>> adjecencyList;
	public Graph () {  
		nodes = new HashMap<>();
		adjecencyList = new HashMap<>();
	}
	
	private boolean isNull(Node node) { return node == null; }
	
	public void addNode(String lable) {
		var node = new Node(lable);
		nodes.putIfAbsent(lable, node);
		adjecencyList.putIfAbsent(node, new ArrayList<>());
	}
	public void removeNode(String label) {
		var node = nodes.get(label);
		if(isNull(node)) return;
		for(var n : adjecencyList.keySet()) adjecencyList.get(n).remove(node);
		adjecencyList.remove(node);
		nodes.remove(label);//nodes.remove(node);
	}
	
	public void addEdge(String from, String to) {	//relationship
		var fromNode = nodes.get(from);
		var toNode = nodes.get(to);
		if(isNull(fromNode) || isNull(toNode)) throw new IllegalArgumentException();
		adjecencyList.get(fromNode).add(toNode);
		//bidirectional graph: adjecenccyList.get(toNode).add(fromNode);
	}
	public void removeEdge(String from, String to) {
		var fromNode = nodes.get(from);
		var toNode = nodes.get(to);
		if(isNull(fromNode) || isNull(toNode)) return;
		adjecencyList.get(fromNode).remove(toNode);
		//adjecenccyList.get(toNode).remove(fromNode);
	}
	
	
	public boolean hasCycle() {
		Set<Node> all = new HashSet<>();
		all.addAll(nodes.values());
		Set<Node> visiting = new HashSet<>();
		Set<Node> visited = new HashSet<>();
		while(!all.isEmpty()) {
			var current = all.iterator().next();//.toArray(new Node[0])[0];
			if( hasCycle(current, all, visiting, visited) ) return true; ;
		}
		return false;
	}
	private boolean hasCycle(Node node, Set<Node> all, Set<Node> visiting, Set<Node> visited) {
		all.remove(node);
		visiting.add(node);
		for(var neighbour : adjecencyList.get(node)) {
			if (visited.contains(neighbour)) continue;
			if (visiting.contains(neighbour)) return true;
			if( hasCycle(neighbour, all, visiting, visited) ) return true;
		}
		visiting.remove(node);
		visited.add(node);
		return false;
	}
	
	public List<String> topologicalSort() {
		Stack<Node> stack = new Stack<>();
		Set<Node> visited = new HashSet<>();
		for(var node: nodes.values())  topologicalSort(node, visited, stack);
		List<String> sortedList = new ArrayList<>();
		while (!stack.empty()) sortedList.add(stack.pop().lable);
		return sortedList;
	}
	private void topologicalSort(Node node, Set<Node> visited, Stack<Node> stack) {
		if(visited.contains(node)) return;
		visited.add(node);
		for(var neighbour : adjecencyList.get(node))
			topologicalSort(neighbour, visited, stack);
		stack.push(node);
	}
	
	public void traverseBreadthFirsy(String rootString) {
		var node = nodes.get(rootString);
		if(isNull(node)) return;
		Set<Node> visited = new HashSet<>();
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(node);
		while(!queue.isEmpty()) {
			var current = queue.remove();
			if(visited.contains(current)) continue;
			visited.add(current);
			System.out.print(current + " ");
			for(var neighbour : adjecencyList.get(current)) if(!visited.contains(neighbour)) queue.add(neighbour);
		}
	}
	
	//Iteration
	public void traverseDepthFirsy(String rootString) {
		var node = nodes.get(rootString);
		if(isNull(node)) return;
		Set<Node> visited = new HashSet<>();
		Stack<Node> stack = new Stack<>();
		stack.push(node);
		while(!stack.isEmpty()) {
			var current = stack.pop();
			if(visited.contains(current)) continue;
			visited.add(current);
			System.out.print(current + " ");
			for(var neighbour : adjecencyList.get(current)) if(!visited.contains(neighbour)) stack.push(neighbour);
		}
	}
	
	
	public void traverseDepthFirsy_recursion(String rootString) {
		Node node = nodes.get(rootString);
		if(isNull(node)) return;
		traverseDepthFirsy_recursion(node, new HashSet<>());
		System.out.println("");
	}
	private void traverseDepthFirsy_recursion(Node root, Set<Node> visited) {
		System.out.print(root + " ");
		visited.add(root);
		for(var node: adjecencyList.get(root)) 
			if(!visited.contains(node)) traverseDepthFirsy_recursion(node, visited);
	}

	@Override
	public String toString() {
		String str = "";
		for(var source: adjecencyList.keySet()) {
			var targets = adjecencyList.get(source);
			if(!targets.isEmpty()) str += source + " is connected to " + targets;
		}
		return str;
	} 
}
