import java.io.*;
import java.util.*;

public class SortMain {

	public static void main(String[] args) throws IOException {

		String inputData[];
		String bucketData[];
		int tableSize;

		String dataLine;

		System.out.println("Enter your input file name: ");
		Scanner scan = new Scanner(System.in);
		String fileName = scan.nextLine();
//		fileName += ".txt";
		File file = new File(fileName);

		Scanner sc = new Scanner(file);
		dataLine = sc.nextLine();
		inputData = dataLine.split(" ");
		bucketData = dataLine.split(" ");

		tableSize = inputData.length;

		Table operation = new Table(tableSize);
		MergeSort merge = new MergeSort();

		System.out.println("Display before the operation: \n" + dataLine + "\n");

		for(int i = 0; i < bucketData.length;i++) {
			operation.insert(Double.parseDouble(bucketData[i]));
		}

		merge.sort(inputData,0, inputData.length-1);

		System.out.println("Operation After Merge Sort");
		merge.printArray(inputData);
		System.out.println(("Operation After Bucket Sort"));
		operation.printTable();

		System.out.println("Enter the Range you are wanting");
		Scanner range = new Scanner(System.in);
		double num = range.nextDouble();

		System.out.println(num);
		merge.printRange(inputData, num);
		System.out.println();
		operation.printRange(bucketData, num);

	}
}