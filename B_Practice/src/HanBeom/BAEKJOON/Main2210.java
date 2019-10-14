package BAEKJOON;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2210 {
	private static final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	private static final int ROW = 0;
	private static final int COL = 1;

	private static int[] tmp = new int[6];
	private static int[] isVisited = new int[1 << 20];
	private static int[][] map = new int[5][5];
	private static int res = 0;
	private static int num = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				tmp[0] = map[i][j];
				
				backTracking(1, i, j);
				tmp[0] = 0;
			}
		}
		
		System.out.println(res);
	}
	
	private static void backTracking(int depth, int row, int col) {
		if(depth == 6) {
			num = 0;
			
			for(int i = 0; i < depth; i++) {
				num += tmp[i] * pow(10, 5 - i);
			}
			
			if((isVisited[num] & 1 << num) == 0) {
				isVisited[num] = (isVisited[num] | 1) << num;
				res++;
			}
			
			return;
		}
		
		for(final int[] DIRECTION: DIRECTIONS) {
			int nextRow = row + DIRECTION[ROW];
			int nextCol = col + DIRECTION[COL];
			
			if(nextRow >= 0 && nextRow < 5 && nextCol >= 0 && nextCol < 5) {
				tmp[depth] = map[nextRow][nextCol];
				backTracking(depth + 1, nextRow, nextCol);
				tmp[depth] = 0;
			}
		}
	}

	private static int pow(int i, int j) {
		return (int) Math.pow(i, j);
	}
}