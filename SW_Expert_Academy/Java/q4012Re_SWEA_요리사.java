package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q4012Re_SWEA_요리사 {
	static int[][] food;
	static int half, N, result, totalCount, maxCount;
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			food = new int[N + 1][N + 1];
			half = N / 2;
			result = Integer.MAX_VALUE;
			totalCount = 0;
			maxCount = 1;
			
			for (int i = N; i > half; i--) {
				maxCount *= i;
			}
			for (int i = half; i > 1; i--) {
				maxCount /= i;
			}
			maxCount /= 2;

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					food[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			Combination(0, 1, new boolean[N + 1]);

			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}

		System.out.println(sb);
	}

	static void Combination(int count, int start, boolean[] use) {
		if (count == half && totalCount < maxCount) {
			int[] A = new int[half];
			int[] B = new int[half];
			for (int i = 1, j = 0, k = 0; i <= N; i++) {
				if (use[i]) {
					A[j] = i;
					j++;
				} else {
					B[k] = i;
					k++;
				}
			}
			result = Math.min(result, cook(A, B));
			totalCount++;
			return;
		}

		for (int i = start; i <= N; i++) {
			use[i] = true;
			Combination(count + 1, i + 1, use);
			use[i] = false;
		}
	}

	static int cook(int[] A, int[] B) {
		int answer = 0, cookA = 0, cookB = 0;

		for (int i = 0; i < A.length; i++) {
			for (int j = i + 1; j < A.length; j++) {
				cookA += food[A[i]][A[j]];
				cookA += food[A[j]][A[i]];
			}
		}

		for (int i = 0; i < B.length; i++) {
			for (int j = i + 1; j < B.length; j++) {
				cookB += food[B[i]][B[j]];
				cookB += food[B[j]][B[i]];
			}
		}
		answer = Math.abs(cookA - cookB);
		return answer;
	}
}
