package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q3238_SWEA_이항계수구하기 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			long N = Long.parseLong(st.nextToken());
			long R = Long.parseLong(st.nextToken());
			int P = Integer.parseInt(st.nextToken());

			long[] facto = new long[P + 1];
			facto[0] = 1;
			for (int p = 1; p <= P; p++) {
				facto[p] = (facto[p - 1] * p) % P;
			}

			long res = 1;
			while (N > 0 && R > 0) {
				long n = N % P;
				long r = R % P;

				if (n < r) {
					res = 0;
					break;
				}

				res = (res * facto[(int) n]) % P;
				for (int i = 0; i < P - 2; i++)
					res = ((res * facto[(int) r]) % P * facto[(int) (n - r)]) % P;
				N /= P;
				R /= P;
			}

			sb.append("#").append(tc).append(" ").append(res).append("\n");
		}

		System.out.println(sb);
	}
}