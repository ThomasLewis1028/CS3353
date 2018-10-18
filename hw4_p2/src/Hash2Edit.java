class Hash2Edit {
	private HashNode[] hTable;
	private int val;

	/* Constructor */
	public Hash2Edit(int tableSize) {
		hTable = new HashNode[tableSize];
	}

	public int getVal() {
		return val;
	}

	public void setVal(int num) {
		this.val = num;
	}

	public void insert(int numData) {
		int loc = hashNum(numData);
		HashNode nxtPtr = new HashNode(numData);

		if (!search(numData)) {
			if (hTable[loc] == null) {
				hTable[loc] = nxtPtr;
			} else {
				nxtPtr.next = hTable[loc];
				hTable[loc] = nxtPtr;
			}
		}

	}

	//Delete
	public void delete(int numData) {
		int loc = hashNum(numData);
		HashNode head = hTable[loc];
		HashNode end = null;


		if (search(numData)) {
			if (head != null && head.data == numData) {
				hTable[loc] = head.next;
				return;
			}

			while (head != null && head.data != numData) {
				end = head;
				head = head.next;
			}

			if (head == null) {
				return;
			}
			end.next = head.next;
		}
	}

	//Search
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
		int probe = getVal() - x % getVal();

		if (hashVal < 0) {
			hashVal += hTable.length;
		}

		HashNode temp = hTable[hashVal];
		while (hTable[hashVal] != null) {
			if (temp.data == x) {
				return hashVal;
			}

			hashVal = (hashVal + probe) % hTable.length;
		}
		return hashVal;
	}

	/* Function that traverses through the hashTable and printing
	 * the values found and traverses through the linked list */
	public void printHashTable() {
		for (int i = 0; i < hTable.length; i++) {
			System.out.print(i + ":  ");
			HashNode start = hTable[i];
			while (start != null) {
				System.out.print(start.data + " ");
				start = start.next;
			}
			System.out.println();
		}
	}
}
