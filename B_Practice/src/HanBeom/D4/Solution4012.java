package D4;

import java.util.Scanner;

public class Solution4012 {
	static int N,count;
	static boolean[] check;
	static int[][] map;
	static int min;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for (int i = 1; i <=T; i++) {
			N=sc.nextInt();
			//2 2
			map=new int[N][N];
			check=new boolean[N];
			for (int j = 0; j < map.length; j++) {
				for (int j2 = 0; j2 < map.length; j2++) {
					map[j][j2]=sc.nextInt();
				}
			}
			min=Integer.MAX_VALUE;
			search(0,0);
			System.out.println("#"+i+" "+min);
		}
	}
	static void search(int index,int d) {
		if(d==N/2) {
			int A=0;
			int B=0;
			for (int j = 0; j < check.length-1; j++) {
				for (int j2 = j+1; j2 < check.length; j2++) {
					if(check[j]&&check[j2]) {
						A=A+map[j][j2]+map[j2][j];
					}else if(!check[j]&&!check[j2]) {
						B=B+map[j][j2]+map[j2][j];
					}
				}
			}		
			if(Math.abs(A-B)<min) {
				min=Math.abs(A-B);
			}
			return;
		}else if(index==N) {
			return;
		}
		check[index]=true;
		search(index+1,d);
		check[index]=false;
		search(index+1,d+1);
		
	}

}
