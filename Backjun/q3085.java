package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q3085 {
	static char[][] candy;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer = 0;

		N = Integer.parseInt(br.readLine());

		candy = new char[N][N];

		for (int n = 0; n < N; n++) {
			String str = br.readLine();
			for (int m = 0; m < N; m++) {
				candy[n][m] = str.charAt(m);
			}
		}
		
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < N; m++) {
				char temp = candy[n][m];

				int nX = n + 1;
				int nY = m;
				if (isIn(nX, nY) && candy[n][m]!=candy[nX][nY]) {
					candy[n][m] = candy[nX][nY];
					candy[nX][nY] = temp;
					answer = Math.max(answer, Counting());
					candy[nX][nY] = candy[n][m];
					candy[n][m] = temp;
				}

				nX = n;
				nY = m + 1;
				if (isIn(nX, nY) && candy[n][m]!=candy[nX][nY]) {
					candy[n][m] = candy[nX][nY];
					candy[nX][nY] = temp;
					answer = Math.max(answer, Counting());
					candy[nX][nY] = candy[n][m];
					candy[n][m] = temp;
				}
			}
		}

		System.out.println(answer);
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < N) {
			return true;
		}
		return false;
	}
	
	static int Counting() {
		int count = 0;
		int Maxcount = 0;

		for (int i = 0; i < N; i++) {
			char c = '0';
			for (int j = 0; j < N; j++) {
			if (candy[j][i] != c) {
				Maxcount = Math.max(count, Maxcount);
				count = 1;
				c = candy[j][i];
			} else {
				count++;
			}
		}
		Maxcount = Math.max(count, Maxcount);
		}
		for (int i = 0; i < N; i++) {
			char c = '0';
			for (int j = 0; j < N; j++) {
			if (candy[i][j] != c) {
				Maxcount = Math.max(count, Maxcount);
				count = 1;
				c = candy[i][j];
			} else {
				count++;
			}
		}
		Maxcount = Math.max(count, Maxcount);
		}

		return Maxcount;
	}
}
