package BAEKJOON;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main1697_3 {
	
	static int n;
	static int k;
	static int[] min;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = in.readLine().split(" ");
		n = Integer.parseInt(temp[0]);
		k = Integer.parseInt(temp[1]);
		min = new int[100001];
		min[n] = 0;
		for(int i=n-1; i>=0;i--){
			min[i] = min[i+1] +1;
		}
		for (int i = 0; i < n; i++) {
			
			System.out.println(min[i]);
		}
		
		for(int i=n+1; i<100001;i++){
			if(min[k] != 0)
				break;
			else{
				if(i % 2 == 0){
					min[i] = min[i-1]+1 <= min[i/2]+1 ? min[i-1]+1 : min[i/2]+1;
				}else{
					min[i] = min[i-1]+1 <= min[(i+1)/2]+2 ? min[i-1]+1:min[(i+1)/2]+2;
				}
			}
		}
		System.out.println(min[k]);
		
		
	}


}
