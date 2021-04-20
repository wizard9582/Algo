package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q5604_SWEA_구간합 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static long[] num;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			num = new long[10];
			long tenCount = 1;
			long start = Long.parseLong(st.nextToken());
			long end = Long.parseLong(st.nextToken());

			while (start <= end) {
				while (start % 10 != 0 && start <= end) {
					countNum(start, tenCount);
					start++;
				}

				while (end % 10 != 9 && start <= end) {
					countNum(end, tenCount);
					end--;
				}

				if (start > end) {
					break;
				}

				start /= 10;
				end /= 10;

				for (int n = 0; n <= 9; n++) {
					num[n] += (end - start + 1) * tenCount;
				}

				tenCount *= 10;
			}

			long answer = 0l;

			for (int n = 1; n <= 9; n++) {
				answer += num[n] * n;
			}

			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}

		System.out.println(sb);
	}

	static void countNum(long n, long tenCount) {
		while (n > 0) {
			num[(int) (n % 10)] += tenCount;
			n /= 10;
		}
	}
}
