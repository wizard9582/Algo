package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q9465_BOJ_스티커 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] num = new int[2][N];
			int[][] dp = new int[3][N];
			
			st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++) {
				num[0][n] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++) {
				num[1][n] = Integer.parseInt(st.nextToken());
			}
			
			dp[0][0] = num[0][0];
			dp[1][0] = num[1][0];
			dp[2][0] = 0;
			
			for(int n = 1; n < N; n++) {
				dp[0][n] = Math.max(dp[1][n-1] + num[0][n], dp[2][n-1] + num[0][n]);
				dp[1][n] = Math.max(dp[0][n-1] + num[1][n], dp[2][n-1] + num[1][n]);
				dp[2][n] = Math.max(dp[0][n-1], dp[1][n-1]);
			}
			sb.append(Math.max(dp[0][N-1], dp[1][N-1])).append("\n");
		}
		
		System.out.println(sb);
	}
}
