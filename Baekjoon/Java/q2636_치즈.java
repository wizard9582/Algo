package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2636 {
	static StringTokenizer st;
	static int N, M;
	static int[][] map;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		Queue<int[]> queue = new LinkedList<>();
		int answer, count, last = 0;

		for (int n = 0;; n++) {
			count = 0;
			boolean[][] visit = new boolean[N][M];
			visit[0][0] = true;
			queue.add(new int[] { 0, 0 });

			while (!queue.isEmpty()) {
				int[] now = queue.poll();
				int x = now[0];
				int y = now[1];
				
				for(int i=0; i < 4; i++) {
					int nX = x+delta[i][0];
					int nY = y+delta[i][1];
					
					if(isIn(nX,nY) && !visit[nX][nY]) {
						if(map[nX][nY] == 0) {
							visit[nX][nY] = true;
							queue.offer(new int[] {nX,nY});
						}else {
							map[nX][nY] = 0;
							count ++;
							visit[nX][nY] = true;
						}
					}
				}
				

			}
			if (count == 0) {
				answer = n;
				break;
			}
			last = count;
		}

		System.out.println(answer);
		System.out.println(last);
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < M) {
			return true;
		}
		return false;
	}
}
