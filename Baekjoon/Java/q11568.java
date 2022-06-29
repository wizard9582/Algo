package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q11568 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] map = new int[N + 1];

		for (int n = 1; n <= N; n++) {
			map[n] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N + 1];

		for (int n = 1; n <= N; n++) {
			int length = 0;
			
			for (int m = 0; m < n; m++) {
				if (map[n] > map[m]) {
					length = Math.max(length, dp[m]);
				}
			}
			dp[n] = length +1;
		}

		int Max = 0;
		for (int n = 1; n <= N; n++) {
			if (dp[n] > Max) {
				Max = dp[n];
			}
		}

		System.out.println(Max);
	}
}