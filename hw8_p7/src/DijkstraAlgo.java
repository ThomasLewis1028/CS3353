import java.lang.*;
import java.util.HashMap;
import java.util.Map;

public class DijkstraAlgo {
	private int size;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	void dijkstra(int graph[][], int src) {
		int distances[] = new int[size];

		//Used a key/value pair to figure out where to put the paths taken to get to a point
		Map<Integer, int[]> edgePath = new HashMap<>();

		//Use a boolean to determine if the current index is the shortest path
		Boolean shortestPaths[] = new Boolean[size];

		//Initialize everything to false first
		for (int i = 0; i < size; i++) {
			distances[i] = Integer.MAX_VALUE;
			shortestPaths[i] = false;
		}

		distances[src] = 0;

		for (int count = 0; count < size - 1; count++) {
			int row = minDistance(distances, shortestPaths);

			shortestPaths[row] = true;

			for (int col = 0; col < size; col++) {
				if (!shortestPaths[col] && //Check if this is the shortest path given
						graph[row][col] != 0 && //Ignore if the value is 0
						distances[row] != Integer.MAX_VALUE && //Ignore if value is int.max_value
						distances[row] + graph[row][col] < distances[col]) { //Check if the distance is smaller

					distances[col] = distances[row] + graph[row][col]; //Stick the smallest into the distances array
					edgePath.put(col, new int[]{row, graph[row][col]}); //Set the edge paths key/value pair
				}
			}
		}

		//Create a new matrix to be safer than editing current matrix
		int[][] newMatrix = new int[size][size];

		//Set up the new graph with the shortest path distances
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (edgePath.get(i) == null)
					newMatrix[i][j] = 0;
				if (i == j)
					newMatrix[i][j] = distances[i];
			}
		}

		//Slap the edge paths into the new matrix
		for (int i = 1; i < size; i++)
			newMatrix[edgePath.get(i)[0]][i] = edgePath.get(i)[1];

		System.out.println("Output Matrix:");
		print(newMatrix, size);
	}

	//Iterate through entire path to see if it follows the shortest distance rule
	int minDistance(int distances[], Boolean arr[]) {
		int min = Integer.MAX_VALUE,
				minIndex = -1;

		for (int v = 0; v < getSize(); v++) {
			if (!arr[v] && distances[v] <= min) {
				min = distances[v];
				minIndex = v;
			}
		}

		return minIndex;
	}

	//Print statement
	public void print(int[][] graph, int size) {
		for (int col = 0; col < size; col++) {
			for (int row = 0; row < size; row++)
				System.out.print(graph[col][row] + " ");

			System.out.println();
		}
	}
}
