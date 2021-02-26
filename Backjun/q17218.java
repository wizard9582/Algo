package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q17218 {
	static int Max = 0, A,B;
	static StringBuilder sb = new StringBuilder();
	static String str1,str2;
	static int[][] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		str1 = "0" + br.readLine();
		str2 = "0" + br.readLine();
		A = str1.length()-1;
		B = str2.length()-1;
		
		dp = new int[A+1][B+1];
		
		char c = str1.charAt(0);
		
		for(int i = 1; i <= A; i++) {
			c = str1.charAt(i);
			if(c == str2.charAt(0)) {
				dp[i][0] = 1;
			}
			for(int j = 1; j <= B; j++) {
				if(c == str2.charAt(j)) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		backFind(A, B);
		System.out.println(sb);
	}
	
	static void backFind(int i, int j) {
		if (i == 0 || j == 0)
			return;
		if (str1.charAt(i) == str2.charAt(j)) {
			backFind(i - 1, j - 1);
			sb.append(str1.charAt(i));
		}
		else {
			if (dp[i][j - 1] == dp[i][j]) {
				backFind(i, j - 1);
		}
			else {
				backFind(i - 1, j);
			}
		}
	}
}
