package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class q2667 {
	static StringBuilder sb = new StringBuilder();
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][] map;
	static List<Integer> list = new LinkedList<>();
	static int count, N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new boolean[N][N];

		for (int n = 0; n < N; n++) {
			String str = br.readLine();
			for (int m = 0; m < N; m++) {
				if (str.charAt(m) == '1') {
					map[n][m] = true;
				}
			}
		}

		int apart = 0;
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < N; m++) {
				if (map[n][m]) {
					apart++;
					count = 0;
					dfs(n, m);
					list.add(count);
				}
			}
		}

		sb.append(apart).append("\n");
		Collections.sort(list, (e1, e2) -> {
			return e1 - e2;
		});
		for (Integer e : list) {
			sb.append(e).append("\n");
		}

		System.out.println(sb);
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < N) {
			return true;
		}
		return false;
	}

	static void dfs(int x, int y) {
		count++;
		map[x][y] = false;

		for (int i = 0; i < 4; i++) {
			int nX = x + delta[i][0];
			int nY = y + delta[i][1];
			
			if(isIn(nX,nY) && map[nX][nY]) {
				dfs(nX,nY);
			}
		}
	}
}