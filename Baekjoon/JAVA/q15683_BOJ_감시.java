package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class q15683_BOJ_감시 {
	static StringTokenizer st;
	static int[][] dir = { {}, { 1, 2, 4, 8 }, { 3, 12 }, { 9, 10, 6, 5 }, { 14, 13, 11, 7 }, { 15 } };
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int R, C, N, answer = Integer.MAX_VALUE;
	static List<int[]> list = new ArrayList<>();
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];

		for (int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] != 0 && map[r][c] < 6) {
					list.add(new int[] { map[r][c], r, c });
				}
			}
		}

		Collections.sort(list, (e1, e2) -> {
			return e2[0] - e1[0];
		});
		N = list.size();

		dfs(0);

		System.out.println(answer);
	}

	static void dfs(int count) {

		if (count == N) {
			answer = Math.min(answer, check(map));
			return;
		}
		int[] now = list.get(count);
		int[][] save = new int[R][C];

		for (int i = 0; i < dir[now[0]].length; i++) {
			int d = dir[now[0]][i];
			copy(map, save);
			for (int j = 0; j < 4; j++) {
				if ((d & (1 << j)) > 0) {

					int nX = now[1] + delta[j][0];
					int nY = now[2] + delta[j][1];
					while (isIn(nX, nY)) {
						if (map[nX][nY] == 0) {
							map[nX][nY] = 9;
						} else if (map[nX][nY] == 6) {
							break;
						}
						nX += delta[j][0];
						nY += delta[j][1];
					}
				}
			}
			dfs(count+1);
			copy(save, map);
		}
	}

	static int check(int[][] map) {
		int count = 0;
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c] == 0) {
					count++;
				}
			}
		}
		return count;
	}

	static void copy(int[][] from, int[][] to) {
		for (int r = 0; r < R; r++) {
			to[r] = from[r].clone();
		}
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < R && 0 <= y && y < C) {
			return true;
		}
		return false;
	}
}
