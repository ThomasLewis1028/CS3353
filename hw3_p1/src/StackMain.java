import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StackMain {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> stack;
        Scanner scan = new Scanner(System.in);
        String line;

        System.out.println("Enter your input file name: ");
        String filename = scan.nextLine(); // Receiving input from user
        File file = new File(filename);

        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);

        try {
            Scanner temp = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while ((line = br.readLine()) != null) {
            stack = new ArrayList<Integer>();

            System.out.println("File input: ");
            System.out.println(line);

            String arr[] = line.split(" ");

            for (String val : arr) {
                if (val.matches("^-?\\d+\\.push$")) {
                    String op[] = val.split("\\.");

                    if (op[1].matches("push")) {
                        stack.add(Integer.parseInt(op[0]));
                        System.out.println(op[0] + " pushed onto the stack");
                    }
                }
                if (val.matches("pop")) {
                    if (stack.size() == 0) {
                        System.out.println("Stack is empty");
                    } else {
                        System.out.println(stack.get(0) + " removed from stack");
                        stack.remove(0);
                    }
                }
            }
            System.out.println("Stack values:");

            for (int i = stack.size() - 1; i >= 0; i--)
                System.out.print(stack.get(i) + " ");

            System.out.println();
        }
    }
}