package D4;

import java.util.Scanner;

public class Solution1238 {
	static boolean[][] map;
	static boolean[] check;
	static int N;
	static int max_count;
	static int max;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for (int i = 1; i <=1; i++) {
			N=sc.nextInt();
			int start=sc.nextInt();
			map=new boolean[101][101];
			check=new boolean[101];
			for (int j = 0; j < N/2; j++) {
				int x=sc.nextInt();
				int y=sc.nextInt();
				map[x][y]=true;
			}
			
			max_count=0;
			max=0;
			call(start,1);
			System.out.println("#"+i+" "+max);
		}
	}
	static void call(int v,int count) {
		if(count>max_count) {
			max_count=count;
			max=v;
		}else if(count==max_count&&max<v) {
				max=v;
		}
		check[v]=true;
		for (int i = 1; i <=100; i++) {
			if(map[v][i]==true&&check[i]==false) {
				map[v][i]=false;
				System.out.println(v+" "+i+" "+(count+1));
				call(i,count+1);
			}
		}
	}

}
/*
*/
