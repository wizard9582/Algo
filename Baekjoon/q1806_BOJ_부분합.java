package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1806_BOJ_부분합 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());

		int[] num = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			num[n] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = 1;
		int sum = num[0];
		int answer = 100_001;

		while (left < N) {
			if (sum >= S) {
				answer = Math.min(answer, right - left);
				sum -= num[left];
				left++;
			} else {
				if (right == N) {
					break;
				} else {
					sum += num[right];
					right++;
				}
			}
		}
		if(answer == 100_001) {
			System.out.println(0);
		}else {
			System.out.println(answer);
		}
	}
}
