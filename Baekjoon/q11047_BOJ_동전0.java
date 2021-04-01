package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q11047_BOJ_동전0 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coin = new int[N];

		for (int n = 0; n < N; n++) {
			coin[n] = Integer.parseInt(br.readLine());
		}

		int answer = 0;

		for (int n = N - 1; n > -1; n--) {
			if (K / coin[n] == 0) {

			} else {
				answer += K / coin[n];
				K = K % coin[n];
			}
		}

		System.out.println(answer);
	}
}
