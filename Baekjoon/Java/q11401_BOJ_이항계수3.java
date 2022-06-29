package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q11401_BOJ_이항계수3 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static final int mod = 1000000007;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		long[] facto = new long[N+1];
		facto[0] = 1;
		for (int n = 1; n <= N; n++) {
			facto[n] = (facto[n - 1] * n) % mod;
		}
		
		long top = facto[N] % mod;
		long bottom = facto[R] * facto[N - R] % mod;
		long calculBottom = ferma(bottom, mod - 2);

		System.out.println((top * calculBottom) % mod);
	}

	static long ferma(long n, int x) {
		if (x == 0) {
			return 1;
		}

		long tmp = ferma(n, x / 2);
		long ret = (tmp * tmp) % mod;
		long answer = x % 2 == 0 ? ret : (ret * n) % mod;

		return answer;
	}
}
