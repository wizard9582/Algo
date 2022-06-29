package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1743 {
	static StringTokenizer st;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		boolean[][] map = new boolean[N][M];

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = true;
		}

		int answer = 0;
		Queue<int[]> queue = new LinkedList<>();

		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (map[n][m]) {
					int size = 0;
					map[n][m] = false;
					queue.offer(new int[] {n,m});
					
					while(!queue.isEmpty()) {
						int x = queue.peek()[0];
						int y = queue.poll()[1];
						size ++;
						
						for(int i = 0; i < 4; i ++) {
							int nX = x+delta[i][0];
							int nY = y+delta[i][1];
							
							if(isIn(nX,nY)&&map[nX][nY]) {
								map[nX][nY] = false;
								queue.offer(new int[] {nX,nY});
							}
						}
					}
					answer = Math.max(answer, size);
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