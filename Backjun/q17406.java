package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q17406 {
	static int answer = Integer.MAX_VALUE;
	static int N, M, K;
	static int[][] arrSave, rotate;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arrSave = new int[N][M];
		rotate = new int[K][3];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				arrSave[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			rotate[k][0] = Integer.parseInt(st.nextToken()) - 1;
			rotate[k][1] = Integer.parseInt(st.nextToken()) - 1;
			rotate[k][2] = Integer.parseInt(st.nextToken());

		}

		makePermutation(K, new int[K], new boolean[K]);

		System.out.println(answer);
	}

	static void makePermutation(int toChoose, int[] choosed, boolean[] visited) {
		if (toChoose == 0) {
			calcul(choosed);
			return;
		}
		for (int i = 0; i < K; i++) {
			if (!visited[i]) {
				visited[i] = true;
				choosed[K - toChoose] = i;
				makePermutation(toChoose - 1, choosed, visited);
				visited[i] = false;
			}
		}
	}

	static void calcul(int[] choosed) {

		int[][] arr = new int[N][M];

		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				arr[n][m] = arrSave[n][m];
			}
		}
		for (int j = 0; j < K; j++) {
			int r = rotate[choosed[j]][0];
			int c = rotate[choosed[j]][1];
			int s = rotate[choosed[j]][2];

			for (int i = 1; i <= s; i++) {

				int x = r - i;
				int y = c - i;

				int temp = arr[x][y];

				for (int a = 0; a < i * 2; a++) {
					arr[x + a][y] = arr[x + a + 1][y];
				}
				for (int a = 0; a < i * 2; a++) {
					arr[x + 2 * i][y + a] = arr[x + 2 * i][y + a + 1];
				}
				for (int a = 0; a < i * 2; a++) {
					arr[x + 2 * i - a][y + 2 * i] = arr[x + 2 * i - a - 1][y + 2 * i];
				}
				for (int a = 0; a < i * 2 - 1; a++) {
					arr[x][y + 2 * i - a] = arr[x][y + 2 * i - a - 1];
				}

				arr[x][y + 1] = temp;
			}
		}

		for (int n = 0; n < N; n++) {
			int sum = 0;
			for (int m = 0; m < M; m++) {
				sum += arr[n][m];
			}
			answer = Math.min(answer, sum);
		}
	}
}
