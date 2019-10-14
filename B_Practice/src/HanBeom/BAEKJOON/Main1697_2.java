package BAEKJOON;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main1697_2 {
	static int N, K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			N = sc.nextInt();
			K = sc.nextInt();
			int[] check=new int[100001];
			Arrays.fill(check,-1);
			int now=N;
			int[] status=new int[3];
			Queue<Integer> q=new LinkedList<Integer>();
			q.add(now);
			check[now]=0;
			while(!q.isEmpty()&&now!=K) {
				now=q.poll();
				status[0]=now-1;
				status[1]=now+1;
				status[2]=now*2;
				for (int i = 0; i <3; i++) {
					if(status[i]>=0&&status[i]<=100000) {
						if(check[status[i]]==-1) {
							q.add(status[i]);
							check[status[i]]=check[now]+1;
						}
					}
				}
			}
			
			System.out.println(check[K]);
	}
}
