package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1932 {
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[][] dp = new int[N][N];
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m <= n; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int m = 0; m < N; m++) {
			dp[N-1][m] = map[N-1][m];
		}
		
		for(int n = N-2; n >= 0; n--) {
			for(int m = 0; m <= n; m++) {
				dp[n][m] = map[n][m] + Math.max(dp[n+1][m], dp[n+1][m+1]);
			}
		}
		
		System.out.println(dp[0][0]);
	}
}
