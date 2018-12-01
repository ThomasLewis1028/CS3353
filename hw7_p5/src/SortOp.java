class SortOp {
	private SortOp next;
	private SortOp previous;
	private double data;

	SortOp(Double x) {
		data = x;
		next = null;
	}

	SortOp getNext() {
		return next;
	}

	void setNext(SortOp next) {
		this.next = next;
		if (this.next != null)
			this.next.setPrevious(this);
	}

	SortOp getPrevious() {
		return previous;
	}

	void setPrevious(SortOp previous) {
		this.previous = previous;
	}

	double getData() {
		return data;
	}
}

class Table {
	private SortOp[] bucket;

	Table(int tableSize) {
		bucket = new SortOp[tableSize];
	}

	void insert(Double numData) {
		double index = key(numData);
		SortOp nxtPtr = new SortOp(numData);

		if (bucket[(int) index] == null) {
			bucket[(int) index] = nxtPtr;
		} else {
			nxtPtr.setNext(bucket[(int) index]);
			bucket[(int) index] = nxtPtr;
		}

		insertionSort(bucket[(int) index], (int) index);
	}

	private double key(double num) {
		return Math.floor(num * bucket.length);
	}

	private void insertionSort(SortOp b, int index) {
		SortOp temp = b.getNext();

		while (temp != null) {
			SortOp temp2 = temp;
			while (temp2 != null && temp2.getPrevious().getData() > temp2.getData()) {
				SortOp temp3 = temp2.getPrevious();
				if (temp3.getPrevious() != null)
					temp3.getPrevious().setNext(temp2);
				else
					temp2.setPrevious(null);
				temp3.setNext(temp2.getNext());
				temp2.setNext(temp3);

				temp2 = temp2.getPrevious();
				bucket[index] = temp;
			}
			temp = temp.getNext();
		}
	}

	void printTable() {
		for (int i = 0; i < bucket.length; i++) {
			System.out.print(i + ":  ");
			SortOp start = bucket[i];
			while (start != null) {
				System.out.print(start.getData() + " ");
				start = start.getNext();
			}
			System.out.println();
		}
	}

	void printRange(String arr[], double range) {
		int n = arr.length;

		for (int i = 0; i < bucket.length; i++) {
			SortOp start = bucket[i];
			while (start != null) {
				if (start.getData() >= range) {
					System.out.print(start.getData() + " ");
					start = start.getNext();
				} else {
					start = start.getNext();
				}
			}
		}
	}
}

