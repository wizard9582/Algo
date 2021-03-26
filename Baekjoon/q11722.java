package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q11722 {
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		int[] num = new int[N + 1];
		int[] dp = new int[N + 1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int n = N; n > 0; n--) {
			num[n] = Integer.parseInt(st.nextToken());
		}
		
		for (int n = 1; n <= N; n++) {
			int inc = 0;
			for (int i = 0; i < n; i++) {
				if (num[i] < num[n]) {
					inc = Math.max(inc, dp[i]);
				}
				dp[n] = inc + 1;
			}
			answer = Math.max(answer, dp[n]);
		}
		
		System.out.println(answer);
	}
}
