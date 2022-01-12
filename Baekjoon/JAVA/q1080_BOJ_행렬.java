package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1080_BOJ_행렬 {
	static StringTokenizer st;
	static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] arrA = new int[N][M];
		int[][] arrB = new int[N][M];
		
		for (int n = 0; n < N; n++) {
			String input = br.readLine();
			for (int m = 0; m < M; m++) {
				arrA[n][m] = input.charAt(m) - '0'; 
			}
		}
		
		for (int n = 0; n < N; n++) {
			String input = br.readLine();
			for (int m = 0; m < M; m++) {
				arrB[n][m] = input.charAt(m) - '0'; 
			}
		}
		

		int answer = 0;

		if (N < 3 || M < 3) {

			answer = compareArr(arrA, arrB) ? 0 : -1;

		} else {

			int count = 0;

			for (int n = 0; n <= N - 3; n++) {
				for (int m = 0; m <= M - 3; m++) {
					if (arrA[n][m] != arrB[n][m]) {
						count++;

						for (int i = n; i < n + 3; i++) {
							for (int j = m; j < m + 3; j++) {
								arrA[i][j] = (arrA[i][j] == 1) ? 0 : 1;
							}
						}

					}
				}
			}

			answer = compareArr(arrA, arrB) ? count : -1;
		}

		System.out.println(answer);
	}

	static boolean compareArr(int[][] a, int[][] b) {

		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (a[n][m] != b[n][m]) {
					return false;
				}
			}
		}

		return true;
	}
}
