package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q15661_BOJ_링크와스타트 {
	static StringTokenizer st;
	static int[][] point;
	static int answer = Integer.MAX_VALUE;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		point = new int[N][N];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < N; m++) {
				point[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		boolean[] picked = new boolean[N];
		picked[0] = true;

		match(1, picked, 1);

		System.out.println(answer);
	}

	static void match(int idx, boolean[] picked, int check) {
		if (idx == N) {
			if(check == N) {
				return;
			}
			int a = calcul(true, picked);
			int b = calcul(false, picked);
			answer = Math.min(answer, Math.abs(a - b));
			return;
		}
		picked[idx] = true;
		match(idx + 1, picked, check+1);
		picked[idx] = false;
		match(idx + 1, picked, check);
		
	}

	static int calcul(boolean flag, boolean[] picked) {
		int sum = 0;

		for (int n = 0; n < N; n++) {
			if (picked[n] == flag) {
				for (int m = 0; m < N; m++) {
					if (picked[m] == flag) {
						sum += point[n][m];
					}
				}
			}
		}

		return sum;
	}
}
