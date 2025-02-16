package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q16956 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];

		for (int n = 0; n < N; n++) {
			String str = br.readLine();
			for (int m = 0; m < M; m++) {
				map[n][m] = str.charAt(m);
			}
		}

		boolean flag = true;

		loop : for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if(map[n][m] == 'W') {
					
					for(int i =0; i < 4; i++) {
						int x = n + delta[i][0];
						int y = m + delta[i][1];
						
						if(isIn(x,y)) {
							if(map[x][y] == '.') {
								map[x][y] = 'D';
							}else if(map[x][y] == 'S') {
								flag = false;
								break loop;
							}
						}
					}
				}
			}
		}

		if(flag) {
			System.out.println(1);
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					sb.append(map[n][m]);
				}
				sb.append("\n");
			}
			System.out.println(sb);
		}else {
			System.out.println(0);
		}
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < M) {
			return true;
		}
		return false;
	}
}
