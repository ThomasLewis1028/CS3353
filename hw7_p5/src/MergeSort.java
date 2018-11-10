class MergeSort {

	// Merges two subarrays of arr[].
	// First subarray is arr[l..m]
	// Second subarray is arr[m+1..r]
	void merge(String arr[], int l, int m, int r) {
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		double L[] = new double[n1];
		double R[] = new double[n2];

		/*Copy data to temp arrays*/
		for (int i = 0; i < n1; ++i)
			L[i] = Double.parseDouble(arr[l + i]);
		for (int j = 0; j < n2; ++j)
			R[j] = Double.parseDouble(arr[m + 1 + j]);


		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = "" + (L[i]);
				i++;
			} else {
				arr[k] = "" + R[j];
				j++;
			}
			k++;
		}

		// Copies the rest of the elements on the left to main array.
		while (i < n1) {
			arr[k] = "" + L[i];
			i++;
			k++;
		}

		// Copies the rest of the elements on the right to the main array.
		while (j < n2) {
			arr[k] = "" + R[j];
			j++;
			k++;
		}
	}

	// Function that calls merge to break down the input array.
	void sort(String arr[], int l, int r) {
		if (l < r) {
			// Find the middle point
			int m = (l + r) / 2;

			// Sort first and second halves
			sort(arr, l, m);
			sort(arr, m + 1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
	}

	/* A utility function to print array of size n */
	void printArray(String arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
		System.out.println();
	}

	void printRange(String arr[], double range) {
		int n = arr.length;

		for(int i = 0; i < n; i++) {
			if(Double.parseDouble(arr[i]) >= range) {
				System.out.print(arr[i] + " ");
			}
		}
	}
}