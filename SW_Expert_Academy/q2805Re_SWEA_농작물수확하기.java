package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q2805Re_SWEA_농작물수확하기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		String str, sum;

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int answer = 0;

			for (int i = 0; i < N; i++) {
				str = br.readLine();
				if (i < N / 2) {
					sum = str.substring(N / 2 - i, N / 2 + i + 1);
				} else {
					sum = str.substring(i - N / 2, N / 2 + N - i);
				}
				for (int j = 0; j < sum.length(); j++) {
					answer += sum.charAt(j) - '0';
				}
			}
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
