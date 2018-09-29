import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StackMain {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> numList = new ArrayList<Integer>();
        String line = null;

        System.out.println("Enter your input file name");
        Scanner scan = new Scanner(System.in);
        String filename = scan.nextLine(); // Receiving input from user
        File file = new File(filename);

        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);

        Scanner temp = null;
        try {
            temp = new Scanner(file);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Display of the input before operations: ");
        while((line = br.readLine())!= null)
        {
            System.out.println(line);
            String tempStr[] = line.split(" ");
            System.out.println("\n");
            for(int i=0;i<tempStr.length;i++)
            {
                String op[] = tempStr[i].split("\\.");
                if(op[1].equals("push"))
                {
                    numList.add(new Integer(op[0]));
                    System.out.println(op[0]+" is pushed onto the stack");
                }
                else if(op[1].equals("pop"))
                {
                    numList.remove(new Integer(op[0]));
                    System.out.println(op[0]+" is popped from the stack");
                }
            }
            System.out.println("\n Display of Stack after operations is:");

            for(int j = numList.size()-1;j>=0;j--)
            {
                System.out.print(numList.get(j)+" ");
            }
        }
    }
}
