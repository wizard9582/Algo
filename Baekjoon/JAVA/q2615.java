package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2615 {
	static StringTokenizer st;
	static int[][] go = new int[19][19];
	static int[][] delta = { { 0, 1 }, { 1, 0 }, { 1, 1 }, { -1, 1 } };
	static int win = 0;
	static int[] answer = new int[2];
	static boolean flag = false;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 19; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 19; j++) {
				go[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 19; i++) {
			Search(0, i, 0);
			Search(1, 0, i);
			Search(2, 0, i);
			Search(2, i, 0);
			Search(3, 18, i);
			Search(3, i, 0);
			if (flag)
				break;
		}

		System.out.println(win);
		if (win != 0) {
			System.out.println(answer[0] + " " + answer[1]);
		}
	}

	static void Search(int dir, int i, int j) {
		int dol = 0;
		int count = 1;
		int x = 0, y = 0;

		while (isIn(i, j)) {
			if (dol != 0 && dol == go[i][j]) {
				count++;
			} else {
				dol = go[i][j];
				count = 1;
				x = i;
				y = j;

			}

			i += delta[dir][0];
			j += delta[dir][1];

			if (count == 5) {
				if (isIn(i, j) && dol != go[i][j]) {
					flag = true;
					win = dol;
					answer[0] = x + 1;
					answer[1] = y + 1;
					return;
				} else if (!isIn(i, j)) {
					flag = true;
					win = dol;
					answer[0] = x + 1;
					answer[1] = y + 1;
					return;
				}
			}

		}
	}

	static boolean isIn(int x, int y) {

		if (x < 0 || y < 0 || 18 < x || 18 < y) {
			return false;
		}

		return true;
	}
}
