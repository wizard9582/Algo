package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q1946_BOJ_신입사원 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] applicants = new int[N][2];

			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				applicants[n][0] = Integer.parseInt(st.nextToken());
				applicants[n][1] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(applicants, (e1, e2) -> {
				return e1[0] - e2[0];
			});

			int answer = 1;
			int minRanking = applicants[0][1];

			for (int n = 1; n < N; n++) {
				if (applicants[n][1] < minRanking) {
					answer++;
					minRanking = applicants[n][1];
				}
			}
			sb.append(answer).append("\n");
		}

		System.out.println(sb);
	}
}
