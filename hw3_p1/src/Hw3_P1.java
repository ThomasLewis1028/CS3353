import java.util.Scanner;

public class Hw3_P1 {


    public static void main(String[] args)
    {
        String pattern = "^\\d+\\.(in_\\d+|del|sch|in)$";
        Scanner scanner = new Scanner(System.in);
        EditNode linkedList = new EditNode();

        while(true){
            System.out.print("Node command: ");
            String in = scanner.next();

            if(in.matches("exit/i"))
                break;
            else if (in.matches(pattern)){
                String[] arr = in.split("\\.|_");
                int x = Integer.parseInt(arr[0]);

                switch (arr[1]){
                    case "in":
                        if(arr[2] == null)
                            linkedList.add(x);
                        else

                        break;
                    case "del":
                        linkedList.del(x);
                        break;
                    case "sch":
                        linkedList.srch(x);
                        break;
                }
            }
        }

        linkedList.printList(linkedList.head);
    }
}
