package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q9252_BOJ_LCS3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		char[] str1 = br.readLine().toCharArray();
		int l1 = str1.length;
		char[] str2 = br.readLine().toCharArray();
		int l2 = str2.length;
		char[] str3 = br.readLine().toCharArray();
		int l3 = str3.length;

		int[][][] dp = new int[l3 + 1][l2 + 1][l1 + 1];

		for (int i = 1; i <= l3; i++) {
			char c3 = str3[i - 1];
			
			for (int j = 1; j <= l2; j++) {
				char c2 = str2[j - 1];
				
				for (int k = 1; k <= l1; k++) {
					if (c3 == c2 && c2 == str1[k - 1]) {
						dp[i][j][k] = dp[i - 1][j - 1][k - 1] + 1;
					} else {
						dp[i][j][k] = Math.max(dp[i][j][k - 1], Math.max(dp[i - 1][j][k], dp[i][j - 1][k]));
					}
				}
			}
		}
		System.out.println(dp[l3][l2][l1]);
	}
}
