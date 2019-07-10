void quickSort(int* arr, int start, int end) {
   int left = start;
   int right = end;
   int pivot = arr[(start + end) / 2];

   do {
      while (arr[left] < pivot) left++;
      while (arr[right] > pivot) right--;
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
