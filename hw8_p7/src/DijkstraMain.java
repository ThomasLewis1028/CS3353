import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DijkstraMain {
	public static void main(String args[]) throws IOException {
		DijkstraAlgo d = new DijkstraAlgo();

		String matrixData[] = null;
		int matrix[][] = new int[8][8];
		int matrixSize;
		String dataLine;

		System.out.println("Enter your input file name: ");
		Scanner scan = new Scanner(System.in);
		String fileName = scan.nextLine();
//		fileName += ".txt";
		File file = new File(fileName);

		Scanner sc = new Scanner(file);
		int n = 0;

		while(sc.hasNextLine()) {
			dataLine = sc.nextLine();
			matrixData = dataLine.split(" ");

			for(int i = 0; i < matrixData.length;i++) {
				if(matrixData[i].equals("inf")) {
					matrix[n][i] = 0;
				}
				else {
					matrix[n][i] = Integer.parseInt(matrixData[i]);
				}
			}
			n++;
		}

		matrixSize = matrixData.length;

		int graph[][] = new int[matrixSize][matrixSize];

		for(int i = 0; i < matrixSize; i++) {
			for(int j = 0; j < matrixSize; j++) {
				graph[i][j] = matrix[i][j];
			}
		}



		d.setsize(matrixSize);
		d.dijkstra(graph, 0);
	}
}
