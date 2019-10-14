package D6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeSet;

public class Solution1257 {

	public static void main(String[] args) throws Throwable, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine().trim());
		char[] cc;
		for (int i = 1; i <=T; i++) {
			int N=Integer.parseInt(br.readLine().trim());
			cc=br.readLine().trim().toCharArray();
			
			int index=0;
			while(N>index) {
				index=index+(int)Math.pow(2, cc.length-1);
			}
			
			
		}
		
	}
	static void find(TreeSet<Character> c,int find,int now) {
		
		while(find>now) {
			now=now+(int)Math.pow(2,c.size()-1);
		}
		
	}

}
