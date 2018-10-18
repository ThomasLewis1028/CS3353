import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StackMain {
	public static void main(String[] args) throws IOException {
		ArrayList<Integer> stack;
		Scanner scan = new Scanner(System.in);
		String line;

		//Set to read from a file
		System.out.println("Enter your input file name: ");
		String filename = scan.nextLine(); // Receiving input from user
		File file = new File(filename);

		//Set up file readers
		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);
		//Iterate line by line, allows for multiple tests with different Stacks
		while ((line = br.readLine()) != null) {
			stack = new ArrayList<Integer>();

			//Output file input
			System.out.println("File input: ");
			System.out.println(line);

			//Split by space delimiter
			String arr[] = line.split(" ");

			//Iterate through new array
			for (String val : arr) {
				//Sanitize input to check for push
				if (val.matches("^-?\\d+\\.push$")) {
					String op[] = val.split("\\.");

					//Push value onto stack
					if (op[1].matches("push")) {
						stack.add(Integer.parseInt(op[0]));
						System.out.println(op[0] + " pushed onto the stack");
					}
				}
				if (val.matches("pop")) {
					//Check if stack is empty to avoid error
					if (stack.size() == 0) {
						System.out.println("Stack is empty");
					} else {
						//Pop item from stack
						System.out.println(stack.get(0) + " removed from stack");
						stack.remove(0);
					}
				}
			}
			System.out.println("Stack values:");

			//Print all items in stack
			for (int i = stack.size() - 1; i >= 0; i--)
				System.out.print(stack.get(i) + " ");

			System.out.println();
		}
	}
}