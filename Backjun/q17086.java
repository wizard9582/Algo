package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q17086 {
	static StringTokenizer st;
	static int N, M;
	static int[][] delta = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		boolean[][] visit = new boolean[N][M];

		Queue<int[]> queue = new LinkedList<>();

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
				if (map[n][m] == 1) {
					queue.offer(new int[] { n, m, 0 });
					visit[n][m] = true;
				}
			}
		}
		
		int answer = 0;
		
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int x = now[0];
			int y = now[1];
			int c = now[2];
			answer = c;
			
			for(int i = 0; i < 8; i++) {
				int nX = x + delta[i][0];
				int nY = y + delta[i][1];
				
				if(isIn(nX,nY) && !visit[nX][nY]) {
					visit[nX][nY] = true;
					queue.offer(new int[] {nX,nY,c+1});
				}
			}

		}

		System.out.println(answer);
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < M) {
			return true;
		}
		return false;
	}
}
