package b6_graph_undirected;
public class Main {

	public static void main(String[] args) {
		System.out.println("Undirected Graph");
		WeightedGraph graph1 = new WeightedGraph();
		graph1.addNode("A");
		graph1.addNode("B");
		graph1.addNode("C");
		graph1.addEdge("A", "B", 3);
		//graph.addEdge("A", "B", 2);	//TO FIX !!!
		graph1.addEdge("A", "C", 2);
		System.out.println( graph1 ) ;
		
		WeightedGraph graph2 = new WeightedGraph();
		graph2.addNode("A");
		graph2.addNode("B");
		graph2.addNode("C");
		graph2.addEdge("A", "B", 1);
		graph2.addEdge("B", "C", 2);
		//graph.addEdge("B", "C", 10);	//לתקן !!!
		var path = graph2.getShortestPath("A", "C");
		System.out.println(path);
		System.out.println(graph2.hasCycle());
		graph2.addEdge("C", "A", 10);
		System.out.println(graph2.hasCycle());
		
		
		WeightedGraph graph = new WeightedGraph();
		graph.addNode("A");
		graph.addNode("B");
		graph.addNode("C");
		graph.addNode("D");
		graph.addEdge("A", "B", 3);
		graph.addEdge("B", "D", 4);
		graph.addEdge("C", "D", 5);
		graph.addEdge("A", "C", 1);
		graph.addEdge("B", "C", 2);
		var tree = graph.getMinimumSpanningTree();
		System.out.println( tree );
	}

}
