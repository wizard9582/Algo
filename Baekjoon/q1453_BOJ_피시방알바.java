package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1453_BOJ_피시방알바 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		boolean[] seat = new boolean[101];

		st = new StringTokenizer(br.readLine());
		int count = 0;
		for (int n = 0; n < N; n++) {
			int customer = Integer.parseInt(st.nextToken());
			if (seat[customer]) {
				count++;
			} else {
				seat[customer] = true;
			}
		}
		System.out.println(count);
	}
}
