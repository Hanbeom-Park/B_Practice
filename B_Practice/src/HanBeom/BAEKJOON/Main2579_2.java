package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class Main2579_2 {
	//1or 2계단
	//연속 3계단은 불가
	//도착계단을 밟아야함
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[] stair=new int[N+1];
		for (int i = 1; i <=N; i++) {
			stair[i]=sc.nextInt();
		}
		int[] max=new int[N+1];
		max[1]=stair[1];
		if(N>1) {
		max[2]=stair[1]+stair[2];
		}
		//10 20 15 25 10 20
		//10 30 
		if(N>2) {
		for (int i = 3; i < stair.length; i++) {
			int A=max[i-1];//
			int B=max[i-3]+stair[i-1]+stair[i];//현재꺼 선택했는데 저번꺼도 선택된 경우
			int C=stair[i]+max[i-2];
			max[i]=Math.max(C, Math.max(A, B));
		}
		}
		System.out.println(max[N]);
		System.out.println(Arrays.toString(stair));
		System.out.println(Arrays.toString(max));
	}

}
/*
6
10
20
15
25
10
20

6
30 20 15 25 10 20

6
10 20 25 25 90 20

1
10

*/