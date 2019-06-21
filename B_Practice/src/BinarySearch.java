

public class BinarySearch {

	public static void main(String[] args) {
		int data[]= {1,2,3,6,8,12,13,15,17,28};
		
		binarySearch(data,8);
	
	
	
	}
	public static boolean binarySearch(int a[],int key) {
		int start=0;
		int end=a.length-1;
		int middle;
		while(start<=end) {
			middle=(start+end)/2;
			if(a[middle]==key) {
				System.out.println(middle+"번 인덱스 "+key+"찾음");
				return true;
			}
			else if(a[middle]==key) {
				end=middle-1;
			}
			else {
				start=middle+1;
				
			}
		}
		System.out.println("존재하지 않음");
		
		return false;
	}

}
