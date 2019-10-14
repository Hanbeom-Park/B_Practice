package BAEKJOON;

import java.util.Scanner;

public class Main1182 {
	static int[] map;
	static int S;
	static int count;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//합쳐서 S가 되는 경우 구하기
		int N=sc.nextInt();
		S=sc.nextInt();
		map=new int[N];
		count=0;
		for (int i = 0; i < map.length; i++) {
			map[i]=sc.nextInt();
		}
		dfs(0,0);
		if(S==0) {
			count--;
		}
		System.out.println(count-1);
	}
	static void dfs(int d,int sum) {
		if(d==map.length) {
			if(sum==S) {
				count++;
			}
			return;
		}
		dfs(d+1,sum+map[d]);
		dfs(d+1,sum);
	}
}
