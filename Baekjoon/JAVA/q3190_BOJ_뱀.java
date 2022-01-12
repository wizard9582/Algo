package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q3190_BOJ_뱀 {
	static StringTokenizer st;
	static int[][] delta = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int[][] map;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int K = Integer.parseInt(br.readLine());
		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;

			map[r][c] = 1;
		}
		int L = Integer.parseInt(br.readLine());
		int[][] order = new int[L][2];
		for (int l = 0; l < L; l++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			char dir = st.nextToken().charAt(0);
			order[l][0] = time;
			order[l][1] = dir == 'L' ? -1 : 1;
		}

		int time = 0, idx = 0, dir = 0;
		Queue<point> queue = new LinkedList<>();
		queue.offer(new point(0, 0));
		point head = new point(0, 0);
		map[0][0] = -1;

		while (!queue.isEmpty()) {
			time++;
			head.x += delta[dir][0];
			head.y += delta[dir][1];

			if (!isIn(head.x, head.y) || map[head.x][head.y] == -1) {
				break;
			}

			if (map[head.x][head.y] != 1) {
				point tail = queue.poll();
				map[tail.x][tail.y] = 0;
			}
			map[head.x][head.y] = -1;
			queue.offer(new point(head.x, head.y));

			if (idx < L && order[idx][0] == time) {
				dir = dir + order[idx][1];
				dir = dir == -1 ? 3 : dir % 4;
				idx++;
			}
		}

		System.out.println(time);
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < N) {
			return true;
		}
		return false;
	}

	static class point {
		int x, y;

		point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
