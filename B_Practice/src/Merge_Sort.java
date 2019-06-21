


import java.util.Arrays;

public class Merge_Sort {
	
	public static void main(String[] args) {
		int[] arr= {1,34,54,13,24,125,58,34,3,43,1,675,8,751,3,32,4,56};
		sort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	static void sort(int[] arr,int left,int right) {
		if(left<right) {
			int middle=(left+right)/2;
			sort(arr,left,middle);
			sort(arr,middle+1,right);
			
			merge(arr,left,middle,right);
		}
	}
	static void merge(int[] arr,int left,int middle,int right) {
		int leftSize=middle-left+1;//병합할 왼쪽 부분집합의 크기 계산
		int rightSize=right-middle;//병합할 오른쪽 부분집합의 크기 계산
		
		int[] leftArr=new int[leftSize];
		int[] rightArr=new int[rightSize];
		//int[] temp=new int[leftSize+rightSize];
		//원본 arr에서 두 부분집합 각각 복사해보기
		for (int i = 0; i < leftSize; i++) {
			leftArr[i]=arr[left+i];
		}
		for (int i = 0; i < rightSize; i++) {
			rightArr[i]=arr[middle+i+1];
		}
		int left_i=0,right_i=0;
		int arr_i=left;
		
		while(left_i<leftSize&&right_i<rightSize) {//두 집합 모두에 원소가 남아있다면
			if(leftArr[left_i]<rightArr[right_i]) {//왼쪽 배열에 있는게 더 작으면 왼쪽꺼 쓰고
				arr[arr_i]=leftArr[left_i];
				left_i++;
			}else {
				arr[arr_i]=rightArr[right_i];//아니면 오른쪽꺼
				right_i++;
			}
			arr_i++;
		}
		while(left_i<leftSize) {//왼쪽 부분집합에 숫자가 남아있다면 정렬된 더 
			arr[arr_i]=leftArr[left_i];
			arr_i++;
			left_i++;
		}
		while(right_i<rightSize) {
			arr[arr_i]=rightArr[right_i];
			arr_i++;
			right_i++;
		}
	}
}
