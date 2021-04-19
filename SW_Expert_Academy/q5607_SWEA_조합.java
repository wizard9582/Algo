package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q5607_SWEA_조합 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static long[] facto = new long[1000001];
	static final int mod = 1234567891;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		facto[0] = 1;
		for (int n = 1; n <= 1000000; n++) {
			facto[n] = (facto[n - 1] * n) % mod;
		}

		int T = Integer.parseInt(br.readLine());
		int answer;

		for (int tc = 1; tc <= T; tc++) {
			answer = 0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());

			long top = facto[N] % mod;
			long bottom = facto[R] * facto[N - R] % mod;
			long calculBottom = ferma(bottom, mod - 2);

			sb.append("#").append(tc).append(" ").append((top * calculBottom) % mod).append("\n");
		}
		System.out.println(sb);
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
