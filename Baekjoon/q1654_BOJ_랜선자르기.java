package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1654_BOJ_랜선자르기 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] lan = new int[K];
		long min = 1, max = 0;
		for (int k = 0; k < K; k++) {
			lan[k] = Integer.parseInt(br.readLine());
			max = Math.max(max, lan[k]);
		}

		while (min <= max) {
			long center = (min + max) / 2;
			long count = 0;
			
			for (int k = 0; k < K; k++) {
				count += lan[k] / center;
			}

			if (count >= N) {
				min = center + 1;
			} else {
				max = center - 1;
			}
		}

		System.out.println(max);
	}
}
