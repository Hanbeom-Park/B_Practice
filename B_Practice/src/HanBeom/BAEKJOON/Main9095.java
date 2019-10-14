package BAEKJOON;

import java.util.Scanner;

public class Main9095 {

	public static void main(String[] args) {
		int[] dp=new int[12];
		int[] num= {1,2,3};
		dp[1]=1;
		dp[2]=2;
		dp[3]=4;
		//이전 과정에서  현재 과정=이전과정+전전과정+전전전과정
		//1 2     3            4
		//1 11,2  111,21/12,3  
		for (int i = 4; i < dp.length; i++) {
			dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
		}
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for (int i = 1; i <=T; i++) {
			System.out.println(dp[sc.nextInt()]);
		}
	}

}
