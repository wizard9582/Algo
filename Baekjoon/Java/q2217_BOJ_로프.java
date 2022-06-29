package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q2217_BOJ_로프 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];

		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr);

		int answer = 0;

		for (int n = 0; n < N; n++) {
			answer = Math.max(arr[n] * (N - n), answer);
		}
		
		System.out.println(answer);
	}
}
