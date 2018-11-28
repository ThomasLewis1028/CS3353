import java.util.Iterator;
import java.util.LinkedList;

/*
2. DFS: discovery time/finish time on each vertex
Input: take an input graph in the form of adjacency matrix.

0 1 0 0 0 0 0 0
0 0 1 0 1 1 0 0
0 0 0 1 0 0 1 0
0 0 1 0 0 0 0 1
1 0 0 0 0 1 0 0
0 0 0 0 0 0 1 0
0 0 0 0 0 1 0 1
0 0 0 0 0 0 0 1

(* Notice that (8,8) is a self loop)
Output: an adjacency matrix of a DFS tree and each coordinate along diagonal
should contain the (discovery time/finish time) of each vertex once the algorithm completed

(13/14) 0 0 0 0 0 0 0
0 (11/16) 0 0 1 0 0 0
0 0 ( 1/10) 1 0 0 1 0
0 0 0 ( 8/ 9) 0 0 0 0
1 0 0 0 (12/15) 0 0 0
0 0 0 0 0 ( 3/ 4) 0 0
0 0 0 0 0 1 ( 2/ 7) 1
0 0 0 0 0 0 0 ( 5/ 6)

(* Notice that (8,8) was a self loop in the input and overwritten by (5/6) once the algorithm is completed)
 */

class SearchDepth {
	private int V;   // No. of vertices
	private int discoveryTime[];
	private int finishTime[];
	private int time = 0;
	int num = 0;

	// Array  of lists for Adjacency List Representation
	private LinkedList<Integer> adj[];

	// Constructor
	SearchDepth(int v) {
		V = v;
		discoveryTime = new int[v];
		finishTime = new int[v];

		//System.out.println(v + " this is v");
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i) {
			adj[i] = new LinkedList();
		}
	}

	//Function to add an edge into the graph
	void addEdge(int v, int w) {
		adj[v].add(w);  // Add w to v's list.
	}

	// A function used by DFSvoid
	void DFSUtil(int v, boolean visited[]) {

		// Mark the current node as visited and print it
		visited[v] = true;
		int temp = v+1;
		//System.out.print(temp + " ");

		time = time+1;
		discoveryTime[num] = time;
		System.out.println("num: " + temp + " discoveryTime: " + discoveryTime[num] + "/" + time);

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> i = adj[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();

			if (!visited[n]) {
				DFSUtil(n, visited);
			}
			else {
				time = time + 1;
				System.out.println(time);
				finishTime[num] = time;
				System.out.println("num: " + temp + " finishTime: " + finishTime[num]);
				num++;
			}
		}

		System.out.println(time + " time");

		//for(int j = 0; j < num; j++) {
		//System.out.println(num);
		//    System.out.println(discoveryTime[num] + "/" + finishTime[num]);
		//}
	}


	// The function to do DFS traversal. It uses recursive DFSUtil()

	void DFS(int v) {
		// Mark all the vertices as not visited(set as
		// false by default in java)
		boolean visited[] = new boolean[V];

		DFSUtil(v, visited);

		for(int i = 0; i < V; i++) {
			if(!visited[i]) {
				DFSUtil(i, visited);
			}
		}

		// Call the recursive helper function to print DFS traversal
		// DFSUtil(v, visited);
	}



    /*
            3. Implement topological sort.

            Input: the output from the above DFS

            Output: a list of nodes sorted in non-decreasing order

            (11/16), (12/15), (13,14), (1/10), (8/9), (2/7), (5/6), (3/4)

            4. Implement strongly connected components

            Input: the output from the above DFS

            Output: a topologically sorted list of nodes per component in a non-decreasing
            order by the number of nodes

     *      ((11/16), (12/15), 13/14)), ((1/10), (8/9)), ((2/&), (3/4)), ((5/6))
     */


	void print() {
		System.out.println();
		for(int i = 0; i < num; i++) {
			//System.out.println(num);
			System.out.println("\n" + discoveryTime[num] + " discovery time and time: " + time);
		}
	}
}
