package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2578 {
	static StringTokenizer st;
	static int[][] bingo;
	static boolean[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bingo = new int[26][2];
		map = new boolean[5][5];

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				int n = Integer.parseInt(st.nextToken());
				bingo[n][0] = i;
				bingo[n][1] = j;
			}
		}

		loop : for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 5; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[bingo[n][0]][bingo[n][1]] = true;
				if (3 <= check()) {
					System.out.println(i * 5 + j);
					break loop;
				}
			}
		}

	}

	static int check() {
		int count = 0;
		for (int i = 0, j = 0; i < 5; i++, j++) {
			if (!map[i][j]) {
				break;
			}
			if (i == 4 && j == 4) {
				count ++;
			}
		}

		for (int i = 0, j = 4; i < 5; i++, j--) {
			if (!map[i][j]) {
				break;
			}
			if (i == 4 && j == 0) {
				count ++;
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (!map[i][j]) {
					break;
				}
				if (j == 4) {
					count ++;
				}
			}
		}
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (!map[j][i]) {
					break;
				}
				if (j == 4) {
					count ++;
				}
			}
		}

		return count;
	}
}
