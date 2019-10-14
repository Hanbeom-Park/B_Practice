package BAEKJOON;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main2210_2 {
	static char[][] map;
	static boolean[][] checked;
	static int[] dir_x= {1,-1,0,0};//상하좌우
	static int[] dir_y= {0,0,-1,1};
	static Set<Integer> aa=new TreeSet<>();
	static char[] now=new char[6];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		map=new char[7][7];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				map[i][j]='a';
			}
		}
		for (int i = 1; i < map.length-1; i++) {
			for (int j = 1; j < map.length-1; j++) {
				map[i][j]=sc.next().charAt(0);
			}
		}
		for (int i = 1; i < map.length-1; i++) {
			for (int j = 1; j < map.length-1; j++) {
				find(0,i,j);
			}
		}
		System.out.println(aa.size());
	}
	static void find(int d,int x,int y) {
		if(d==6) {
			String res="";
			for (int i = 0; i <now.length; i++) {
				res=res+now[i];
			}
			//System.out.println(res);
			aa.add(Integer.parseInt(res));
			return;
		}
		now[d]=map[x][y];
		for (int i = 0; i < dir_x.length; i++) {
			if(map[x+dir_x[i]][y+dir_y[i]]!='a') {
				find(d+1,x+dir_x[i],y+dir_y[i]);
			}
		}
		
	}
}
