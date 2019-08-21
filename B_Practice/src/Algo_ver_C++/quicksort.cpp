#include <iostream>
void quicksort(int* arr, int start, int end);
int main() {
	int N, M;
	int arr[] = { 1, 1, 7, 8, 9, 1, 5 };
	quicksort(arr, 0, 6);
	for (int i = 0; i <=6; i++) {
		printf("%d\n", arr[i]);
	}

	//delete[] arr;
}
void quicksort(int *arr,int start,int end) {
	int pivot= (start + end) / 2;
	int left = start;
	int right = end;
	do {
		while (arr[pivot]>arr[left]) {
			left++;
		}
		while (arr[pivot] <arr[right]) {
			right--;
		}
		if (left <= right) {
			int tmp = arr[left];
			arr[left] = arr[right];
			arr[right] = tmp;
			left++;
			right--;
		}
	} while (left <= right);
	if (start < right) {
		quicksort(arr,start,right);
	}
	if (left < end) {
		quicksort(arr, left, end);
	}
}
