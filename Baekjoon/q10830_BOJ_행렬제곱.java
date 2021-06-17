package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q10830_BOJ_행렬제곱 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static final int mod = 1000;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		int[][] mat = new int[N][N];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < N; m++) {
				mat[n][m] = Integer.parseInt(st.nextToken()) % mod;
			}
		}

		int[][] answer = powMatrix(B, mat);

		for (int n = 0; n < N; n++) {
			for (int m = 0; m < N; m++) {
				sb.append(answer[n][m]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static int[][] powMatrix(long b, int[][] mat) {
		int[][] result = new int[N][N];

		if (b == 0) {
			for (int n = 0; n < N; n++) {
				result[n][n] = 1;
			}
			return result;
		} else if (b == 1) {
			return mat;
		} else {
			result = powMatrix(b / 2, mat);
			result = multiMaxrix(result, result);
			if (b % 2 == 1) {
				result = multiMaxrix(result, mat);
			}
		}

		return result;
	}

	static int[][] multiMaxrix(int[][] mat1, int[][] mat2) {
		int[][] result = new int[N][N];
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < N; m++) {
				int sum = 0;
				for (int k = 0; k < N; k++) {
					sum += mat1[n][k] * mat2[k][m];
				}
				result[n][m] = sum % mod;
			}
		}

		return result;
	}
}