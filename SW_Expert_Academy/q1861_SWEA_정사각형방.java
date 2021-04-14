package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class q1861_SWEA_정사각형방 {
	static int[][] room;
	static int[] move;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int answer;
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			answer = N * N;
			room = new int[N][N];
			move = new int[N * N + 1];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					room[i][j] = Integer.parseInt(st.nextToken());
					if (room[i][j] == N * N) {
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					move[room[i][j]] = search(i, j);
				}
			}
			for (int i = N * N; i > 0; i--) {
				if (move[i] >= move[answer]) {
					answer = i;
				}
			}
			sb.append("#").append(tc).append(" ").append(answer).append(" ").append(move[answer]).append("\n");
		}
		System.out.println(sb);
	}

	static int search(int x, int y) {
		int num = room[x][y];
		int canMove = 1;
		if (move[num] != 0) {
			return move[num];
		}
		if (isIn(x - 1, y) && room[x - 1][y] - 1 == num) {
			canMove = search(x - 1, y);
			return canMove + 1;
		}
		if (isIn(x, y - 1) && room[x][y - 1] - 1 == num) {
			canMove = search(x, y - 1);
			return canMove + 1;
		}
		if (isIn(x + 1, y) && room[x + 1][y] - 1 == num) {
			canMove = search(x + 1, y);
			return canMove + 1;
		}
		if (isIn(x, y + 1) && room[x][y + 1] - 1 == num) {
			canMove = search(x, y + 1);
			return canMove + 1;
		}
		if (move[num] == 0) {
			move[num] = canMove;
		}
		return canMove;
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < N) {
			return true;
		}
		return false;
	}
}
