package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q11025_BOJ_카드구매하기 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N + 1];
		int[] answer = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int n = 1; n <= N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}

		for (int n = 1; n <= N; n++) {
			for (int m = n; m <= N; m++) {
				answer[m] = Math.max(answer[m], answer[m - n] + arr[n]);
			}
		}

		System.out.println(answer[N]);
	}
}
