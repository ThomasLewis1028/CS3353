import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import java.util.Scanner;

public class QueueMain {
    public static void main(String[] args) throws IOException {
        QueueEdit queue;
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
        System.out.println();

        while ((line = br.readLine()) != null) {
            System.out.println("File input: ");
            System.out.println(line);

            String arr[] = line.split(" ");
            queue = new QueueEdit(Integer.parseInt(arr[0]));

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