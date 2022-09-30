package b5_graph;

public class Main {

	public static void main(String[] args) {
		System.out.println("Graph");	//לחזור
		var graph1 = new Graph();
		graph1.addNode("A");
		graph1.addNode("B");
		graph1.addNode("C");
		graph1.addNode("D");
		graph1.addEdge("A", "B");
		graph1.addEdge("A", "C");
		graph1.addEdge("A", "D");
		graph1.removeEdge("A", "C");
		graph1.removeEdge("A", "E");
		graph1.removeNode("B");
		graph1.removeNode("A");
		graph1.addEdge("C", "D");
		graph1.addNode("W");
        graph1.addEdge("W", "C");
        graph1.addEdge("C", "W");
		System.out.println(graph1);
		System.out.println("");
		
		var graph2 = new Graph();
		graph2.addNode("A");
		graph2.addNode("B");
		graph2.addNode("C");
		graph2.addNode("D");
		graph2.addNode("E");
		graph2.addEdge("A", "B");
		graph2.addEdge("A", "E");
		graph2.addEdge("B", "D");
		graph2.addEdge("B", "C");
		graph2.addEdge("C", "D");
		graph2.traverseDepthFirsy_recursion("A"); // A B C D E
		graph2.traverseDepthFirsy_recursion("C"); // C D
		graph2.traverseDepthFirsy_recursion("G"); //
		System.out.println("");
		graph2.traverseDepthFirsy("A");
		System.out.println("");
		
		System.out.println("");
		var graph = new Graph();
		graph.addNode("X");
		graph.addNode("A");
		graph.addNode("B");
		graph.addNode("P");
		graph.addEdge("X", "A");
		graph.addEdge("X", "B");
		graph.addEdge("A", "P");
		graph.addEdge("B", "P");
		var list = graph.topologicalSort();
		System.out.println(list);
	}

}
