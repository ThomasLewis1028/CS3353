import java.io.*;
import java.util.Scanner;

public class SplayMain {
	public static void main(String[] args) throws IOException {
		SplayEdit tree = new SplayEdit();

		String inputData[];
		String dataVal[];

		String dataLine;

		System.out.println("Enter your input file name: ");
		Scanner scan = new Scanner(System.in);
		String fileName = scan.nextLine();
		fileName += ".txt";
		File file = new File(fileName);
		Scanner sc = new Scanner(file);

		dataLine = sc.nextLine();
		inputData = dataLine.split(" ");

		System.out.println("Before operation: \n" + dataLine + "\n");

		System.out.println("After operation:");
		for (int i = 0; i < inputData.length; i++) {
			dataVal = inputData[i].split("\\.");

			if (dataVal[1].equals("in"))
				tree.insert(Integer.parseInt(dataVal[0]));
			else if (dataVal[1].equals("del"))
				tree.delete(Integer.parseInt(dataVal[0]));
		}

		tree.printSplay();

		System.out.println();

		for (int i = 0; i < inputData.length; i++) {
			dataVal = inputData[i].split("\\.");

			if (dataVal[1].equals("sch")) {
				if (tree.search(Integer.parseInt(dataVal[0])))
					System.out.println("Key Found");
				else
					System.out.println("Key Not Found");
			}
		}
	}
}