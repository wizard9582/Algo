package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1758_BOJ_알바생강호 {
	static int[] customer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		customer = new int[N];

		for (int n = 0; n < N; n++) {
			customer[n] = Integer.parseInt(br.readLine());
		}

		mergeSort(0, N - 1);

		long answer = 0l;

		for (int n = 0; n < N; n++) {
			answer += Math.max((long) customer[n] - n, 0);
		}

		System.out.println(answer);
	}

	static void mergeSort(int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(start, mid);
			mergeSort(mid + 1, end);

			int left = start;
			int right = mid + 1;
			int[] temp = new int[end - start + 1];
			int idx = 0;

			while (left <= mid || right <= end) {
				if (right > end || (left <= mid && customer[left] > customer[right])) {
					temp[idx++] = customer[left++];
				} else {
					temp[idx++] = customer[right++];
				}
			}
			
			for(int i = start; i <= end; i++) {
				customer[i] = temp[i-start];
			}
		}
	}
}
