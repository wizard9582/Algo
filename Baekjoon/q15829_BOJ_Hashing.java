package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q15829_BOJ_Hashing {
	static long mod = 1234567891;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();

		long[] r = new long[L];
		r[0] = 1;

		for (int l = 1; l < L; l++) {
			// r[l] = (long) Math.pow(31, l) % mod;
			r[l] = (r[l - 1] * 31) % mod;
		}

		long answer = 0;

		for (int l = 0; l < L; l++) {
			long num = arr[l] - 'a' + 1;
			answer = (answer + (num * r[l])) % mod;
		}
		System.out.println(answer);
	}
}
