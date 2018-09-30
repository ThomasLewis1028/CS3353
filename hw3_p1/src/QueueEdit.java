public class QueueEdit {
    private Queue queue;

    //Create queue with size set prior
    QueueEdit(int size) {
        queue = new Queue(size);
    }

    void enQueue(int e) {
        //Check to make sure that the rear and front values are not the same to assure queue not full
        if ((queue.getFront() == 0 && queue.getRear() == queue.getSize() - 1) ||
                queue.getRear() == (queue.getFront() - 1) % (queue.getSize() - 1)) {
            System.out.println(e + " not added. Queue is full");
        } else if (queue.getFront() == -1) {
            //Check if queue is empty and add at rear
            queue.setFront(0);
            queue.setRear(0);
            queue.setArr(queue.getRear(), e);
            System.out.println(e + " added to the queue");
        } else if (queue.getRear() == queue.getSize() - 1 && queue.getFront() != 0) {
            //Check if only one spot open
            queue.setRear(0);
            queue.setArr(queue.getRear(), e);
            System.out.println(e + " added to the queue");
        } else { //Add wherever next available
            queue.setRear(queue.getRear() + 1);
            queue.setArr(queue.getRear(), e);
            System.out.println(e + " added to the queue");
        }
    }

    void deQueue() {
        //CHeck if queue is empty
        if (queue.getFront() == -1)
            System.out.println("Queue is empty");
        else {
            int temp = queue.getArr(queue.getFront());
            queue.setArr(queue.getFront(), -1);

            //Check if obly one element existed and set front and rear back to -1
            if (queue.getFront() == queue.getRear()) {
                queue.setFront(-1);
                queue.setRear(-1);
            } else if (queue.getFront() == queue.getSize() - 1)
                queue.setFront(0); //Check if queue was full and set front to index 0
            else
                queue.setFront(queue.getFront() + 1); //Set front to previous index + 1

            System.out.println(temp + " removed from the queue");
        }
    }

    void dispQueue() {
        //Iterate through and print values
        System.out.println("Queue values: ");
        if (queue.getFront() == -1)
            System.out.println("Queue is empty");
        else if (queue.getRear() >= queue.getFront())
            for (int i = queue.getFront(); i <= queue.getRear(); i++)
                System.out.print(queue.getArr(i) + " ");
        else {
            for (int i = queue.getFront(); i < queue.getSize(); i++)
                System.out.print(queue.getArr(i) + " ");
            for (int i = 0; i <= queue.getRear(); i++)
                System.out.print(queue.getArr(i) + " ");
        }
        System.out.println();
    }
}