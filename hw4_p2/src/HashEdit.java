class HashEdit {
    private HashNode[] hTable;
    private int size ;
    private int primeSize;

    /* Constructor */
    public HashEdit(int tableSize) {
        hTable = new HashNode[tableSize];
        size = 0;
        primeSize = getPrime();
    }

    /* Function to get size */
    public int getSize() {
        return size;
    }

    public int getPrime() {
        for (int i = hTable.length - 1; i >= 1; i++) {
            int temp = 0;
            for (int j = 2; j <= (int) Math.sqrt(i); j++) {
                if (i % j == 0) {
                    temp++;
                }
                if (temp == 0) {
                    return i;
                }
            }
        }
        return 3;
    }

    /* Function to insert an element */
    public void insert(int numData) {
        size++;
        int loc = hashNum(numData);
        HashNode nxtPtr = new HashNode(numData);
        if (hTable[loc] == null)
            hTable[loc] = nxtPtr;
        else
        {
            nxtPtr.next = hTable[loc];
            hTable[loc] = nxtPtr;
        }
    }
    /* Function to remove an element */
    public void remove(int numData) {
        int loc = hashNum(numData);
        HashNode start = hTable[loc];
        HashNode end = start;
        //System.out.println(size);


        if(search(numData)) {
            if (start.data == numData) {
                size--;
                hTable[loc] = start.next;
                return;
            }

            while (end.next != null && end.next.data != numData) {
                end = end.next;
                if (end.next == null) {
                    //System.out.println("\n" + numData + "not found\n");
                    return;
                }
                size--;
                if (end.next.next == null) {
                    end.next = null;
                    return;
                }
                end.next = end.next.next;
                hTable[loc] = start;
            }
        }
    }

    /* Function search that returns true if element was found. */
    public boolean search(int numData) {
        int loc = hashNum(numData);
        HashNode temp = hTable[loc];
        while (temp != null) {
            if (temp.data == numData) {
                return true;                //data found
            }
            temp = temp.next;
        }
        return false;    //data not found

    }

    /* Function hashNum that outputs the hash of the num input */
    private int hashNum(Integer x) {
        int hashVal = x.hashCode();
        hashVal %= hTable.length;
        if (hashVal < 0)
            hashVal += hTable.length;
        return hashVal;
    }

    private int hashNum2(Integer x) {
        int hashVal = x.hashCode();
        hashVal %= hTable.length;
        if(hashVal < 0)
        {
            hashVal += hTable.length;
        }
        return primeSize - x%primeSize;
    }

    public void printHashTable() {
        //System.out.println();

        for (int i = 0; i < hTable.length; i++) {
            System.out.print (i + ":  ");
            HashNode start = hTable[i];
            while(start != null) {
                System.out.print(start.data +" ");
                start = start.next;
            }
            System.out.println();
        }
    }
}