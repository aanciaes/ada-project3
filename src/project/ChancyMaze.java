package project;

import dataStructures.*;

public class ChancyMaze {

	private static final double INFINITY = Double.POSITIVE_INFINITY;	//Representing infinity
	private Graph graph;

	public ChancyMaze (Graph graph){
		this.graph=graph;
	}

	/**
	 * Calculates the shortests paths from node origin to all nodes using Bellman-Ford search algorithm
	 * @param origin Origin node
	 * @return An array containing the shortests paths from node origin to all nodes
	 * @throws NegativeWeightCycleException if there is a negative weight cycle
	 */
	private double[] run (int origin) throws NegativeWeightCycleException {
		int numNodes = graph.getGraphSize();
		double [] length = new double [numNodes];

		for(int i=0;i<numNodes;i++)
			length[i] = INFINITY;
		length[origin] = 0;

		boolean changes = false;

		for(int i=1;i<numNodes;i++){
			changes = updateLengths (length);
			if(!changes)
				break;
		}
		if ( changes && updateLengths(length) )
			throw new NegativeWeightCycleException();

		return length;
	}
	
	/**
	 * Auxiliar method to Bellman-Ford algorithm, that updates the shortest path from origin to all nodes in
	 * each iteration 
	 * @param length Array containing shortest distances to all nodes from origin
	 * @return true if there was changes to the distances array in this iteration
	 */
	private boolean updateLengths(double[] length) {
		boolean changes = false;
		Edge [] edges = graph.getEdges();
		for(Edge e : edges){
			int head = e.getStart();
			int tail = e.getEnd();

			if(length[head]<INFINITY){
				double newLength = length[head] + e.getCost();
				if(newLength<length[tail]){
					length[tail] = newLength;
					changes = true;
				}
			}
		}
		return changes;
	}

	/**
	 * Solves the problem. Runs the algorithm and return true if the shortest distance to exit node is negative
	 * @param origin Entrance Node
	 * @param finalNode Exit Node
	 * @return true if the shortest distance to exit node is negative
	 */
	public boolean solve (int origin, int finalNode) {
		try{
			double [] length = run(origin);
			if(length[finalNode]<0)
				return true;
		}catch(NegativeWeightCycleException e){
			//If there exists a negative weight cycle, return true, it is possible to loose money
			return true;
		}
		return false;
	}
}
