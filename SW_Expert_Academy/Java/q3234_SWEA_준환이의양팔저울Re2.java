package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q3234_SWEA_준환이의양팔저울Re2 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, total;
	static int[] gram;
	static int[][] memo;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			total = 0;
			gram = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				gram[n] = Integer.parseInt(st.nextToken());
				total += gram[n];
			}

			memo = new int[total + 1][1 << N];

			sb.append("#").append(tc).append(" ").append(makePermutation(0, 0, 0, 0)).append("\n");
		}

		System.out.println(sb);
	}

	static int makePermutation(int count, int bitmask, int left, int right) {
		if (count == N) {
			return 1;
		}

		int sum = memo[left][bitmask];

		if (sum == 0) {
			for (int i = 0; i < N; i++) {
				if ((bitmask & (1 << i)) == 0) {
					sum += makePermutation(count + 1, bitmask | (1 << i), left + gram[i], right);
					if (right + gram[i] <= left) {
						sum += makePermutation(count + 1, bitmask | (1 << i), left, right + gram[i]);
					}
				}
			}
			return memo[left][bitmask] = sum;
		}
		return sum;
	}
}
