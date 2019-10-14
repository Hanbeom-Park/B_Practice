import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

public class Main2247 {
	//학생들이 머물고 있는 가장 긴 시간
	//학생이 없었던 가장 긴 시간
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine().trim());
		BitSet bitSet=new BitSet(Integer.MAX_VALUE);
		StringTokenizer st;
		int min=Integer.MAX_VALUE;
		int max=0;
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine().trim());
			int S=Integer.parseInt(st.nextToken());
			int E=Integer.parseInt(st.nextToken());
			if(S<min) {
				min=S;
			}
			if(E>max) {
				max=E;
			}
			for (int j = S; j <E; j++) {
				bitSet.set(j,true);
			}
		}
		int now=min;
		int count=0;
		
		int maxY=0;
		int maxN=0;
		for (int i = min+1; i <=max; i++) {
			if(bitSet.get(i)==bitSet.get(now)) {
				//count++;
			}else {
				if(bitSet.get(now)) {
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