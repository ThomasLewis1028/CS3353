import java.util.Scanner;

public class NodeMain {
    public static void main(String[] args) {
        //Set up the pattern to sanitize inputs, also set up scanner and the linkedList
        String pattern = "^-?\\d+\\.(in_\\d+|del|sch|in)$";
        Scanner scanner = new Scanner(System.in);
        NodeEdit linkedList = new NodeEdit();

        while (true) {
            //Ask and receive input
            System.out.print("Node command: ");
            String input = scanner.next();

            //Check to exit
            if (input.matches("exit"))
                break;
            //Check to print
            else if (input.matches("print"))
                linkedList.printList(linkedList.head);
            //Check input against pattern
            else if (input.matches(pattern)) {
                //Split string on . and _
                String[] arr = input.split("[._]");
                //Grab the number to insert from the array
                int x = Integer.parseInt(arr[0]);

                //Switch on the second item and perform action on that
                switch (arr[1]) {
                    case "in":
                        //Check to insert at head or on element
                        if (arr.length == 2)
                            linkedList.in(x);
                        else
                            linkedList.in(x, Integer.parseInt(arr[2]));
                        break;
                    case "del":
                        linkedList.del(x);
                        break;
                    case "sch":
                        linkedList.sch(x);
                        break;
                    default:
                        break;
                }
            } else
                System.out.println("Not a recognized command");
        }

        //Print list
        linkedList.printList(linkedList.head);
    }
}