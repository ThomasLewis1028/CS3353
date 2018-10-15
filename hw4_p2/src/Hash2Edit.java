class Hash2Edit {
    private HashNode[] hTable;
    private int qVal;

    /* Constructor */
    public Hash2Edit(int tableSize) {
        hTable = new HashNode[tableSize];
    }

    /* Function that retrieves the qVal to be used for calculations */
    public int getQVal() {
        return qVal;
    }

    /* Function that sets the qVal from the input data */
    public void setQVal(int num) {
        this.qVal = num;
    }

    /* Function to insert an element into the hashTable*/
    public void insert(int numData) {
        int loc = hashNum(numData);
        HashNode nxtPtr = new HashNode(numData);

        if(!search(numData)) {
            if (hTable[loc] == null) {
                hTable[loc] = nxtPtr;
            }
            else
            {
                nxtPtr.next = hTable[loc];
                hTable[loc] = nxtPtr;
            }
        }

    }

    /* Function to remove an element
     *  that calls out search to first check if element
     *  is even in the hashTable
     *  and if so it removes it
     *  if its not then it prints out element not found */
    public void remove(int numData) {
        int loc = hashNum(numData);
        HashNode start = hTable[loc];
        HashNode end = null;


        if(search(numData)) {
            // If head node itself holds the key to be deleted
            if (start != null && start.data == numData) {
                hTable[loc] = start.next;
                return;
            }

            while (start != null && start.data != numData) {
                end = start;
                start = start.next;
            }

            if(start == null) {
                return;
            }
            end.next = start.next;
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
        return false;                       //data not found
    }

    /* Function hashNum that outputs the hashKey generated of the num input
     * by the formula h(k) = i + jd(k) mod N and d(k) = q – k mod q, then pick q the largest prime less than N. */
    private int hashNum(Integer x) {
        int hashVal = x.hashCode();
        hashVal %= hTable.length;
        int probe = getQVal() - x% getQVal();

        if (hashVal < 0) {
            hashVal += hTable.length;
        }

        HashNode temp = hTable[hashVal];
        while(hTable[hashVal] != null)
        {
            if(temp.data == x)
            {
                return hashVal;
            }

            hashVal = (hashVal+probe)%hTable.length;
        }
        return hashVal;
    }

    /* Function that traverses through the hashTable and printing
     * the values found and traverses through the linked list */
    public void printHashTable() {
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
