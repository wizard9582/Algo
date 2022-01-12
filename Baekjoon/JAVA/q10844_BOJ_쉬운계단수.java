package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q10844_BOJ_쉬운계단수 {
	static StringTokenizer st;
	static int mod = 1_000_000_000;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		long[][] dp = new long[N+1][11];
		
		for(int i = 1; i <= 9 ; i ++) {
			dp[1][i] = 1;
		}
		for(int j = 0; j <= 9 ; j ++) {
			dp[1][10] += dp[1][j];
		}
		
		for(int n = 2; n <= N; n++) {
			
			dp[n][0] = dp[n-1][1] % mod;
			
			for(int i = 1; i < 9 ; i ++) {
				dp[n][i] = (dp[n-1][i-1] + dp[n-1][i+1]) % mod;
			}
			
			dp[n][9] = dp[n-1][8] % mod;
			
			for(int j = 0; j <= 9 ; j ++) {
				dp[n][10] = (dp[n][10] + dp[n][j])%mod;
			}
		}
		
		System.out.println(dp[N][10]);
		
	}
}
