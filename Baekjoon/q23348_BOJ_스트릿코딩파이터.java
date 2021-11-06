package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q23348_BOJ_스트릿코딩파이터 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int N = Integer.parseInt(br.readLine());
		int max = 0;

		for (int n = 0; n < N; n++) {
			int sum = 0;
			for (int i = 0; i < 3; i++) {
				st = new StringTokenizer(br.readLine());
				sum += (A * Integer.parseInt(st.nextToken())) + (B * Integer.parseInt(st.nextToken()))
						+ (C * Integer.parseInt(st.nextToken()));
			}
			max = Math.max(max, sum);
		}
		System.out.println(max);
	}
}