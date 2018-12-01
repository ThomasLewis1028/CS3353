import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.lang.*;
import java.util.HashMap;
import java.util.Map;

public class DijkstraAlgo {
	private int size;

	public int getsize() {
		return size;
	}

	public void setsize(int size) {
		this.size = size;
	}

	int minDistance(int dist[], Boolean arr[]) {
		int min = Integer.MAX_VALUE,
				min_index = -1;

		for (int v = 0; v < getsize(); v++) {
			if (!arr[v] && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}
		}

		return min_index;
	}

	void dijkstra(int graph[][], int src) {
		int dist[] = new int[size];

		Map<Integer, int[]> edgePath = new HashMap<>();

		Boolean sptSet[] = new Boolean[size];

		for (int i = 0; i < size; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}

		dist[src] = 0;

		for (int count = 0; count < size - 1; count++) {
			int row = minDistance(dist, sptSet);

			sptSet[row] = true;

			for (int col = 0; col < size; col++) {

				if (!sptSet[col] && graph[row][col] != 0 && dist[row] != Integer.MAX_VALUE && dist[row] + graph[row][col] < dist[col]) {
					dist[col] = dist[row] + graph[row][col];
					edgePath.put(col, new int[]{row, graph[row][col]});
				}
			}
		}


		int[][] newGraph = new int[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (edgePath.get(i) == null)
					newGraph[i][j] = 0;
				if(i == j)
					newGraph[i][j] = dist[i];
			}
		}

		for(int i = 1; i < size; i++)
			newGraph[edgePath.get(i)[0]][i] = edgePath.get(i)[1];


		print(newGraph, size);
	}

	public void print(int[][] graph, int size){
		for(int col = 0; col < size; col++){
			for(int row = 0; row < size; row++)
				System.out.print(graph[col][row] + " ");

			System.out.println();
		}
	}
}
