package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class Main1932 {
	//같은 지점이면 큰값이 와야한다.
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] tri=new int[n+1];
		tri[1]=sc.nextInt();
		//1 2 4 7 11
		//7
		//10 15
		//8  1  0
		//18 16  15
		//2  7   4   4
		//20 25
		int max=0;
		for (int i = 2; i <= n; i++) {
			int[] tmp=new int[i+1];
			int[] tmp2=new int[i];
			
			for (int j = 1; j <=i; j++) {
				tmp[j]=sc.nextInt();
			}
			for (int j = 1; j <=i; j++) {
				tmp2[j]=tri[j];
			}
			
			//System.out.println(Arrays.toString(tmp)+"aa");
			tri[i]=tmp2[i-1]+tmp[i];
			tri[1]=tmp2[1]+tmp[1];
			
			for (int j = 1; j <i-1; j++) {
				if(tmp2[j]>tmp2[j]) {
					tri[j+1]=tmp2[j]+tmp[j+1];
				}else {
					tri[j+1]=tmp2[j+1]+tmp[j+1];
				}

			}
			//System.out.println(Arrays.toString(tri));
		}
		System.out.println(Arrays.toString(tri));
		
	}

}
/*
4
7
3 8
8 1 0
2 7 4 4

*/