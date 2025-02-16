package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q11728_BOJ_배열합치기 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr1 = new int[N];
		int[] arr2 = new int[M];

		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			arr1[n] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int m = 0; m < M; m++) {
			arr2[m] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr1);
		Arrays.sort(arr2);

		int idx1 = 0;
		int idx2 = 0;

		while (idx1 < N || idx2 < M) {
			if (idx1 == N) {
				sb.append(arr2[idx2]).append(" ");
				idx2++;
			} else if (idx2 == M) {
				sb.append(arr1[idx1]).append(" ");
				idx1++;
			} else {
				if (arr1[idx1] <= arr2[idx2]) {
					sb.append(arr1[idx1]).append(" ");
					idx1++;
				} else {
					sb.append(arr2[idx2]).append(" ");
					idx2++;
				}
			}
		}

		System.out.println(sb);
	}
}