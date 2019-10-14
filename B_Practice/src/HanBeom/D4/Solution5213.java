package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5213 {
	// f(x)는 약수 중에서 홀수인 것들의 합
	// L과 R사이의 자연수 x에 대한 f(x)값
	// 2n+1
	// 홀수 약수는 홀수*홀수
	// 1 3 9 *5 // 3 33 3*3*3
	// 3 3 3/백만개
	// 1000 1000
	// 1000 *1*3*5*7*9...->100만까지
	//
	public static void main(String[] args) throws NumberFormatException, IOException {
		long[] map = new long[1000001];
		long[] map2 = new long[1000001];
		for (int i = 1; i <= 1000000; i = i + 2) {
			for (int j = i; j <= 1000000; j=j+i) {
				map[j] = map[j] + i;
			}
		}
		for (int i = 1; i <= 1000000; i++) {
				map2[i] = map[i] + map2[i-1];
		}
//		for (int i = 1; i <100; i++) {
//			System.out.print(map[i]+" ");
//		}
//		System.out.println();
//		for (int i = 1; i <100; i++) {
//			System.out.print(map2[i]+" ");			
//		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		for (int i = 1; i <= T; i++) {
			st=new StringTokenizer(br.readLine().trim());
			int L=Integer.parseInt(st.nextToken());
			int R=Integer.parseInt(st.nextToken());
			long tot=0;
				tot=map2[R]-map2[L-1];
			System.out.println("#"+i+" "+tot);
		}
	}

}
/*
2
6 10
1000 1000000
*/