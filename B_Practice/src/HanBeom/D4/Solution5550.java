package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution5550 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int i = 1; i <= T; i++) {
			char[] ss = br.readLine().trim().toCharArray();
			int count = 0;
			char[] flog = { 'c', 'r', 'o', 'a', 'k' };

			ArrayList<Integer> num = new ArrayList<>();
			for (int j = 0; j < ss.length; j++) {
				if(num.isEmpty()&&ss[j]!='c') {
					num.add(-1);
					break;
				}
				if (ss[j] == 'c') {
					num.add(1);
					if (num.size() > count) {
						count = num.size();
					}
					//System.out.println(num);
				} else {
					for (int j2 = 1; j2 < flog.length; j2++) {
						for (int k = 0; k < num.size(); k++) {
							if (flog[j2] == ss[j] && num.get(k) == j2) {
								//System.out.println("aaa");
								if (j2 == 4) {
									num.remove(k);
								} else {
									num.set(k, num.get(k) + 1);
								}
								j2=flog.length;break;
							}
						}
					}
				}
			}
			if(num.isEmpty()) {	
				System.out.println("#"+i+" "+count);
			}else {
				System.out.println("#"+i+" "+-1);
			}
			
		}
	}
}

/*
 * 
8
crcoarkcoroakak
ccccrrrrooooaaaakkkk
karoc
croakcorakcroak
ccroak
croakcroakcroakcroakcroakcroakcroakcroakcroakcroak
ccccccccccrrrrrrrrrrooooooooooaaaaaaaaaakkkkkkkkkk
crcocrroaokacakkrocrakcorakoak

1
crcoarkcoroakak


1
roarkcroak

*
*/
