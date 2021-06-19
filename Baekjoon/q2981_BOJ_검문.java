package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q2981_BOJ_검문 {
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);
		int num = arr[1] - arr[0];
		for (int n = 2; n < N; n++) {
			num = gcd(num, arr[n] - arr[n - 1]);
		}

		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				sb.append(i).append(" ");
			}
		}
		sb.append(num);

		System.out.println(sb);
	}

	static int gcd(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			int r = a % b;
			return gcd(b, r);
		}
	}
}
