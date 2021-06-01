package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q17836_BOJ_공주님을구해라 {
	static StringTokenizer st;
	static int N, M;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int answer = -1;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		boolean[][][] visited = new boolean[N][M][2];
		int[][] map = new int[N][M];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<Brave> queue = new LinkedList<>();
		visited[0][0][0] = true;
		queue.offer(new Brave(0, 0, 0));
		int time = 0;

		loop: while (!queue.isEmpty()) {
			int size = queue.size();

			while (size-- > 0) {
				Brave now = queue.poll();
				int sword = now.sword;
				//System.out.printf("위치 : %d,%d , 검 : %d, 시간 : %d \n", now.x, now.y, sword, time);

				if (now.x == N - 1 && now.y == M - 1) {
					answer = time;
					break loop;
				}

				for (int i = 0; i < 4; i++) {
					int nX = now.x + delta[i][0];
					int nY = now.y + delta[i][1];

					if (isIn(nX, nY) && !visited[nX][nY][sword] && (map[nX][nY] != 1 || sword == 1)) {
						visited[nX][nY][sword] = true;
						if(sword == 1) {
							queue.offer(new Brave(nX, nY, 1));
						}else {
							queue.offer(new Brave(nX, nY, (map[nX][nY] == 2) ? 1 : 0));
						}
					}
				}
			}

			time++;
			if (time > T) {
				break;
			}
		}

		if (answer == -1) {
			System.out.println("Fail");
		} else {
			System.out.println(answer);
		}
	}

	static class Brave {
		int x, y;
		int sword;

		public Brave(int x, int y, int sword) {
			this.x = x;
			this.y = y;
			this.sword = sword;
		}
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < M) {
			return true;
		}
		return false;
	}
}
