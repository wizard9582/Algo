package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2116 {
	static StringTokenizer st;
	static int[][] dice;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		dice = new int[N][6];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 6; i++) {
				dice[n][i] = Integer.parseInt(st.nextToken());
			}
		}

		int answer = 0;

		for (int i = 0; i < 6; i++) {
			int sum = 0, below = dice[0][i], top = 0;

			for (int n = 0; n < N; n++) {

				top = findTop(n,below);
				sum += findMax(n, below, top);
				below = top;
			}

			answer = Math.max(answer, sum);
		}
		System.out.println(answer);
	}

	static int findTop(int n, int below) {
		int top = 0;
		for (int i = 0; i < 6; i++) {
			if(dice[n][i] == below) {
				switch (i) {
				case 0:
					top = 5;
					break;
				case 1:
					top = 3;
					break;
				case 2:
					top = 4;
					break;
				case 3:
					top = 1;
					break;
				case 4:
					top = 2;
					break;
				case 5:
					top = 0;
					break;
				}
				break;
			}
		}
		return dice[n][top];
	}

	static int findMax(int n, int below, int top) {
		int max = 0;

		for (int i = 0; i < 6; i++) {
			if (dice[n][i] != below && dice[n][i] != top) {
				max = Math.max(max, dice[n][i]);
			}
		}

		return max;
	}
}
