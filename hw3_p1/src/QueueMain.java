import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class QueueMain {
    int maxSize = 10;
    int rear;
    int front;
    int tempQueue[];
    {
        rear = -1;
        front = -1;
    }

    QueueMain(int maxSize)
    {
        this.maxSize = maxSize;
        this.tempQueue = new int[maxSize];
    }

    void enQueue(int item)
    {
        if(((rear+1) % maxSize) == front)
        {
            System.out.println("Queue is Full");
        }
        else
        {
            if (rear == front && front == -1)
            {
                front += 1;
            }
            rear = (rear+1) % maxSize;
            tempQueue[rear] = item;
        }
    }

    void deQueue()
    {
        if(rear == front && rear == -1)
        {
            System.out.println("Queue is Empty.");
        }
        else
        {
            int item = tempQueue[front];
            if(rear == front)
            {
                rear = -1;
                front = -1;
            }
            else
            {
                front = (front + 1) % maxSize;
            }
            System.out.println(item + " is deQueued from the Queue");
        }
    }

    String elementOrElements()
    {
        String send = (rear == front)? (" ") :("s ");
        return send;
    }

    void display()
    {
        int tmpfront = front;
        if(rear == front && rear == -1)
        {
            System.out.println("Queue is Empty.");
        }
        else
        {
            System.out.println("The element"+ elementOrElements() + "on the Queue are:- ");
            for(int i=0; i<maxSize ; i++)
            {
                if(tmpfront != rear)
                {
                    System.out.println(tempQueue[tmpfront]);
                    tmpfront = (tmpfront + 1) % maxSize;
                }
                else
                {
                    System.out.println(tempQueue[rear]);
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        int maxSize = 10;
        QueueMain queue = new QueueMain(maxSize);

        System.out.println("Enter your input file name");
        Scanner scan = new Scanner(System.in);
        String filename = scan.nextLine(); // Receiving input from user
        File file = new File(filename);
        String line = null;
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);

        Scanner temp = null;
        try
        {
            temp = new Scanner(file);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        System.out.println();

        while((line = br.readLine())!= null)
        {
            System.out.println(line);
            String a[] = line.split(" ");
            for(int i=0;i<a.length;i++)
            {
                if(a[i].indexOf('.') == 1)
                {
                    String op[] = a[i].split("\\.");

                    if(op[1].equals("in"))
                    {
                        queue.enQueue(Integer.parseInt(op[0]));
                    }
                }
                if(a[i].equals("del"))
                {
                    queue.deQueue();
                }
            }
            queue.display();
        }
    }
}