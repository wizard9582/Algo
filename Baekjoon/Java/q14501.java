package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q14501 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] day = new int[N + 2][2];

		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			day[n][0] = Integer.parseInt(st.nextToken());
			day[n][1] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N + 2];
		int answer = -1;
		for (int n = N; n > 0; n--) {

			if (n + day[n][0] < N+2) {
				dp[n] = Math.max(dp[n + day[n][0]] + day[n][1], dp[n+1]);
			}else {
				dp[n] = dp[n+1];
			}
			answer = Math.max(dp[n], answer);
		}
		
		System.out.println(answer);
	}
}
