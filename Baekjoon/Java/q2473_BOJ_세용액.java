package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q2473_BOJ_세용액 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		long[] num = new long[N];

		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			num[n] = Long.parseLong(st.nextToken());
		}
		Arrays.sort(num);
		long min = Long.MAX_VALUE;
		long[] answer = new long[3];

		loop: for (int n = 0; n < N; n++) {
			int left = n + 1;
			int right = N - 1;

			while (left < right) {
				long sum = num[n] + num[left] + num[right];

				if (Math.abs(sum) < Math.abs(min)) {
					min = sum;
					answer[0] = num[n];
					answer[1] = num[left];
					answer[2] = num[right];
				}

				if (sum == 0) {
					break loop;
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}

		sb.append(answer[0]).append(" ").append(answer[1]).append(" ").append(answer[2]);
		System.out.println(sb);
	}
}