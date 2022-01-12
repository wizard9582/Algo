package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q16395_BOJ_파스칼의삼각형 {
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long[][] pascal = new long[N][K];
		pascal[0][0] = 1;
		for (int n = 1; n < N; n++) {
			pascal[n][0] = 1;
			for (int k = 1; k < K; k++) {
				pascal[n][k] = (pascal[n - 1][k - 1] + pascal[n - 1][k]);
			}
		}
		
		System.out.println(pascal[N-1][K-1]);
	}
}
