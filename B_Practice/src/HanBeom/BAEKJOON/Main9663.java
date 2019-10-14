package BAEKJOON;

import java.util.Arrays;
import java.util.Scanner;

public class Main9663 {
	static int N;
	static int[] result;
	static int count=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		result = new int[N];
		Arrays.fill(result, -1);
		find(0);
		System.out.println(count);
	}

	static void find(int d) {
		if (d == N) {
			count++;
			return;
		}
		for (int i = 0; i < N; i++) {
			result[d] = i;
			if (isOk(d)) {
				find(d + 1);
			}
		}
	}

	static boolean isOk(int d) {
		for (int i = 0; i < d; i++) {
			if (result[i] == result[d] || result[i] + d - i == result[d] || result[i] - (d - i) == result[d]) {
				return false;
			}
		}
		return true;
	}
}
