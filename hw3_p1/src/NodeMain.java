import java.util.Scanner;

public class NodeMain {
    public static void main(String[] args) {
        String pattern = "^-?\\d+\\.(in_\\d+|del|sch|in)$";
        Scanner scanner = new Scanner(System.in);
        NodeEdit linkedList = new NodeEdit();

        while (true) {
            System.out.print("Node command: ");
            String input = scanner.next();

            if (input.matches("exit"))
                break;
            else if (input.matches("print"))
                linkedList.printList(linkedList.head);
            else if (input.matches(pattern)) {
                String[] arr = input.split("[._]");
                int x = Integer.parseInt(arr[0]);

                switch (arr[1]) {
                    case "in":
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

        linkedList.printList(linkedList.head);
    }
}