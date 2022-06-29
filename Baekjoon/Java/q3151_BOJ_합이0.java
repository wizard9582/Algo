package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q3151_BOJ_합이0 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] member = new int[N];
		long answer = 0l;
		
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			member[n] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(member);

		for (int n = 0; n < N - 2; n++) {
			if (member[n] > 0) {
				break;
			}
			int goal = -member[n];
			int left = n + 1;
			int right = N - 1;
			int idx = N;

			while (left < right) {
				int sum = member[left] + member[right];

				if (sum == goal) {
					if (member[left] == member[right]) {
						answer += right - left;
					} else {
						if (idx > right) {
							idx = right;
							while (idx > left && member[idx - 1] == member[right]) {
								idx--;
							}
						}
						answer += right - idx + 1;
					}
					left++;
				} else if (sum < goal) {
					left++;
				} else {
					right--;
				}
			}
		}
		System.out.println(answer);
	}
}
