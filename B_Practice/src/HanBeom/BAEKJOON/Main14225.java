package BAEKJOON;

import java.util.Scanner;

public class Main14225 {
	static int[] arr;
	static boolean[] aa;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int min=Integer.MAX_VALUE;
		arr= new int[N];
		for (int i = 0; i <N; i++) {
			arr[i]=sc.nextInt();
			if(arr[i]<min) {
				min=arr[i];
			}
		}
		int tot=0;
		for (int i = 0; i < arr.length; i++) {
			tot=tot+arr[i];
		}
		aa=new boolean[tot+2];
		dfs(0,0);
		int res;
		int count=1;
		
		while(true) {
			
			if(aa[count]==false) {
				res=count;
				break;
			}
			count++;
		}
		System.out.println(res);
	}
	static void dfs(int d,int now) {
		if(d==arr.length) {
			aa[now]=true;
			return;
		}
		dfs(d+1,now);
		now=now+arr[d];
		dfs(d+1,now);
	}

}
/*
 * 
 * 
5
123 43 345 75 123

*/
