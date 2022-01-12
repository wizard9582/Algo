package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q11054 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int n = 1; n <= N; n++) {
			num[n] = Integer.parseInt(st.nextToken());
		}

		int[] increase = new int[N + 1];
		increase[0] = 0;
		for (int n = 1; n <= N; n++) {
			int now = num[n];
			int max = 0;
			for (int i = 0; i < n; i++) {
				if (num[i] < now) {
					max = Math.max(max, increase[i]);
				}
			}
			increase[n] = max + 1;
		}

		int[] decrease = new int[N + 1];
		decrease[N] = 1;
		for (int n = N - 1; n >= 0; n--) {
			int now = num[n];
			int max = 0;
			for (int i = N; i > n; i--) {
				if (num[i] < now) {
					max = Math.max(max, decrease[i]);
				}
			}
			decrease[n] = max + 1;
		}

		int answer = 0;
		for (int n = 1; n <= N; n++) {
			answer = Math.max(answer, increase[n] + decrease[n] - 1);
		}
		System.out.println(answer);
	}
}
