package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q16924 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static char[][] cross;
	static boolean[][] check;
	static int N, M, count = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		cross = new char[N][M];
		check = new boolean[N][M];

		for (int n = 0; n < N; n++) {
			String str = br.readLine();
			cross[n] = str.toCharArray();
		}

		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (cross[n][m] == '*') {
					check[n][m] = true;
				}
			}
		}

		for (int n = 1; n < N-1; n++) {
			for (int m = 1; m < M-1; m++) {
				if (cross[n][m] == '*') {
					crossCheck(n, m);
				}
			}
		}

		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (check[n][m]) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(count);
		System.out.println(sb);
	}

	static void crossCheck(int n, int m) {
		int l = 1;
		int x, y;
				
		while(true) {
			for(int i = 0; i < 4; i++) {
				x = n + (l * delta[i][0]);
				y = m + (l * delta[i][1]);
				
				if(!isIn(x,y)) {
					return;
				}else {
					if(cross[x][y] != '*') {
						return;
					}
				}
			}
			check[n][m] = false;
			for(int i = 0; i < 4; i++) {
				x = n + (l * delta[i][0]);
				y = m + (l * delta[i][1]);
				check[x][y] = false;
			}
			
			count ++;
			sb.append(n + 1).append(" ").append(m + 1).append(" ").append(l).append("\n");
			l++;
		}

	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < M) {
			return true;
		}

		return false;
	}
}
