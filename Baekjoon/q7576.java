package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q7576 {
	static StringTokenizer st;
	static int N, M;
	static int[][] tomato;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		tomato = new int[N][M];
		int answer = 0;

		Queue<int[]> queue = new LinkedList<>();

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				tomato[n][m] = Integer.parseInt(st.nextToken());
				if (tomato[n][m] == 1) {
					queue.offer(new int[] { n, m, 0 });
				}
			}
		}

		while (!queue.isEmpty()) {
			int x = queue.peek()[0];
			int y = queue.peek()[1];
			int day = queue.poll()[2];
			
			for(int i = 0; i < 4; i++) {
				int nX = x + delta[i][0];
				int nY = y + delta[i][1];
				
				if(isIn(nX,nY) && tomato[nX][nY] == 0) {
					queue.offer(new int[] {nX,nY,day+1});
					tomato[nX][nY] = 1;
				}
			}
			answer = day;
		}

		loop: for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (tomato[n][m] == 0) {
					answer = -1;
					break loop;
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
