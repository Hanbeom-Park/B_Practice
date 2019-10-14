package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class Main2579 {
	//1or 2계단
	//연속 3계단은 불가
	//도착계단을 밟아야함
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[] stair= {1,2};
		int[] p=new int[N+1];
		int[][] max=new int[N+1][2];
		for (int i = 1; i < N+1; i++) {
			p[i]=sc.nextInt();
		}
		//2개 올라가면 카운트 리셋
		/*
		0 10 20 25 25 5  20
		  10 30    55 60 80
		  10    35 60    90
		     20 45    50 70
		     
		0 30 20 15 25 10 20 =>95
		
		 */
		max[1][0]=p[1];
		max[1][1]=0;//2면 1 사용 불가
		for (int i = 2; i <=N; i++) {
			for (int j = 1; j <=2; j++) {
				//1번 전에꺼 2번 전에꺼 비교해야함	
				if((j==1&&max[i-j][1]!=1)||(j==2)) {
					if(max[i][0]<max[i-j][0]+p[i]) {
						max[i][0]=max[i-j][0]+p[i];
						if(j==1) {
							max[i][1]=max[i-j][1]+1;
						}else {
							max[i][1]=0;
						}
					}
				}
				
			}
		}
		System.out.println(Arrays.deepToString(max));
		//System.out.println(max[N][0]);
		
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

*/