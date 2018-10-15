import java.io.*;
import java.util.Scanner;

public class HashMain
{
    public static void main(String[] args) throws IOException
    {
        String sizeNum[];
        String dataNum[];

        int qVals = 0;
        int tableSize;
        int i;
        boolean check;

        String line;

        System.out.println("Enter your input file name");
        Scanner scan = new Scanner(System.in);
        String filename = scan.nextLine();
        File file = new File(filename);
        Scanner sc = new Scanner(file);

        line = sc.nextLine();

        sizeNum = line.split(" ");

        System.out.println("\ninput: " + line);
        System.out.println("output: ");

        tableSize = Integer.parseInt(sizeNum[0]);
        qVals = Integer.parseInt(sizeNum[1]);

        HashEdit operation = new HashEdit(tableSize);

        for(i = 2; i < sizeNum.length;i++) {

            dataNum = sizeNum[i].split("\\.");

            if(dataNum[1].equals("in")) {
                operation.insert(Integer.parseInt(dataNum[0]));
            }
            else if(dataNum[1].equals("del")) {
                operation.remove(Integer.parseInt(dataNum[0]));
            }
        }
        operation.printHashTable();

        System.out.println();

        for(i = 2;i < sizeNum.length;i++)
        {
            dataNum = sizeNum[i].split("\\.");
            if(dataNum[1].equals("sch")) {
                check = operation.search(Integer.parseInt(dataNum[0]));
                if(check)
                {
                    System.out.println("Found");
                }
                else
                {
                    System.out.println("Not Found");
                }
            }
        }
    }
}