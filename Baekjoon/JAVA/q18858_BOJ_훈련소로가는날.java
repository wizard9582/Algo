package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q18858_BOJ_훈련소로가는날 {
	static StringTokenizer st;
	static final long div = 998_244_353;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long[][] before = new long[M + 1][3];
		long[][] now = new long[M + 1][3];

		for (int m = 1; m <= M; m++) {
			before[m][1] = 1;
		}

		long sum = 0;

		for (int n = 1; n < N; n++) {
			
			sum = 0;
			for (int m = M; m > 0; m--) {
				sum = (sum + before[m][0] + before[m][1]) % div;
				now[m-1][0] = sum;
			}
			
			sum = 0;
			now[1][1] = (before[1][0] + before[1][1] + before[1][2]) % div;
			sum = (sum + now[1][1]) % div;
			for (int m = 2; m <= M; m++) {
				now[m][2] = sum;
				now[m][1] = (before[m][0] + before[m][1] + before[m][2]) % div;
				sum = (sum + now[m][1]) % div;
			}
			
			before = now.clone();
			now = new long[M+1][3];
		}

		long answer = 0;

		for (int m = 1; m <= M; m++) {
			answer = (answer + before[m][0] + before[m][1] + before[m][2]) % div;
		}

		System.out.println(answer);
	}
}
