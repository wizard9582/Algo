package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		String str;

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int answer = 0;

			for (int i = 0; i < N; i++) {
				str = br.readLine();
				if (i == N / 2) {
					for (int j = 0; j < str.length(); j++) {
						answer += str.charAt(j) - '0';
					}
					continue;
				}
				if (i < N / 2) {
					for (int j = N / 2 - i; j <= N / 2 + i; j++) {
						answer += str.charAt(j) - '0';
					}
				}
				else {
					for (int j = i - N/2 ; j <= N/2 + N - i -1; j++) {
						answer += str.charAt(j) - '0';
					}
				}
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
