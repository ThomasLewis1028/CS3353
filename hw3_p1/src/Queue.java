class Queue {
    //Basic queue class with getters and setters
    private int size, front, rear;
    private int[] arr;

    Queue(int size) {
        this.size = size;
        this.arr = new int[size];
        this.front = this.rear = -1;
    }

    int getArr(int i) {
        return arr[i];
    }

    void setArr(int i, int x) {
        this.arr[i] = x;
    }

    int getSize() {
        return size;
    }

    int getFront() {
        return front;
    }

    void setFront(int front) {
        this.front = front;
    }

    int getRear() {
        return rear;
    }

    void setRear(int rear) {
        this.rear = rear;
    }
}