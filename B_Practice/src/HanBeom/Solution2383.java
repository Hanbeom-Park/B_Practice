import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution2383 {
	//가장 빨리 끝나는 경우=계단 사용률이 가장 높아야함?
	//가장 먼저 들어오는 순서-> 
	//나가는 시간이 빠른 순서대로 집어넣기
	//사람 index, A도착시점, B도착 시점.
	//A출구 선택시 나오는 시간, B출구 선택시 나오는 시간
	//A 이용 가능 시간, B 이용가능시간
	
	//A와 B에 가장 빨리 나갈수 있는 사람이 같으면 더 빠른쪽에 집어넣고, 다른 사람이면 각각 집어넣음. 
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		for (int i = 1; i <=T; i++) {
			int N=Integer.parseInt(br.readLine().trim());
			int[][] map=new int[N][N];
			boolean[][] people=new boolean[N][N];
			int[][] stairs=new int[2][3];
			int c=0;
			for (int j = 0; j < map.length; j++) {
				st=new StringTokenizer(br.readLine().trim());
				for (int j2 = 0; j2 < map.length; j2++) {
					map[j][j2]=Integer.parseInt(st.nextToken());
					if(map[j][j2]==1) {
						people[j][j2]=true;
					}
					if(map[j][j2]>=2) {
						stairs[c][0]=j;
						stairs[c][1]=j2;
						stairs[c++][2]=map[j][j2];
					}
				}
			}
			c=0;
			//가까운거 3개까지 
			//굳이 한개 한개씩 들어갈 필요가 없다.
			
			//index arrivetime
			ArrayList<Integer[]> stairA=new ArrayList<>();
			ArrayList<Integer[]> stairB=new ArrayList<>();
			
			for (int j = 0; j < map.length; j++) {
				for (int j2 = 0; j2 < map.length; j2++) {
					if(people[j][j2]) {
						Integer[] aa= {c,Math.abs(stairs[0][0]-j)+Math.abs(stairs[0][1]-j2)};
						stairA.add(aa);
						Integer[] bb= {c,Math.abs(stairs[1][0]-j)+Math.abs(stairs[1][1]-j2)};
						stairB.add(bb);
						c++;
					}
				}
			}
			stairA.sort(new Comparator<Integer[]>() {

				@Override
				public int compare(Integer[] o1, Integer[] o2) {
					return o1[1]-o2[1];
				}
				
			});
			stairB.sort(new Comparator<Integer[]>() {

				@Override
				public int compare(Integer[] o1, Integer[] o2) {
					return o1[1]-o2[1];
				}
				
			});
			int a_count=0;
			int b_count=0;
			int a_end=0;//마지막에 들어간게 나오는 시간
			int b_end=0;
			while(!stairA.isEmpty()&&!stairB.isEmpty()) {
				if(stairA.get(0)[0]==stairB.get(0)[0]) {
					
				}else {
					if(a_count<3) {//
						
					}else {
						
					}
				}
			}
//			for (int j = 0; j < stairA.size(); j++) {
//				//System.out.print(stairA.get(j)[1]+ " ");
//				System.out.print(stairB.get(j)[1]+ " ");
//				
//			}
			
			
		}
	}
	static class people{
		int index;
		int toA;
		int toB;
		people(int i,int a,int b){
			index=i;
			toA=a;
			toB=b;
		}
	}

}
/*
1
5
0 1 1 0 0
0 0 1 0 3
0 1 0 1 0
0 0 0 0 0
1 0 5 0 0

*/