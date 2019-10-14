package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution1226 {
	static int[] x_dir= {0,0,-1,1};
	static int[] y_dir= {1,-1,0,0};
	static char[][] map;
	static Stack<Integer[]> s;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for (int i = 1; i <=10; i++) {
			map=new char[16][16];
			br.readLine();
			for (int j = 0; j < map.length; j++) {
				map[j]=br.readLine().trim().toCharArray();
			}
			int x=0;
			int y=0;
			int[] loc=new int[2];
			s=new Stack<>();
			Integer[] aa= {1,1};
			s.push(aa);
			boolean find=false;
			while(!s.isEmpty()) {
				Integer[] bb=s.pop();
				x=bb[0];
				y=bb[1];
				if(map[x][y]=='3') {
					find=true;
					break;
				}
				map[x][y]=1;
				for (int j = 0; j < 4; j++) {
					if(map[x+x_dir[j]][y+y_dir[j]]!='1') {
						Integer[] now = {x+x_dir[j],y+y_dir[j]};
						s.push(now);
					}		
				}
			}
			System.out.print("#"+i+" ");
			if(find) {
				System.out.println("1");
			}else {
				System.out.println("0");	
			}
		}
	}

}
