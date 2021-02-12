package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q16926 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				arr[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		int depth = Math.min(N, M) / 2;
		int round;

		for (int i = 0; i < depth; i++) {
			round = R % (2 * ((N - 2 * i) + (M - 2 * i)) - 4);

			for (int r = 0; r < round; r++) {

				int temp = arr[i][i];
				for (int a = i; a < M - 1 - i; a++) {
					arr[i][a] = arr[i][a + 1];
				}
				for (int a = i; a < N - 1 - i; a++) {
					arr[a][M - 1 - i] = arr[a + 1][M - 1 - i];
				}
				for (int a = M - 1 - i; a > i; a--) {
					arr[N - 1 - i][a] = arr[N - 1 - i][a - 1];
				}
				for (int a = N - 1 - i; a > i; a--) {
					arr[a][i] = arr[a - 1][i];
				}
				arr[i + 1][i] = temp;
			}
		}

		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				sb.append(arr[n][m]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
