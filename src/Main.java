import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import project.Graph;

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
		Graph g = new Graph (Integer.parseInt(sizes[0]));
		
		for(int i=0;i<Integer.parseInt(sizes[1]);i++){	//sizes [1] represents the number of edges
			String [] edge = reader.readLine().split("\\s");
			
			int cost = Integer.parseInt(edge[3]);
			
			if(edge[2].equals(CROCODILES)){
				cost=Math.negateExact(cost);
			}
			g.addEdge (Integer.parseInt(edge[0]), Integer.parseInt(edge[1]), cost);
		}
	}
}
