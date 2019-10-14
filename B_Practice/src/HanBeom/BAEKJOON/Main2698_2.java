package BAEKJOON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2698_2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		for (int i = 1; i <= T; i++) {
			st=new StringTokenizer(br.readLine().trim());
			int n=Integer.parseInt(st.nextToken());
			int k=Integer.parseInt(st.nextToken());
			//k인ㅇ 수열 S의 개수
			//3    1
			//4    2       0111 1110
			//5 6  5 1 11101   
			//6 12 9 3  111001 111010 111000 011101 010111 101110 011100 001110 000111 110110 011011 110011  
			//11이 1->3
			
			//1 5
		
			
			int[] map=new int[n+1];
			map[k+1]=1;
			for (int j = k+1; j <= n; j++) {
				if(j<k) {
					
				}
			}
		}
		
	}

}
