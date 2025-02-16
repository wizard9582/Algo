package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1946_BOJ_신입사원Re {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] applicants = new int[N];

			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				applicants[Integer.parseInt(st.nextToken())-1] = Integer.parseInt(st.nextToken());
			}

			int answer = 1;
			int minRanking = applicants[0];

			for (int n = 1; n < N; n++) {
				if (applicants[n] < minRanking) {
					answer++;
					minRanking = applicants[n];
				}
			}
			sb.append(answer).append("\n");
		}

		System.out.println(sb);
	}
}
