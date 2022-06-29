package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q12865 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[N+1][K+1];
		
		for(int n = 1 ; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			
			for(int k = 0 ; k <= K; k++) {
				if(k < weight) {
					dp[n][k] = dp[n-1][k];
				}else {
					dp[n][k] = Math.max(dp[n-1][k], dp[n-1][k-weight] + value);
				}
			}
		}
		
		System.out.println(dp[N][K]);
	}
}

 