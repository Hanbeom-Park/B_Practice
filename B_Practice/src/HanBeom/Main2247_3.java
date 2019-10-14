import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main2247_3 {
	//학생들이 머물고 있는 가장 긴 시간
	//학생이 없었던 가장 긴 시간
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		int min=Integer.MAX_VALUE;
		int max=0;
		//boolean[] check=new boolean[Integer.MAX_VALUE-8];
		int [][] use=new int[N][2];
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine().trim());
			int S=Integer.parseInt(st.nextToken());
			int E=Integer.parseInt(st.nextToken());
			use[i][0]=S;
			use[i][1]=E;
			
//			if(S<min) {
//				min=S;
//			}
//			if(E>max) {
//				max=E;
//			}
//			for (int j = S; j <E; j++) {
//				check[j]=true;
//			}
		}
		Arrays.sort(use, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]==o2[0]) {
					return o2[1]-o1[1];
				}
				return o1[0]-o2[0];
			}
		});
		int index=0;
		int start=use[0][0];		
		int end=use[0][1];
		int max1=0;//사람있을때
		int max2=0;
		for (int i = 0; i < use.length; i++) {
				//System.out.println(use[i][0]+" "+use[i][1]);
		}
		for (int i = 1; i <N; i++) {
			if(use[i][0]!=use[index][0]) {
				index=i;
				if(end>=use[index][0]) {
					if(use[index][1]>end) {
						end=use[index][1];
					}
				}else {
					if(max1<end-start) {
						max1=end-start;
						//System.out.println(end+" "+start+"AA");
					}
					if(max2<use[index][0]-(end)) {
						max2=use[index][0]-(end);
						//System.out.println(use[index][0]+" "+end+"BB");
					}
					start=use[index][0];
					end=use[index][1];
				}
			}
			if(i==N-1) {
				if(max1<end-start) {
					max1=end-start;
				}
				if(max2<use[index][0]-(end)) {
					max2=use[index][0]-(end);
				}
			}
			//System.out.println(end+" "+start+"AA");
		}

		System.out.println((max1)+" "+(max2));
	}

}
/*
4
1 3
3 6
3 8
12 17

*/