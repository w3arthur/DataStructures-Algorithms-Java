package b6_graph_undirected;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class WeightedGraph { // Weighted
	private class Node {
		public String label;
		public List<Edge> edges; // better Map
		public Node(String lable) { this.label = lable; edges = new ArrayList<>(); }
		public void addEdge(Node to, int weight) { edges.add(new Edge(this, to, weight)); }
		@Override
		public String toString() { return label; }
	}
	private class NodePriority {
		public Node node;
		public int priority;
		public NodePriority(Node node, int priority) { this.node = node; this.priority = priority; }
	}

	private class Edge {
		public Node from;
		public Node to;
		public int weight;
		public Edge(Node from, Node to, int weight) { this.from = from; this.to = to; this.weight = weight; }
		@Override
		public String toString() { return from + " " + weight + "> " + to; } // A->B
	}

	private Map<String, Node> nodes;

	/// private Map<Node, List<Edge>> adjecencyList;
	public WeightedGraph() { nodes = new HashMap<>(); } // adjecencyList = new HashMap<>();

	private boolean isNull(Node node) { return node == null; }

	private boolean isNull(Edge edge) { return edge == null; }
	
	public void addNode(Node node) { addNode(node.label); }
	public void addNode(String lable) {
		nodes.putIfAbsent(lable, new Node(lable));
		// adjecencyList.putIfAbsent(node, new ArrayList<>());
		// Edges will initialize automatically
	}
	/*
	 * public void removeNode(String label) { var node = nodes.get(label);
	 * if(isNull(node)) return; for(var n : adjecencyList.keySet())
	 * adjecencyList.get(n).remove(node); adjecencyList.remove(node);
	 * nodes.remove(node); }
	 */
	public void addEdge(Node from, Node to, Edge weight) { addEdge(from.label, to.label, weight.weight); }
	public void addEdge(String from, String to, int weight) { // relationship
		var fromNode = nodes.get(from);
		var toNode = nodes.get(to);
		if (isNull(fromNode) || isNull(toNode))
			throw new IllegalArgumentException();
		fromNode.addEdge(toNode, weight);
		toNode.addEdge(fromNode, weight);
		// adjecencyList.get(fromNode).add(new Edge(fromNode, toNode, weight));
		/// *!*/adjecencyList.get(toNode).add(new Edge(toNode, fromNode, weight));
	}

	public Path getShortestPath(String from, String to) {
		var fromNode = nodes.get(from);
		var toNode = nodes.get(to);
		if (isNull(fromNode)) throw new IllegalArgumentException();
	    if (isNull(toNode)) throw new IllegalArgumentException();
		Map<Node, Integer> distances = new HashMap<>();
		for (var node : nodes.values()) distances.put(node, Integer.MAX_VALUE);
		Map<Node, Node> previousNodes = new HashMap<>();
		Set<Node> visited = new HashSet<>();
	    PriorityQueue<NodePriority> queue = new PriorityQueue<>( Comparator.comparingInt(ne -> ne.priority));
	    			//queue, PriorityQueue with  Comparator
	    queue.add(new NodePriority(fromNode, 0));	// only item in the queue

		distances.replace(fromNode, 0); // A 0
	    while (!queue.isEmpty()) { 
	    	var current = queue.remove().node;
	    	visited.add(current);

	    	for (var edge : current.edges) {
	    		if (visited.contains(edge.to)) continue;
	    		var newDistance = distances.get(current) + edge.weight;
		        if (newDistance < distances.get(edge.to)) {
		          distances.replace(edge.to, newDistance);
		          previousNodes.put(edge.to, current);
		          queue.add(new NodePriority(edge.to, newDistance));
		        }
	    	}
	    }
	    //return distances.get(toNode);
	    return buildPath(previousNodes,toNode);
	}
	private Path buildPath(Map<Node, Node> previousNodes, Node toNode){
		    Stack<Node> stack = new Stack<>();
		    stack.push(toNode);
		    var previous = previousNodes.get(toNode);
		    while(!isNull(previous)) {
		    	stack.push(previous);
		    	previous = previousNodes.get(previous);
		    }
		    var path = new Path();
		    while(!stack.isEmpty()) path.add(stack.pop().label);
		    return path;
	}
	
	public boolean hasCycle() {
		Set<Node> visited = new HashSet<>();
		for(var node: nodes.values()) 
			if(!visited.contains(node) 
					&& hasCycle(node, null, visited)) return true;
		return false;
	}
	
	//לחזור !
	private boolean hasCycle(Node node, Node parant, Set<Node> visited) {
		visited.add(node);
		for (var edge : node.edges) {
			if(edge.to == parant) continue;
			if( visited.contains((edge.to)) 
					|| hasCycle(edge.to, node, visited) ) return true;
		}
		return false;
	}
	
    public WeightedGraph getMinimumSpanningTree() {
        WeightedGraph tree = new WeightedGraph();
        if (nodes.isEmpty()) return tree;
        PriorityQueue<Edge> edges = new PriorityQueue<>( Comparator.comparingInt(e -> e.weight));
        var startNode = nodes.values().iterator().next();
        edges.addAll(startNode.edges);
        tree.addNode(startNode.label);
        
        if (edges.isEmpty()) return tree;

        
        while (tree.nodes.size() < nodes.size()) {
            var minEdge = edges.remove();
            var nextNode = minEdge.to;
            if ( tree.containsNode(nextNode.label)) continue;
        	tree.addNode(nextNode);
            tree.addEdge(minEdge.from, nextNode, minEdge);
        	for (var edge : nextNode.edges)
        		if(!tree.containsNode(edge.to))
        			edges.add(edge);
        }
        
        
        return tree;
    }
    
    public boolean containsNode(String label) { return nodes.containsKey(label); }
    public boolean containsNode(Node node) { return nodes.containsKey(node.label); }
    // להוסיף remove node
	
	@Override
	public String toString() {
		String str = "";
		for (var node : nodes.values()/* adjecencyList.keySet() */) {
			var targets = node.edges;// adjecencyList.get(source);
			if (!targets.isEmpty())
				str += node + " is connected to " + targets + "\n";
		}
		return str;
	}
}
