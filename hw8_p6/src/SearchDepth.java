import java.util.Iterator;
import java.util.LinkedList;

class SearchDepth {
	private int V;
	private int discoveryTime[];
	private int finishTime[];
	private int time = 0;
	private int num = 0;

	private LinkedList<Integer> adjacent[];

	SearchDepth(int v) {
		V = v;
		discoveryTime = new int[v];
		finishTime = new int[v];

		adjacent = new LinkedList[v];

		for (int i = 0; i < v; ++i)
			adjacent[i] = new LinkedList();

	}

	void addEdge(int v, int w) {
		adjacent[v].add(w);
	}

	private void depthFirstSearch(int v, boolean visited[]) {
		visited[v] = true;
		int temp = v + 1;

		time = time + 1;
		discoveryTime[num] = time;
		System.out.format("Num: %d Discovery Time: %d/%d\n", temp, discoveryTime[num], time);

		Iterator<Integer> i = adjacent[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();

			if (!visited[n])
				depthFirstSearch(n, visited);
			else {
				time = time + 1;
				System.out.println(time);
				finishTime[num] = time;
				System.out.format("Num: %d Finish Time: %d\n", temp, finishTime[num]);
				num++;
			}
		}

		System.out.println(time + " time");
	}

	void depthFirstSearch(int v) {
		boolean visited[] = new boolean[V];

		depthFirstSearch(v, visited);

		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				depthFirstSearch(i, visited);
			}
		}

	}
}
