package D4;

import java.util.Scanner;

public class Solution6026 {
	static long M,N,mod;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		mod=1000000007L;
		for (int i = 1; i <=T; i++) {
			M=sc.nextLong();
			N=sc.nextLong();
			//M^N
			long result=1;
		    long res = 1L;
		    M = M % mod;
		    //7개를 전부 다 사용하는 경우 1,2,3,4,5,6개 전부 사용하는 경우 
			//22222
//			for (int j = 0; j < N; j++) {
//				result=result*M%mod;
//			}
//			long tmp=1;
//			for (int j = 0; j < N; j++) {
//				tmp=tmp*(M-1)%mod;
//			}
//			tmp=tmp*M%mod;
			//result=(result-tmp)%mod;
			System.out.println("#"+i+" "+res);
			
		}
	}
	static void aaa(long m,long n) {
		long tmp=1;
		for (int i = 0; i < n; i++) {
			tmp=tmp*m%mod;
		}
	}
}
/*


3
1 1
2 5
7 11	

*/