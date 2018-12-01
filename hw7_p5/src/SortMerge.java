class SortMerge {
	void merge(String arr[], int l, int m, int r) {
		int num1 = m - l + 1;
		int num2 = r - m;

		double Left[] = new double[num1];
		double Right[] = new double[num2];

		for (int i = 0; i < num1; i++)
			Left[i] = Double.parseDouble(arr[l + i+1]);

		for (int j = 0; j < num2; j++)
			Right[j] = Double.parseDouble(arr[m + 1 + j+1]);

		int i;
		int j = i = 0;

		int k = l;
		while (i < num1 && j < num2) {
			if (Left[i] <= Right[j]) {
				arr[k] = "" + (Left[i]);
				i++;
			} else {
				arr[k] = "" + Right[j];
				j++;
			}
			k++;
		}

		while (i < num1) {
			arr[k] = "" + Left[i];
			i++;
			k++;
		}


		while (j < num2) {
			arr[k] = "" + Right[j];
			j++;
			k++;
		}
	}

	void sort(String arr[], int l, int r) {
		if (l < r) {
			int m = (l + r) / 2;

			sort(arr, l, m);
			sort(arr, m + 1, r);

			merge(arr, l, m, r);
		}
	}

	void printArr(String arr[]) {
		int n = arr.length;

		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");

		System.out.println("\n");
	}

	void printRange(String arr[], double range) {
		int n = arr.length;

		for (int i = 0; i < n; i++)
			if (Double.parseDouble(arr[i]) >= range)
				System.out.print(arr[i] + " ");
	}
}