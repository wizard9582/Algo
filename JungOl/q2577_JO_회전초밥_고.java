package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2577_JO_회전초밥_고 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[] sushi = new int[N];

		for (int n = 0; n < N; n++) {
			sushi[n] = Integer.parseInt(br.readLine());
		}

		int[] menus = new int[D + 1];
		int answer = 0;
		int max = 0;

		for (int k = 0; k < K; k++) {
			int in = sushi[k];
			if (menus[in] == 0) {
				answer++;
			}
			menus[in]++;
		}
		max = menus[C] == 0 ? answer + 1 : answer;

		for (int n = 0; n < N; n++) {
			int in = sushi[(n + K) % N];
			int out = sushi[n];

			if (menus[in] == 0) {
				answer++;
			}
			menus[in]++;

			menus[out]--;
			if (menus[out] == 0) {
				answer--;
			}

			if (answer >= max) {
				max = menus[C] == 0 ? answer + 1 : answer;
			}
		}

		System.out.println(max);
	}
}
