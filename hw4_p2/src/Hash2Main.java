import java.io.*;
import java.util.Scanner;

public class Hash2Main
{
    public static void main(String[] args) throws IOException
    {
        String sizeNum[];
        String dataNum[];

        int qVals;
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

        Hash2Edit operation = new Hash2Edit(tableSize);
        operation.setQVal(qVals);
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

        for(i = 2;i < sizeNum.length;i++)
        {
            if(i == 2)
            {
                System.out.println();
            }
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