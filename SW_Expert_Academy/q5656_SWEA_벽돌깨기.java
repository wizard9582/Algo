package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q5656_SWEA_벽돌깨기 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int answer, N, W, H;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			answer = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new int[H][W];
			for (int h = 0; h < H; h++) {
				st = new StringTokenizer(br.readLine());
				for (int w = 0; w < W; w++) {
					map[h][w] = Integer.parseInt(st.nextToken());
				}
			}

			dfs(0);

			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}

		System.out.println(sb);
	}

	static void dfs(int count) {
		if (count == N) {
			answer = Math.min(answer, countBlock(map));
			return;
		}
		int[][] save = new int[H][W];
		for (int w = 0; w < W; w++) {		
			copy(map, save);				
			shoot(w);
			dfs(count + 1);
			copy(save, map);

		}
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < H && 0 <= y && y < W) {
			return true;
		}

		return false;
	}

	static void copy(int[][] from, int[][] to) {
		for (int h = 0; h < H; h++) {
			to[h] = from[h].clone(); 
		}
	}

	static int countBlock(int[][] result) {
		int count = 0;
		for (int h = 0; h < H; h++) {
			for (int w = 0; w < W; w++) {
				if (result[h][w] != 0) {
					count++;
				}
			}
		}
		return count;
	}

	static void shoot(int w) {			
		for (int h = 0; h < H; h++) {	
			if (map[h][w] != 0) {		
				boom(h, w);
				return;
			}
		}
		return;
	}

	static void boom(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { x, y, map[x][y]-1 });
		map[x][y] = 0;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int range = now[2];

			for (int i = 0; i < 4; i++) {
				int nX = now[0];
				int nY = now[1];
				for (int r = 0; r < range; r++) {
					nX += delta[i][0];
					nY += delta[i][1];
					if (isIn(nX, nY) && map[nX][nY] != 0) {
						queue.offer(new int[] { nX, nY, map[nX][nY]-1 });
						map[nX][nY] = 0;
					}
				}
			}
		}

		gravity();
	}

	static void gravity() {
		Queue<Integer> queue;

		for (int w = 0; w < W; ++w) {   //  0 000001000300201 <-H -> 1,2,3,1
			queue = new LinkedList<>();	//    000000000001321

			for (int h = H - 1; h >= 0; --h) {
				if (map[h][w] > 0) {
					queue.offer(map[h][w]);
				}
			}

			for (int h = H - 1; h >= 0; --h) {
				if (!queue.isEmpty()) {
					map[h][w] = queue.poll();
				} else {
					map[h][w] = 0;
				}
			}
		}

	}
}
