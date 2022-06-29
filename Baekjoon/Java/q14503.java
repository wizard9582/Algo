package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q14503 {
	static StringTokenizer st;
	static int[][] map;
	static int[][] delta = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Queue<int[]> queue = new LinkedList<>();
		map = new int[N][M];

		st = new StringTokenizer(br.readLine());
		queue.offer(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		loop : while (!queue.isEmpty()) {
			int[] now = queue.poll();

			int x = now[0];
			int y = now[1];
			int dir = now[2];


			if (map[x][y] == 0) {
				map[x][y] = 2;
			}

			for (int i = 0; i < 5; i++) {
				if(i == 4) {
					i = 0;
					int nX = x - delta[dir][0];
					int nY = y - delta[dir][1];
					if(isIn(nX,nY) && map[nX][nY]!=1) {
						x = nX;
						y = nY;
					}else {
						break loop;
					}
				}
				
				if (dir == 0) {
					dir = 3;
				} else {
					dir--;
				}

				int nX = x + delta[dir][0];
				int nY = y + delta[dir][1];

				if (isIn(nX, nY) && map[nX][nY] == 0) {
					queue.offer(new int[] { nX, nY, dir });
					break;
				}
			}

		}
		
		int count = 0;
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if(map[n][m] == 2) {
					count ++;
				}
			}
		}
		System.out.println(count);
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < M) {
			return true;
		}

		return false;
	}
}
