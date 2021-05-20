package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1790_BOJ_수이어쓰기2 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());

		long count = 1;
		long nine = 9;
		long check = 0l;

		while (M > count * nine) {
			M -= count * nine;
			check += nine;

			nine *= 10;
			count++;
		}

		check += ((M - 1) / count) + 1;

		if (check > N) {
			System.out.println(-1);
		} else {
			System.out.println(Long.toString(check).charAt((int) ((int)(M - 1) % count)));
		}
	}
}
