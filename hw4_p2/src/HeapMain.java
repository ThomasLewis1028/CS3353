import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
import java.util.Scanner;

public class HeapMain {
    public static void main(String[] args) throws IOException {
        HeapEdit heap;

        //Testing please ignore
//        heap.in(35);
//        heap.in(33);
//        heap.in(42);
//        heap.in(10);
//        heap.in(14);
//        heap.in(19);
//        heap.in(27);
//        heap.in(44);
//        heap.in(26);
//        heap.in(31);
//        heap.del();
//
//        heap.printHeap("pre");
//        heap.printHeap("post");
//        heap.printHeap("in");

        Scanner scan = new Scanner(System.in);
        String line;

        //Set to rea from a file
        System.out.println("Enter your input file name: ");
        String filename = scan.nextLine();
        File file = new File(filename);

        //Set up file readers
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);

        while((line = br.readLine()) != null){
            System.out.println("File input: ");
            System.out.println(line);

            String arr[] = line.split(" ");
            heap = new HeapEdit(Integer.parseInt(arr[1]));

            for(String val: arr){
                if(val.matches("^-?\\d+\\.in$")){
                    String op[] = val.split("\\.");

                    if(op[1].matches("in"))
                        heap.in(Integer.parseInt(op[0]));
                }else if(val.matches("del"))
                    heap.del();

            }

            System.out.println("File output: ");
            if(arr[0].matches("^pre|post|in$"))
                heap.printHeap(arr[0]);

            System.out.println("-------------------------------------------------------");

        }

    }
}
