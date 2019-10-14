import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1219 {
	static boolean[][] map;
	static boolean[] visit;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 1; i <=10; i++) {
			st=new StringTokenizer(br.readLine().trim());
			st.nextToken();
			int N=Integer.parseInt(st.nextToken());
			
			st=new StringTokenizer(br.readLine().trim());
			
			map=new boolean[100][100];
			visit=new boolean[100];
			for (int j = 0; j <N; j++) {
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=true;
			}
		
			for (int j = 0; j <map.length; j++) {
				if(map[0][j]) {
					dfs(j);
				}
			}
			if(visit[99]==true) {
				System.out.println("#"+i+" 1");
			}else {
				System.out.println("#"+i+" 0");
					
			}
		}
	
	}
	static void dfs(int n) {
		visit[n]=true;
		for (int i = 0; i < map.length; i++) {
			if(map[n][i]&&!visit[i]) {
				dfs(i);
			}
		}
	}

}
