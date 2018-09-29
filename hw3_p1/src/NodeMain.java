import java.util.Scanner;

public class NodeMain {
    public static void main(String[] args)
    {
        String pattern = "^\\d+\\.(in_\\d+|del|sch|in)$";
        Scanner scanner = new Scanner(System.in);
        NodeEdit linkedList = new NodeEdit();

        while(true){
            System.out.print("Node command: ");
            String input = scanner.next();

            if(input.matches("exit/i"))
                break;
            else if (input.matches(pattern)){
                String[] arr = input.split("\\.|_");
                int x = Integer.parseInt(arr[0]);

                switch (arr[1]){
                    case "in":
                        if(arr[2] == null)
                            linkedList.in(x);
                        else

                        break;
                    case "del":
                        linkedList.del(x);
                        break;
                    case "sch":
                        linkedList.sch(x);
                        break;
                }
            }
        }

        linkedList.printList(linkedList.head);
    }
}
