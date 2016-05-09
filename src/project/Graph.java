package project;

import java.util.ArrayList;
import java.util.List;

public class Graph {

	private List<Edge> [] graph;

	@SuppressWarnings("unchecked")
	public Graph(int nNodes) {
		graph = (List<Edge>[]) new List[nNodes-1];
	}

	public void addEdge(int startNode, int finalNode, int cost) {
		if(graph[startNode]==null)
			graph[startNode] = new ArrayList<Edge>();
		
		List<Edge> l = graph [startNode];
		
		l.add(new Edge (startNode, finalNode, cost));
	}
	
	public int getGrpahSize () {
		return graph.length+1;
	}
}
