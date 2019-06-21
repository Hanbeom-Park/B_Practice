

import java.util.Arrays;

public class Counting_Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []data=new int[] {0,4,1,3,1,2,4,1};
		int max=0;
		for (int i = 0; i < data.length; i++) {
			if(max<data[i]) {
				max=data[i];
			}
		}//4
		int []counts=new int[max+1];
		for (int i = 0; i < data.length; i++) {
			counts[data[i]]++;
		}
		for (int i = 1; i < counts.length; i++) {
			counts[i]=counts[i]+counts[i-1];
		}
		int []temp=new int[data.length];
		for (int i = data.length-1; i >= 0; i--) {
			temp[counts[data[i]]-1]=data[i];
			counts[data[i]]--;
		}
		
		System.out.println(Arrays.toString(temp));
	}

}
