import java.io.IOException;
import java.util.*;
import java.io.File;

public class SearchRun {
	public void run() throws IOException {
		String matrixData[] = null;
		int matrixSize;
		int matrix[][] = new int[8][8];
		String dataLine;

		System.out.println("Enter file name: ");
		Scanner scan = new Scanner(System.in);
		String fileName = scan.nextLine();
		File file = new File(fileName);

		Scanner sc = new Scanner(file);
		int n = 0;

		while (sc.hasNextLine()) {
			dataLine = sc.nextLine();
			matrixData = dataLine.split(" ");

			for (int i = 0; i < matrixData.length; i++) {
				matrix[n][i] = Integer.parseInt(matrixData[i]);
			}
			n++;
		}

		matrixSize = matrixData.length;

		SearchBreadth bfs = new SearchBreadth(matrixSize);
		SearchDepth dfs = new SearchDepth(matrixSize);


		for (int i = 0; i < matrixSize; i++) {
			for (int j = 0; j < matrixSize; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}

		for (int i = 0; i < matrixSize; i++) {
			for (int j = 0; j < matrixSize; j++) {
				if (matrix[i][j] == 1) {
					bfs.addEdge(i, j);
					dfs.addEdge(i, j);
				}
			}
		}

		System.out.println("\nBreadth First Search: ");
		bfs.BFS(0);
		System.out.println("\nDepth First Search: ");
		dfs.depthFirstSearch(2);
	}
}
