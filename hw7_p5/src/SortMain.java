import java.io.*;
import java.util.*;

public class SortMain {

	public static void main(String[] args) throws IOException {

		String inputData[];
		String bucketData[];
		String input;

		System.out.println("Enter the file name: ");
		Scanner scan = new Scanner(System.in);
		File file = new File(scan.nextLine());
		Scanner sc = new Scanner(file);

		input = sc.nextLine();
		inputData = input.split(" ");
		bucketData = input.split(" ");

		int tableSize = inputData.length;

		Table operation = new Table(tableSize);
		SortMerge merge = new SortMerge();

		System.out.println("Pre-operation output: \n" + input + "\n");

		for(int i = 0; i < bucketData.length;i++) {
			operation.insert(Double.parseDouble(bucketData[i]));
		}

		merge.sort(inputData,0, inputData.length-1);

		System.out.println("Post-MergeSort");
		merge.printArr(inputData);
		System.out.println(("Post BucketSort"));
		operation.printTable();

		System.out.println("Enter the Range");
		Scanner range = new Scanner(System.in);
		double num = range.nextDouble();

		System.out.println(num);
		merge.printRange(inputData, num);
		System.out.println();
		operation.printRange(bucketData, num);

	}
}