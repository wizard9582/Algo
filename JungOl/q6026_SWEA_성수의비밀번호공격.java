package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q6026_SWEA_성수의비밀번호공격 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static final int mod = 1000000007;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		long[][] pascal = new long[101][101];
		pascal[0][0] = 1;
		for (int n = 1; n <= 100; n++) {
			pascal[n][0] = 1;
			for (int m = 1; m <= n; m++) {
				pascal[n][m] = (pascal[n - 1][m - 1] + pascal[n - 1][m]) % mod;
			}
		}

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			long answer = 0l;

			for (int m = 0; m < M; m++) {
				long i = m % 2 == 0 ? 1 : -1;
				long nCr = pascal[M][m];
				long powerN = pow(M - m, N);
				
				answer = (answer + (i * (nCr * powerN) % mod) + mod) % mod;
			}

			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}

		System.out.println(sb);
	}

	static long pow(long a, int b) {
		if (b == 1) {
			return a;
		}
		long half = pow(a, b / 2);
		if (b % 2 == 0) {
			return (half * half) % mod;
		} else {
			return ((half * half % mod) * (a % mod)) % mod;
		}
	}
}
