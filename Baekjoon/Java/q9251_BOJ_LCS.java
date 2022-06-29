package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class q9251_BOJ_LCS {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		int l1 = str1.length();
		String str2 = br.readLine();
		int l2 = str2.length();
		
		int[][] dp = new int[l2+1][l1+1];
		
		for(int i = 1; i <= l2; i++) {
			char C = str2.charAt(i-1);
			for(int j = 1; j <= l1; j++) {
				if(C == str1.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		
		
		
		System.out.println(dp[l2][l1]);
	}
}
