package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1219 {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 1; i <=10; i++) {
			st=new StringTokenizer(br.readLine().trim());
			st.nextToken();
			int N=Integer.parseInt(st.nextToken());
			
			st=new StringTokenizer(br.readLine().trim());
			
			boolean[][] map=new boolean[100][100];
			boolean[] visit=new boolean[100];
			for (int j = 0; j <N; j++) {
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=true;
			}
			Queue<Integer> q=new LinkedList<>();
			q.add(0);
			boolean check=false;
			exit: while(!q.isEmpty()) {
				int v=q.poll();
				
				visit[v]=false;
				for (int j = 0; j <map.length; j++) {
					if(map[v][j]&&!visit[j]) {
						if(j==99) {
							check=true;
							break exit;
						}
						map[v][j]=false;
						q.add(j);
					}
				}
			}
			System.out.print("#"+i+" ");
			if(check) {
				System.out.println("1");
			}else {
				System.out.println("0");	
			}
		}
	}

}
