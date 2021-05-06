package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1440_BOJ_타임머신 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), ":");

		int canTime = 0, out = 0;

		for (int i = 0; i < 3; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (num > 59) {
				out++;
			} else if (num > 0 && num < 13) {
				canTime++;

			}
		}

		if (out != 0) {
			System.out.println(0);
		} else {
			System.out.println(canTime * 2);
		}

	}
}
