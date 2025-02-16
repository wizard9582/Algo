package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q15922_BOJ_아우으우아으이야 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		int start = -1_000_000_001;
		int end = -1_000_000_001;

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int startN = Integer.parseInt(st.nextToken());
			int endN = Integer.parseInt(st.nextToken());

			if (startN > end) {
				answer += (end - start);
				start = startN;
				end = endN;
			} else {
				end = Math.max(end, endN);
			}
		}
		answer += (end - start);
		
		System.out.println(answer);
	}
}
