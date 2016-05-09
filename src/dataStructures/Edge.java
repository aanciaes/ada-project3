package dataStructures;

public class Edge {
	
	private final int startNode;
	private final int finalNode;
	private final int cost;
	
	public Edge (int startNode, int finalNode, int cost) {
		this.startNode=startNode;
		this.finalNode=finalNode;
		this.cost=cost;
	}

	public int getStartNode() {
		return startNode;
	}

	public int getFinalNode() {
		return finalNode;
	}

	public int getCost() {
		return cost;
	}
	
	public boolean isGold() {
		return cost>0;
	}
}
