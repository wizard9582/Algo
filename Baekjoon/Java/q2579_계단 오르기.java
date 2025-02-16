package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q2579 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] stair = new int[N+1];

		for (int n = 0; n < N; n++) {
			stair[n+1] = Integer.parseInt(br.readLine());
		}

		int[] dp = new int[N + 1];
		
		dp[1] = stair[1];
		
		if(N > 1) {
			dp[2] = dp[1] + stair[2];
		}
		
		for(int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i-2], dp[i-3] + stair[i-1]) + stair[i];
		}
		

		System.out.println(dp[N]);
	}
}