package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class q1644_BOJ_소수의연속합 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N + 1];
		List<Integer> list = new ArrayList<>();
		int answer = 0;
		num[1] = 1;

		for (int n = 2; n <= N; n++) {
			if (num[n] == 0) {
				list.add(n);

				for (int i = 2; i * n <= N; i++) {
					num[i * n] = 1;
				}
			}
		}

		int sum = 0, start = list.size() - 1, end = list.size() - 1;

		while (end < list.size()) {
			if (sum == N) {
				answer++;
				sum -= list.get(start++);
			} else if (sum > N) {
				sum -= list.get(start++);
			} else {
				sum += list.get(end++);
			}
		}

		if (num[N] == 0) {
			answer++;
		}

		System.out.println(answer);

	}
}
