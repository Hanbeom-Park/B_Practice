package D4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution1238_2 {
	static boolean[][] map;
	static boolean[] check;
	static int N;
	static int max_count;
	static int max;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		for (int i = 1; i <=1; i++) {
			N=sc.nextInt();
			int start=sc.nextInt();
			map=new boolean[101][101];
			check=new boolean[101];
			for (int j = 0; j < N/2; j++) {
					map[sc.nextInt()][sc.nextInt()]=true;
			}
			
			max_count=0;
			max=0;
			Queue<Integer> ss=new LinkedList<>();
			ss.add(start);
			int count=0;
			while(!ss.isEmpty()) {
				int v=ss.poll();
				if(count>max_count) {
					max_count=count;
					max=v;
				}else if(count==max_count&&max<v) {
						max=v;
				}
				for (int k = 1; k <map.length; k++) {
					if(map[v][k]&&!check[k]) {
						map[v][k]=false;
						ss.add(k);
						System.out.println(k);
					}
				}
				count++;
			}
			System.out.println("#"+i+" "+max);
		}
	}

}
