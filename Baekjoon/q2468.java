package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2468 {
	static StringTokenizer st;
	static int N, Max, answer, now;
	static int[][] map;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static boolean[][] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		answer = 1;
		Max = 1;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < N; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
				Max = Math.max(Max, map[n][m]);
			}
		}

		for (int i = 1; i < Max; i++) {
			visit = new boolean[N][N];
			now = 0;
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < N; m++) {
					if (!visit[n][m] && map[n][m] > i) {
						now++;
						dfs(n,m,i);
					}
				}
			}
			answer = Math.max(answer, now);
		}

		System.out.println(answer);
	}

	static void dfs(int x, int y, int rain) {
		visit[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int nX = x + delta[i][0];
			int nY = y + delta[i][1];
			
			if(isIn(nX,nY) && !visit[nX][nY] && map[nX][nY]>rain) {
				dfs(nX,nY, rain);
			}
		}
		
	}
	static boolean isIn(int x, int y) {
		
		if(0<= x && x < N && 0<=y && y<N) {
			return true;
		}
		
		return false;
	}
}
