package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1034_BOJ_램프 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] map = new boolean[N][M];
		String[] input = new String[N];
		int answer = 0;

		for (int n = 0; n < N; n++) {
			input[n] = br.readLine();
			for (int m = 0; m < M; m++) {
				if (input[n].charAt(m) == '1') {
					map[n][m] = true;
				}
			}
		}

		int K = Integer.parseInt(br.readLine());
		boolean[] canLight = new boolean[N];

		for (int n = 0; n < N; n++) {
			int count = 0;
			for (int m = 0; m < M; m++) {
				if (!map[n][m]) {
					count++;
				}
			}
			if ((count % 2 == K % 2) && count <= K) {
				canLight[n] = true;
			}
		}

		for (int n = 0; n < N; n++) {
			int count = 0;
			if (canLight[n]) {

				for (int n2 = n; n2 < N; n2++) {
					if (input[n].equals(input[n2])) {
						count++;
						canLight[n2] = false;
					}
				}
			}
			answer = Math.max(answer, count);
		}

		System.out.println(answer);
	}
}
