package BAEKJOON;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main8983{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine().trim());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine().trim());
		int[] sand = new int[M];

		for (int i = 0; i < M; i++) {
			sand[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sand);
		int count = 0;
		int[][] pq=new int[N][2];
		for (int i = 0; i <N; i++) {
			st= new StringTokenizer(br.readLine().trim());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			pq[i][0]=a;
			pq[i][1]=b;
		}
		Arrays.sort(pq, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});

		int index=0;
		for (int i = 0; i < N; i++) {			
			while(index!=M-1&&sand[index+1]<pq[i][0]) {
				index++;
			}
			if(Math.abs(sand[index]-pq[i][0])+pq[i][1]<=L) {
				count++;
				continue;
			}
			if(index!=M-1&&Math.abs(sand[index+1]-pq[i][0])+pq[i][1]<=L) {
				count++;
				continue;
			}
		}

		System.out.println(count);

	}

}