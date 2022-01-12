package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2004_BOJ_조합0의개수 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());
		
		long five = findFive(N) - findFive(N - M) - findFive(M);
		long two = findTwo(N) - findTwo(N - M) - findTwo(M);
		
		System.out.println(Math.min(five, two));
	}

	static long findFive(long num) {
		long count = 0l;

		while (num > 0) {
			count += num / 5;
			num /= 5;
		}

		return count;
	}
	
	static long findTwo(long num) {
		long count = 0l;

		while (num > 0) {
			count += num / 2;
			num /= 2;
		}

		return count;
	}
}
