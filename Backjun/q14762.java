package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q14762{
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static long[][] pascal;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		pascal = new long[51][51];
		
		for(int n =0; n<51; n++) {
			pascal[n][0] = 1;
		}
		
		for(int m =1; m< 51; m++) {
			for(int n = m; n< 51; n++) {
				pascal[n][m] = (long)pascal[n-1][m-1] + (long)pascal[n-1][m];
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			double win = Double.parseDouble(st.nextToken()) / 100;
			int remain = v - v1 - v2;
			
			double myWin = countWin(remain, ((v/2) + 1) - v1);
			
			if(myWin == 0d) {
				sb.append("RECOUNT!\n");
			}else if(myWin > win) {
				sb.append("GET A CRATE OF CHAMPAGNE FROM THE BASEMENT!\n");
			}else {
				sb.append("PATIENCE, EVERYONE!\n");
			}
			
		}
		
		System.out.println(sb);
	}
	
	static double countWin(int remain, int win) {
		if(remain < win) {
			return 0d; // 승률 0%
		}
		if(win <= 0) {
			return 1d; // 승률 100%
		}
		
		long canWin = 0;
		for(int i = win; i <= remain; i++) {
			canWin += pascal[remain][i];
		}
		return canWin / Math.pow(2, remain);
		// 조합의 갯수 / 2^남은갯수
	}
}