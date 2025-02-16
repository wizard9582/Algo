package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q14500_BOJ_테트로미노 {
	static StringTokenizer st;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][] visit;
	static int[][] map;
	static int answer = 0, N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new boolean[N][M];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				dfs(n, m, 0, 0);
				if(n < N-2) {
					sero(n,m);
				}
				if(m < M-2) {
					garo(n,m);
				}
			}
		}

		System.out.println(answer);
	}

	static void dfs(int x, int y, int count, int sum) {
		if (count == 4) {
			answer = Math.max(answer, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nX = x + delta[i][0];
			int nY = y + delta[i][1];
			if (isIn(nX, nY) && !visit[nX][nY]) {
				visit[nX][nY] = true;
				dfs(nX, nY, count + 1, sum + map[nX][nY]);
				visit[nX][nY] = false;
			}
		}
	}

	static void sero(int x, int y) {
		
		int sum = map[x][y];
		sum += map[x+1][y];
		sum += map[x+2][y];
		
		if(isIn(x+1, y-1)) {
			answer = Math.max(answer, sum + map[x+1][y-1]);
		}
		if(isIn(x+1, y+1)) {
			answer = Math.max(answer, sum + map[x+1][y+1]);
		}
	}

	static void garo(int x, int y) {
		int sum = map[x][y];
		sum += map[x][y+1];
		sum += map[x][y+2];
		
		if(isIn(x-1, y+1)) {
			answer = Math.max(answer, sum + map[x-1][y+1]);
		}
		if(isIn(x+1, y+1)) {
			answer = Math.max(answer, sum + map[x+1][y+1]);
		}
	}

	static boolean isIn(int x, int y) {

		if (0 <= x && x < N && 0 <= y && y < M) {
			return true;
		}

		return false;
	}
}
