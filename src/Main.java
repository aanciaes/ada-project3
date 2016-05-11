import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import dataStructures.Graph;
import project.ChancyMaze;

/**
 * Reads all the inputs and produces the output
 * @author miguel anciaes
 * m.anciaes@campus.fct.unl.pt
 */
public class Main {

	public static final String CROCODILES = "C";
	public static final String YES = "yes";
	public static final String NO = "no";

	public static void main(String[] args) throws IOException {

		//class to read input
		BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));

		String [] sizes = reader.readLine().split("\\s"); //Number of rooms and number of edges

		//sizes [0] represents the number of nodes
		int nEdges = Integer.parseInt(sizes[1]);
		Graph g = new Graph (Integer.parseInt(sizes[0]), nEdges );

		for(int i=0;i<nEdges;i++){	//sizes [1] represents the number of edges
			String [] edge = reader.readLine().split("\\s");		
			int cost = Integer.parseInt(edge[3]);

			//Crocodiles and bags of gold are represented with a negative and a positive cost respectively
			if(edge[2].equals(CROCODILES)){
				cost=Math.negateExact(cost);
			}
			g.addEdge (Integer.parseInt(edge[0]), Integer.parseInt(edge[1]), cost);	//adding edge to graph
		}

		ChancyMaze maze = new ChancyMaze(g);
		if(maze.solve(0, g.getGraphSize()-1))
			System.out.println(YES);
		else
			System.out.println(NO);
	}
}
