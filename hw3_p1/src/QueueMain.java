import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import java.util.Scanner;

public class QueueMain {
	public static void main(String[] args) throws IOException {
		QueueEdit queue;
		Scanner scan = new Scanner(System.in);
		String line;

		//Set to rea from a file
		System.out.println("Enter your input file name: ");
		String filename = scan.nextLine();
		File file = new File(filename);

		//Set up file readers
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);

		//Iterate line by line, allows for multiple tests with different Queues
		while ((line = br.readLine()) != null) {
			System.out.println("File input: ");
			System.out.println(line);

			//Split by space delimiter
			String arr[] = line.split(" ");
			queue = new QueueEdit(Integer.parseInt(arr[0]));

			//Iterate through array adding or removing based on input
			for (String val : arr) {
				if (val.matches("^-?\\d+\\.in$")) {
					String op[] = val.split("\\.");

					if (op[1].matches("in")) {
						queue.enQueue(Integer.parseInt(op[0]));
					}
				}
				if (val.matches("del")) {
					queue.deQueue();
				}
			}

			queue.dispQueue();
		}

	}
}