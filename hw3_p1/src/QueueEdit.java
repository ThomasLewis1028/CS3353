public class QueueEdit {
    private Queue queue;

    QueueEdit(int size){
        queue = new Queue(size);
    }

    void enQueue(int e) {
        if ((queue.getFront() == 0 && queue.getRear() == queue.getSize() - 1) ||
                queue.getRear() == (queue.getFront() - 1) % (queue.getSize() - 1)) {
            System.out.println(e + " not added. Queue is full");
        } else if (queue.getFront() == -1) {
            queue.setFront(0);
            queue.setRear(0);
            queue.setArr(queue.getRear(), e);
            System.out.println(e + " added to the queue");
        } else if (queue.getRear() == queue.getSize()-1 && queue.getFront() != 0){
            queue.setRear(0);
            queue.setArr(queue.getRear(), e);
            System.out.println(e + " added to the queue");
        } else{
            queue.setRear(queue.getRear()+1);
            queue.setArr(queue.getRear(), e);
            System.out.println(e + " added to the queue");
        }
    }

    void deQueue(){
        if(queue.getFront() == -1)
            System.out.println("Queue is empty");
        else{
            int temp = queue.getArr(queue.getFront());
            queue.setArr(queue.getFront(), -1);

            if (queue.getFront() == queue.getRear()){
                queue.setFront(-1);
                queue.setRear(-1);
            }else if (queue.getFront() == queue.getSize()-1)
                queue.setFront(0);
            else
                queue.setFront(queue.getFront()+1);

            System.out.println(temp + " removed from the queue");
        }
    }

    void dispQueue(){
        System.out.println("Queue values: ");
        if(queue.getFront() == -1)
            System.out.println("Queue is empty");
        else if(queue.getRear() >= queue.getFront())
            for (int i = queue.getFront(); i <= queue.getRear(); i++)
                System.out.print(queue.getArr(i) + " ");
        else{
            for(int i = queue.getFront(); i < queue.getSize(); i++)
                System.out.print(queue.getArr(i) + " ");
            for(int i = 0; i <= queue.getRear(); i++)
                System.out.print(queue.getArr(i) + " ");
        }
        System.out.println();
    }
}