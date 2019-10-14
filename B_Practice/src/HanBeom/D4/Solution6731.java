package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution6731 {
	static int N,min=9999;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		for (int i = 1; i <=T; i++) {
			N=Integer.parseInt(br.readLine().trim());
			char[][] map=new char[N][N];
			for (int j = 0; j <N; j++) {
				map[j]=br.readLine().trim().toCharArray();
			}
			find(map,0,0);
			System.out.println("#"+i+" "+min);
			min=9999;
		}
	}
	static void find(char[][] map,int index,int count) {
		if(index==N*N) {
			int k=0;
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if(map[i][j]=='B') {
						k=1;
						break;
					}
				}
			}
			if(k==0) {
				if(min>count) {
					min=count;
				}
			}
			return;
		}
		if(count>=min) {
			return;
		}
		find(map,index+1,count);
		int y=index%N;
		int x=index/N;
		for (int l = 0; l < map.length; l++) {
			if(map[l][y]=='W') {
				map[l][y]='B';
			}else {
				map[l][y]='W';
			}
			if(map[x][l]=='W') {
				map[x][l]='B';
			}else {
				map[x][l]='W';
			}
		}
		if(map[x][y]=='W') {
			map[x][y]='B';
		}else {
			map[x][y]='W';
		}
		find(map,index+1,count+1);
		for (int l = 0; l < map.length; l++) {
			if(map[l][y]=='W') {
				map[l][y]='B';
			}else {
				map[l][y]='W';
			}
			if(map[x][l]=='W') {
				map[x][l]='B';
			}else {
				map[x][l]='W';
			}
		}
		if(map[x][y]=='W') {
			map[x][y]='B';
		}else {
			map[x][y]='W';
		}
	}
	
}

/*
1
2
WW
BB

4
4
WWWW
WWWW
WWWW
WWWW
4
BWWB
WWBB
WBWB
BBBW
4 
WBWW
WBWW
BBBB
WBWW
4
WBWB
WBWB
WBWB
WBWB

*/

