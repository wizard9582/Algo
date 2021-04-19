package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q11051_BOJ_이항계수2 {
	static StringTokenizer st;
	static final int mod = 10007;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			st = new StringTokenizer(br.readLine());
			long N = Long.parseLong(st.nextToken());
			long R = Long.parseLong(st.nextToken());

			long[] facto = new long[mod + 1];
			facto[0] = 1;
			for (int p = 1; p <= mod; p++) {
				facto[p] = (facto[p - 1] * p) % mod;
			}

			long res = 1;
			while (N > 0 && R > 0) {
				long n = N % mod;
				long r = R % mod;

				if (n < r) {
					res = 0;
					break;
				}

				res = (res * facto[(int) n]) % mod;
				for (int i = 0; i < mod - 2; i++)
					res = ((res * facto[(int) r]) % mod * facto[(int) (n - r)]) % mod;
				N /= mod;
				R /= mod;
			}

			System.out.println(res);
	}
}