package D4;

import java.util.Scanner;

public class Solution1486 {
	static int[] emp;
	static int N,B;
	static int bestfit;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for (int i = 1; i <=T; i++) {
			N=sc.nextInt();
			B=sc.nextInt();
			emp=new int[N];
			for (int j = 0; j < emp.length; j++) {
				emp[j]=sc.nextInt();
			}
			bestfit=-1;
			dfs(0,0);
			System.out.println("#"+i+" "+(bestfit-B));
		}
	}
	static void dfs(int d,int h) {
		if(d==N) {
			if(h>=B) {
				if(Math.abs(bestfit-B)>Math.abs(h-B)) {
					bestfit=h;
				}
			}
			return; 
		}
		if(h>B&&Math.abs(bestfit-B)<Math.abs(h-B)) {
			return;
		}
		dfs(d+1,h+emp[d]);
		dfs(d+1,h);
		
		
	}

}
