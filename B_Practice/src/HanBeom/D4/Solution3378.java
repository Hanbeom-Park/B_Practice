package D4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Solution3378 {
	static ArrayList<tab> list;
	static ArrayList<tab> event;
	static int Rcnt;
	static int Ccnt;
	static int Scnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			list = new ArrayList<>();
			event = new ArrayList<>();
			Rcnt = 0;
			Ccnt = 0;
			Scnt = 0;

			String[] pStr = new String[p];
			for (int i = 0; i < p; i++) {
				pStr[i] = sc.next();
			}
			String[] qStr = new String[q];
			int[] res = new int[q];
			Arrays.fill(res, -2);
			for (int i = 0; i < q; i++) {
				qStr[i] = sc.next();
			}
			int qcount1 = 0;
			int qcount2 = 0;
			int qcount3 = 0;
			for (int i = 0; i < p; i++) {
				char[] ch = pStr[i].toCharArray();
				int cnt = 0;
				while (true) {
					if (ch[cnt] != '.')
						break;
					cnt++;
				}
				if (cnt != 0) {
					list.add(new tab(cnt, qcount1, qcount2, qcount3));
				}
				for (int j = 0; j < ch.length; j++) {
					if (ch[j] == '(') {
						qcount1++;
					} else if (ch[j] == ')') {
						qcount1--;
					} else if (ch[j] == '{') {
						qcount2++;
					} else if (ch[j] == '}') {
						qcount2--;
					} else if (ch[j] == '[') {
						qcount3++;
					} else if (ch[j] == ']') {
						qcount3--;
					}
				}
			}

			go();

			int pcount1 = 0;
			int pcount2 = 0;
			int pcount3 = 0;
			System.out.print("#" + tc + " ");
			for (int i = 0; i < q; i++) {
				for (int e = 0; e < event.size(); e++) {
					tab tab = event.get(e);
					if (res[i] == -2) {
						res[i] = tab.R * pcount1 + tab.C * pcount2 + tab.S * pcount3;
					} else if (res[i] != tab.R * pcount1 + tab.C * pcount2 + tab.S * pcount3) {
						res[i] = -1;
					}
				}
				if (pcount1 + pcount2 + pcount3 == 0) {
					res[i] = 0;
				} else if (event.size() == 0) {
					res[i] = -1;
				}
				if (res[i] == -2) {
					res[i] = 0;
				}
				System.out.print(res[i] + " ");
				char[] ch = qStr[i].toCharArray();
				for (int j = 0; j < ch.length; j++) {
					if (ch[j] == '(') {
						pcount1++;
					} else if (ch[j] == ')') {
						pcount1--;
					} else if (ch[j] == '{') {
						pcount2++;
					} else if (ch[j] == '}') {
						pcount2--;
					} else if (ch[j] == '[') {
						pcount3++;
					} else if (ch[j] == ']') {
						pcount3--;
					}
				}
			}
			System.out.println();
		}
	}

	public static void go() {
		for (int R = 1; R <= 20; R++) {
			for (int C = 1; C <= 20; C++) {
				for (int S = 1; S <= 20; S++) {
					for (int i = 0; i < list.size(); i++) {
						tab tab = list.get(i);
						if (tab.cnt == (tab.R * R) + (tab.C * C) + (tab.S * S)) {
							if (i == list.size() - 1) {
								event.add(new tab(0, R, C, S));
							}
						} else {
							break;
						}

					}
				}
			}
		}
	}

	public static class tab {
		int cnt;
		int R;
		int C;
		int S;

		public tab(int Cr, int r, int c, int s) {
			cnt = Cr;
			R = r;
			C = c;
			S = s;
		}

		@Override
		public String toString() {
			return "tab [cnt=" + cnt + ", R=" + R + ", C=" + C + ", S=" + S + "]";
		}
	}
}