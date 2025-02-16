package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class q17135 {
	static StringTokenizer st;
	static int[][] map, test, delta = { { 0, -1 }, { -1, 0 }, { 0, 1 } };
	static boolean[][] visit;
	static int N, M, D, answer = 0;
	static Queue<int[]> queue = new LinkedList<>();
	static Stack<int[]> stack = new Stack<>();
	static boolean flag = false;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		map = new int[N + 1][M];

		Arrays.fill(map[N], -1);

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i =0; i<M; i++) {
			for(int j = i+1; j<M; j++) {
				for(int k =j+1; k<M; k++) {
					answer = Math.max(answer, simulation(new int[] {i,j,k}));
				}
			}
		}

		System.out.println(answer);
	}

	static int simulation(int[] Archer) {
		int killCount = 0;
		test = copy(map);

		for (int n = 0; n < N; n++) {
			for (int i = 0; i < 3; i++) {
				flag = false;
				visit = new boolean[N + 1][M];
				queue.offer(new int[] { N, Archer[i] });
				while (!flag && !queue.isEmpty()) {
					aim(queue.poll(), Archer[i]);
				}
				queue.clear();
			}
			while (!stack.isEmpty()) {
				int[] x = stack.pop();

				if (test[x[0]][x[1]] == 1) {
					test[x[0]][x[1]] = 0;
					killCount++;
				}
			}
			nextTurn();
		}

		return killCount;
	}

	static void aim(int[] target, int archer) {
		int x = target[0];
		int y = target[1];

		if (Math.abs(N - x) + Math.abs(archer - y) > D) {
			return;
		}

		visit[x][y] = true;
		if (flag) {
			return;
		} else if (test[x][y] == 1) {
			flag = true;
			stack.push(new int[] { x, y });
			return;
		}

		for (int i = 0; i < 3; i++) {
			int nX = x + delta[i][0];
			int nY = y + delta[i][1];
			if (isIn(nX, nY) && !visit[nX][nY]) {
				queue.offer(new int[] { nX, nY });
			}
		}
	}

	static void nextTurn() {

		for (int n = N - 1; n > 0; n--) {
			test[n] = test[n - 1];
		}
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < M) {
			return true;
		}

		return false;
	}

	static int[][] copy(int[][] original) {
		int[][] clone = new int[N + 1][M];
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j < M; j++) {
				clone[i][j] = original[i][j];
			}
		}

		return clone;
	}
}
