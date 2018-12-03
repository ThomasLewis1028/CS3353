import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//This file is basically identical to all of my other input mains except the one I broke out into a ProgRun class
public class DijkstraMain {
	public static void main(String args[]) throws IOException {
		DijkstraAlgo d = new DijkstraAlgo();

		String matrixData[];
		int matrixSize;
		String dataLine;

		System.out.println("Enter your input file name: ");
		Scanner scan = new Scanner(System.in);
		String fileName = scan.nextLine();
		File file = new File(fileName);

		//Used the buffered reader to take the input as the matrix's size
		BufferedReader br = new BufferedReader(new FileReader(file));
		matrixData = br.readLine().split(" ");
		matrixSize = matrixData.length;
		int matrix[][] = new int[matrixSize][matrixSize];

		Scanner sc = new Scanner(file);
		int n = 0;

		System.out.println("Matrix input:");
		while(sc.hasNextLine()) {
			dataLine = sc.nextLine();
			System.out.println(dataLine);
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

		System.out.println();

		int graph[][] = new int[matrixSize][matrixSize];

		for(int i = 0; i < matrixSize; i++) {
			for(int j = 0; j < matrixSize; j++) {
				graph[i][j] = matrix[i][j];
			}
		}

		d.setSize(matrixSize);
		d.dijkstra(graph, 0);
	}
}
