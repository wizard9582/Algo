package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2740_BOJ_행렬곱셈 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] mat1 = new int[N][M];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				mat1[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] mat2 = new int[M][K];

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < K; k++) {
				mat2[m][k] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] answer = new int[N][K];
		for (int n = 0; n < N; n++) {
			for (int k = 0; k < K; k++) {
				int sum = 0;
				for (int m = 0; m < M; m++) {
					sum += mat1[n][m] * mat2[m][k];
				}
				answer[n][k] = sum;
			}
		}

		for (int n = 0; n < N; n++) {
			for (int k = 0; k < K; k++) {
				sb.append(answer[n][k]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}