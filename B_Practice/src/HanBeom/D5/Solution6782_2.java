package D5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution6782_2 {
	static long[] data= new long[1000000];
	public static void main(String[] args) throws Throwable, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int j = 1; j < data.length; j++) {
			data[j]=j*j;
		}
		for (int i = 1; i <= T; i++) {
			long N = Long.parseLong((br.readLine().trim()));
			int count=0;
			int aa;
			
			while(N>2) {
				if(N>data[data.length-1]) {
					if((long)Math.sqrt(N)==Math.sqrt(N)){
						N=(long) Math.sqrt(N);
						count++;
					}else {
						N=N+1;
						count++;
					}
				}else {
					aa=2;
					while(N>data[aa]) {
						aa++;
					}
					count=count+(int)data[aa]-(int)N;
					N=data[aa];
					N=(long) Math.sqrt(N);
					count++;
				}
			}
			System.out.println("#" + i + " " + count);
			

			
		}

	}


}
/*
4
2
3
4
928197119

 */