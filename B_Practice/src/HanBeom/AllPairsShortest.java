

import java.util.Arrays;
import java.util.Scanner;

public class AllPairsShortest {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int n=sc.nextInt();
		int[][] D=new int[v+1][v+1];
		for (int i = 0; i < D.length; i++) {
			Arrays.fill(D[i],1000);
		}
		for (int i = 1; i < D.length; i++) {
			D[i][i]=0;
		}
		for (int i = 0; i < n; i++) {
			D[sc.nextInt()][sc.nextInt()]=sc.nextInt();
		}
		
		for (int k = 1; k <=v; k++) {//i j k
			for (int i = 1; i <=v; i++) {
				for (int j = 1; j <=v; j++) {
					if(D[i][k]+D[k][j]>D[i][j]) {
						
					}else {
						D[i][j]=D[i][k]+D[k][j];
					}
				}
			}
		}
		for (int i = 1; i < D.length; i++) {
			for (int j = 1; j < D.length; j++) {
				System.out.print(D[i][j]+" ");
			}
			System.out.println();
		}
	}

}
/*
5 14
1 3 2
1 2 4
1 4 5
2 3 1
2 5 4
3 1 1
3 2 3
3 4 1
3 5 2
4 1 -2
4 5 2
5 2 -3
5 3 3
5 4 1
*/