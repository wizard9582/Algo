package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q15489_BOJ_파스칼의삼각형 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		long[][] pascal = new long[R + W][C + W];
		pascal[0][0] = 1;
		for (int r = 1; r < R + W; r++) {
			pascal[r][0] = 1;
			for (int c = 1; c < C + W; c++) {
				pascal[r][c] = (pascal[r - 1][c - 1] + pascal[r - 1][c]);
			}
		}

		long answer = 0l;

		for (int r = R - 1; r < R + W - 1; r++) {
			for (int c = C - 1; c <= C + r - R; c++) {
				answer += pascal[r][c];
			}
		}

		System.out.println(answer);
	}
}
