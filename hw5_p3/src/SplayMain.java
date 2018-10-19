import java.io.*;
import java.util.Scanner;

public class SplayMain {
	// test client
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

		System.out.println("Display the tree before (in-order): \n" + dataLine + "\n");

		System.out.println("Display the tree after the operation (in-order):");
		for(int i = 0; i < inputData.length;i++) {
			dataVal = inputData[i].split("\\.");

			if(dataVal[1].equals("in")) {
				//System.out.println(dataVal[0]);
				tree.insert(Integer.parseInt(dataVal[0]));
			}
			else if(dataVal[1].equals("del")) {
				tree.delete(Integer.parseInt(dataVal[0]));
			}
		}

		tree.inorder();

		System.out.println();

		for(int i = 0; i < inputData.length;i++) {
			dataVal = inputData[i].split("\\.");

			if(dataVal[1].equals("sch")){
				if(tree.search(Integer.parseInt(dataVal[0]))) {
					System.out.println("Key Found");
				}
				else {
					System.out.println("Key Not Found");
				}
			}
		}
		/*          50
		 *          /   \
		 *       30      70
		 *      /  \    /  \
		 *     20  40  60   80
		 */

        /*
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // output is 20 30 40 50 60 70 80
        */
	}

}