package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1019_BOJ_책페이지 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static long[] num = new long[10];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int start = 1, tenCount = 1;
		int end = Integer.parseInt(br.readLine());

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

		for (int n = 0; n <= 9; n++) {
			sb.append(num[n]).append(" ");
		}
		System.out.println(sb);
	}

	static void countNum(int n, int tenCount) {
		while (n > 0) {
			num[n % 10] += tenCount;
			n /= 10;
		}
	}
}
