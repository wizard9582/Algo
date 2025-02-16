package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q23352_BOJ_방탈출 {
	static StringTokenizer st;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<int[]> queue = new LinkedList<int[]>();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		int longestDis = 0;
		int pw = 0;

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (map[n][m] == 0) {
					continue;
				}
				boolean[][] checked = new boolean[N][M];
				queue.offer(new int[] { n, m, 0 });
				checked[n][m] = true;
				while (!queue.isEmpty()) {
					int[] now = queue.poll();
					
					if (longestDis == now[2]) {
						pw = Math.max(map[n][m] + map[now[0]][now[1]], pw);
					} else if (longestDis < now[2]) {
						longestDis = now[2];
						pw = map[n][m] + map[now[0]][now[1]];
					}

					for (int i = 0; i < 4; i++) {
						int nN = now[0] + delta[i][0];
						int nM = now[1] + delta[i][1];
						if (isIn(nN, nM) && map[nN][nM] != 0 && !checked[nN][nM]) {
							checked[nN][nM] = true;
							queue.offer(new int[] { nN, nM, now[2] + 1 });
						}
					}
				}
			}
		}

		System.out.println(pw);
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < M) {
			return true;
		}
		return false;
	}
}
