package D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution6782 {
	static int min=9999;
	public static void main(String[] args) throws Throwable, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		for (int i = 1; i <=T; i++) {
			int N=Integer.parseInt(br.readLine().trim());
			int count=0;
			sqrt(N,0);
			System.out.println("#"+i+" "+min);
			min=9999;
		}
		
	}
	static void sqrt(int n,int count) {
		if(n==2) {
			if(min>count) {
				min=count;
			}
			return;
		}else if(n<2){
			return;
		}
		
		if((int)Math.sqrt(n)==Math.sqrt(n)){
			sqrt((int)(Math.sqrt(n)),count+1);
		}else {
			sqrt(n+1,count+1);
		}
	}

}
/*
4
2
3
4
99

*/