import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class RBTreeMain {
	public static void main(String[] args) throws IOException {
		Tree tree;

		Scanner scanner = new Scanner(System.in);
		String line;

		System.out.println("Enter your input file name: ");
		String filename = scanner.nextLine();
		File file = new File(filename);

		FileReader fr = new FileReader(filename);
		BufferedReader br = new BufferedReader(fr);

		while ((line = br.readLine()) != null) {
			System.out.println("File input: ");
			System.out.println(line);

			String arr[] = line.split(" ");
			tree = new Tree();

			for (String val : arr) {
				if (val.matches("^-?\\d+\\.(in|sch|del)$")) {
					String op[] = val.split("\\.");

					if (op[1].matches("in"))
						tree.insert(Integer.parseInt(op[0]));
					else if (op[1].matches("sch"))
						tree.search(Integer.parseInt(op[0]));
					else if (op[1].matches("del"))
						tree.remove(Integer.parseInt(op[0]));
				}
			}

			tree.printTree();
		}
	}
}
