package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1463_BOJ_1로만들기Re {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];

		arr[1] = 0;
		for (int n = 2; n <= N; n++) {
			arr[n] = arr[n - 1] + 1;

			arr[n] = (n % 2 == 0) ? Math.min(arr[n], arr[n / 2] + 1) : arr[n];
			arr[n] = (n % 3 == 0) ? Math.min(arr[n], arr[n / 3] + 1) : arr[n];
		}

		System.out.println(arr[N]);
	}
}
