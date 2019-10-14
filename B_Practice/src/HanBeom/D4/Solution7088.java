package D4;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution7088{

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T=Integer.parseInt(br.readLine().trim());
		StringTokenizer st;
		for (int i = 1; i <=T; i++) {
			st=new StringTokenizer(br.readLine().trim());
			int N=Integer.parseInt(st.nextToken());//i번 소의 품종번호
			int Q=Integer.parseInt(st.nextToken());//L R
			int[] map=new int[N+1];
			int[][] count=new int[N+1][4];
			for (int j = 1; j <=N; j++) {
				map[j]=Integer.parseInt(br.readLine().trim());
				for (int j2 = 1; j2 <=3; j2++) {
					if(map[j]==j2) {
							count[j][j2]=count[j-1][j2]+1;
					}else {
						count[j][j2]=count[j-1][j2];
					}
					
				}
			}			
			System.out.println("#"+i);
			for (int j = 0; j < Q; j++) {
				String ss[]=br.readLine().split(" ");
				int a=Integer.parseInt(ss[0]);
				int b=Integer.parseInt(ss[1]);
				
				for (int j2 = 1; j2 <=3; j2++) {
					bw.write(count[b][j2]-count[a-1][j2]+" ");
				}
				bw.write("\n");
			}
			bw.flush();
		}
	}

}
