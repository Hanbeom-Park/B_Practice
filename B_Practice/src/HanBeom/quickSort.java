

public class quickSort {
	static int[] arr= {69,10,30,2,16,8,31,22};
	
	public static int partition(int[] a, int left, int right) {
		int pivot=a[(left+right)/2];
		while(left<right) {
			while((a[left]<pivot)&&(left<right)) {
				left++;
			}while((a[right]>pivot)&&(left<right)) {
				right--;
			}
			//각각의 값을 교차하지 않은 상태에서 찾은경우 swap
			//못찾아서 left가 right봗 커져버렸으면 left는 새로운 피봇으로 삼고 분할작업 일어남.
			if(left<right) {
				int tmp = a[left];
				a[left]=a[right];
				a[right]=tmp;
			}
		}
		
		return left;
	}
	public static void sort(int[] a, int left, int right) {
		if(left<right) {
			int pivotNewIndex=partition(a,left,right);
			
			sort(a,left,pivotNewIndex-1);
			sort(a,pivotNewIndex+1,right);
		}
		return;
	}
	public static void main(String[] args) {
		sort(arr,0,arr.length-1);
		for(int i:arr) {
			System.out.print(i+" ");
		}
		
	}
}
