import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main2247_2 {
	//학생들이 머물고 있는 가장 긴 시간
	//학생이 없었던 가장 긴 시간
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		int min=Integer.MAX_VALUE;
		int max=0;
		boolean[] check=new boolean[Integer.MAX_VALUE-8];
		int [][] use=new int[N][2];
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine().trim());
			int S=Integer.parseInt(st.nextToken());
			int E=Integer.parseInt(st.nextToken());
			use[i][0]=S;
			use[i][1]=E;
			
			if(S<min) {
				min=S;
			}
			if(E>max) {
				max=E;
			}
			for (int j = S; j <E; j++) {
				check[j]=true;
			}
		}
		int now=min;
		int count=0;
		
		int maxY=0;
		int maxN=0;
		for (int i = min+1; i <=max; i++) {
			if(check[i]==check[now]) {
				//count++;
			}else {
				if(check[now]) {
					if(maxY<i-now) {
						maxY=i-now;
					}
				}else {
					if(maxN<i-now) {
						maxN=i-now;
					}
				}
				now=i;
				count=0;
			}
		}
		System.out.println((maxY)+" "+(maxN));
	}

}
/*
4
1 3
3 6
3 8
12 17

*/