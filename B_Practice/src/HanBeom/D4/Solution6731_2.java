package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution6731_2 {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		for (int i = 1; i <= T; i++) {
			N = Integer.parseInt(br.readLine().trim());
			int min = 1000000;
			char[][] map = new char[N][N];
			char[][] map_copy = new char[N][N];

			for (int j = 0; j < N; j++) {
				map[j] = br.readLine().trim().toCharArray();
			}
			int count = 0;
			for (int i1 = 0; i1 < Math.pow(2,N*N); i1++) {
				//System.out.println(1<<36);
				for (int j = 0; j < map.length; j++) {
					map_copy[j] = map[j].clone();
				}
				for (int j = 0; j < N * N; j++) {
					if (count >= min) {
						break;
					}
					if ((i1 & (1 << j)) != 0) {
						int y = j % N;
						int x = j / N;
						for (int l = 0; l < map.length; l++) {
							if (map_copy[l][y] == 'W') {
								map_copy[l][y] = 'B';
							} else {
								map_copy[l][y] = 'W';
							}
							if (map_copy[x][l] == 'W') {
								map_copy[x][l] = 'B';
							} else {
								map_copy[x][l] = 'W';
							}
						}
						if (map_copy[x][y] == 'W') {
							map_copy[x][y] = 'B';
						} else {
							map_copy[x][y] = 'W';
						}
						count++;

					}
				}
				int k = 0;

				for (int i2 = 0; i2 < map.length; i2++) {
					for (int j = 0; j < map.length; j++) {
						// System.out.print(map[i2][j]+" ");
						if (map_copy[i2][j] == 'B') {
							k = 1;
							break;
						}
					}
					// System.out.println();
				}
				// System.out.println();
				if (k == 0) {
					if (min > count) {
						min = count;
					}
				}
				count = 0;
			}
			System.out.println("#" + i + " " + min);
		}
	}

}

/*
1
2
WW
BB

4
4
WWWW
WWWW
WWWW
WWWW
4
BWWB
WWBB
WBWB
BBBW
4 
WBWW
WBWW
BBBB
WBWW
4
WBWB
WBWB
WBWB
WBWB

1
8
WBWWWWWW
WBWWWWWW
WBWWWWWW
BBBBBBBB
WBWWWWWW
WBWWWWWW
WBWWWWWW
WBWWWWWW

1
6
WBWWWW
WBWWWW
WBWWWW
BBBBBB
WBWWWW
WBWWWW

*/

