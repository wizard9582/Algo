package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class q1767 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] map;
	static int answer, N, coreCount;
	static List<int[]> list = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			answer = Integer.MAX_VALUE;
			coreCount = 0;
			list.clear();
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < N; m++) {
					map[n][m] = Integer.parseInt(st.nextToken());
				}
			}
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < N; m++) {
					if (map[n][m] == 1) {
						if (coreCheck(n, m)) {
							list.add(new int[] { n, m });
						}
					}
				}
			}

			dfs(0, 0, 0);
			if (answer == Integer.MAX_VALUE) {
				answer = 0;
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}

		System.out.println(sb);
	}

	static void dfs(int count, int core, int wire) {

		if (core + list.size() - count < coreCount) {
			return;
		}

		if (count == list.size()) {
			if (core > coreCount) {
				coreCount = core;
				answer = wire;
			} else if (core == coreCount) {
				answer = Math.min(answer, wire);
			}
			return;
		}

		dfs(count + 1, core, wire);

		int x = list.get(count)[0];
		int y = list.get(count)[1];

		for (int i = 0; i < 4; i++) {

			int nX = x;
			int nY = y;
			int length = 0;
			boolean flag = false;

			while (true) {
				
				nX += delta[i][0];
                nY += delta[i][1];
				
				if (!isIn(nX, nY)) {
					flag = true;
					break;
				}
				if (map[nX][nY] == 1) {
					break;
				}
				map[nX][nY] = 1;
				length++;
			}

			if (flag) {
				dfs(count + 1, core + 1, wire + length);
				clean(x, y, i, length);
			} else {
				clean(x, y, i, length);
			}
		}
	}

	static boolean isIn(int x, int y) {

		if (0 <= x && x < N && 0 <= y && y < N) {
			return true;
		}

		return false;
	}

	static boolean coreCheck(int x, int y) {
		int count = 0;

		for (int i = 0; i < 4; i++) {
			int nX = x + delta[i][0];
			int nY = y + delta[i][1];
			if (!isIn(nX, nY)) {
				return false;
			}
			if (map[nX][nY] == 1) {
				count++;
				if (count == 4) {
					return false;
				}
			}
		}
		return true;
	}

	static void clean(int x, int y, int d, int l) {
		int nX = x;
		int nY = y;

		for (int i = l; i > 0; i--) {
			nX += delta[d][0];
			nY += delta[d][1];

			map[nX][nY] = 0;
		}
	}
}
