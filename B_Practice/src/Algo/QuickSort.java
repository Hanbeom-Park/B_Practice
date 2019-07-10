public class Sort_Quick {
	void quickSort(int[] arr, int start, int end) {
		int left = start;
		int right = end;
		int pivot = arr[(start + end) / 2];

		do {
			while (arr[left] < pivot)
				left++;
			while (arr[right] > pivot)
				right--;
			if (left <= right) {
				int temp = arr[right];
				arr[right] = arr[left];
				arr[left] = temp;
				left++;
				right--;
			}

		} while (left <= right);
		if (left < end) {
			quickSort(arr, left, end);
		}
		if (right > start) {
			quickSort(arr, start, right);
		}
	}

	public static void main(String[] args) {
		int arr[] = { 1, 1, 7, 8, 9, 1, 5 };
		int n = arr.length;
		Sort_Quick ob = new Sort_Quick();
		ob.quickSort(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}
}
