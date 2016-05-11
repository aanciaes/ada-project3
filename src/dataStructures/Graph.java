package dataStructures;

public class Graph {

	//Array with all edges of the graph
	private Edge [] edges;

	//NUmber of nodes
	private int nNodes;

	private int count;

	public Graph(int nNodes, int nEdges) {
		edges=new Edge [nEdges];
		this.nNodes=nNodes;
		count=0;
	}

	/**
	 * Adds an edge to the graph
	 * @param startNode First Node
	 * @param finalNode Last Node
	 * @param cost Cost of the path
	 */
	public void addEdge (int startNode, int finalNode, int cost) {
		edges[count++]=new Edge(startNode, finalNode, cost);
	}

	/**
	 *Returns the number of nodes in the graph
	 * @return Number of nodes in the graph
	 */
	public int getGraphSize () {
		return nNodes;
	}

	/**
	 * Returns an array containing all the edges of the graph
	 * @return An array containing all the edges of the graph
	 */
	public Edge [] getEdges () {
		return edges;	
	}
}
