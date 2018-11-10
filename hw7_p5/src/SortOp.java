class SortOp {
	SortOp next;
	SortOp previous;
	double data;

	SortOp(Double x) {
		data = x;
		next = null;
	}

	public SortOp getNext() {
		return next;
	}

	public void setNext(SortOp next) {
		this.next = next;
		if(this.next != null)
			this.next.setPrevious(this);
	}

	public SortOp getPrevious() {
		return previous;
	}

	public void setPrevious(SortOp previous) {
		this.previous = previous;
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

		if (bucket[(int)index] == null) {
			bucket[(int)index] = nxtPtr;
		} else {
			nxtPtr.setNext(bucket[(int)index]);
			bucket[(int)index] = nxtPtr;
		}

		insertionSort(bucket[(int)index], (int)index);
	}

	private double key(double num) {
		return Math.floor(num*bucket.length);
	}

	void insertionSort(SortOp b, int index){
		SortOp temp = b.getNext();

		while(temp != null){
			SortOp temp2 = temp;
			while(temp2 != null && temp2.getPrevious().data > temp2.data) {
				SortOp temp3 = temp2.getPrevious();
				if(temp3.getPrevious() != null)
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
				System.out.print(start.data + " ");
				start = start.next;
			}
			System.out.println();
		}
	}

	void printRange(String arr[], double range) {
		int n = arr.length;

		for (int i = 0; i < bucket.length; i++) {
			SortOp start = bucket[i];
			while (start != null) {
				if(start.data >= range) {
					System.out.print(start.data + " ");
					start = start.next;
				}
				else {
					start = start.next;
				}
			}
		}
	}
}

