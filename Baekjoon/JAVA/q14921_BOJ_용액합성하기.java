package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q14921_BOJ_용액합성하기 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			num[n] = Integer.parseInt(st.nextToken());
		}
		int answer = Integer.MAX_VALUE;

		int left = 0;
		int right = N - 1;

		while (left < right) {
			int sum = num[left] + num[right];

			if (Math.abs(sum) < Math.abs(answer)) {
				answer = sum;
			}

			if (sum == 0) {
				break;
			} else if (sum > 0) {
				right--;
			} else {
				left++;
			}
		}
		System.out.println(answer);
	}
}