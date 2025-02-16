package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q3273_BOJ_두수의합 {
	static StringTokenizer st;
	static int[] num;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(br.readLine());

		num = new int[N];
		for (int n = 0; n < N; n++) {
			num[n] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);

		int answer = 0;
		int start = 0, end = N - 1;

		while (start < end) {
			int sum = num[start] + num[end];

			if (sum == X) {
				answer++;
				start++;
			} else if (sum < X) {
				start++;
			} else {
				end--;
			}
		}

		System.out.println(answer);
	}
}
