package BAEKJOON;

import java.util.Scanner;

public class Main1697 {
	static boolean[] location = new boolean[100001];
	static int N, K;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//int T = sc.nextInt();
		//for (int i = 1; i <= T; i++) {
			N = sc.nextInt();
			K = sc.nextInt();
			if (N < K) {
				find(N,0);
			} else {
				min = N - K;
			}
			System.out.println(min);
		//}
	}

	static void find(int now, int count) {
		if (location[now] == true) {
			return;
		} else if (now == K) {
			if (count < min) {
				min = count;
			}
			return;
		}
		if (count < min) {
			location[now] = true;

			if (now * 2 <=location.length) {
				find(now * 2, count++);
			}
			if (now + 1 <=K) {
				find(now + 1, count++);
			}
			if (now - 1 >=0) {
				find(now - 1, count++);
			}
		}
	}
}
