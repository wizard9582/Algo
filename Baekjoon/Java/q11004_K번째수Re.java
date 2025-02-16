package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q11004_BOJ_K번째수Re {
	static int K, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()) - 1;
		int arr[] = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		quickSelection(arr, 0, N - 1);
		System.out.println(arr[K]);
	}

	static int partition(int[] arr, int left, int right) {
		int mid = (left + right) / 2;
		swap(arr, left, mid);

		int pivot = arr[left];
		int i = left, j = right;

		while (i < j) {
			while (pivot < arr[j]) {
				j--;
			}

			while (i < j && pivot >= arr[i]) {
				i++;
			}
			swap(arr, i, j);
		}

		arr[left] = arr[i];
		arr[i] = pivot;
		return i;
	}

	static void swap(int[] arr, int a, int b) {
		int temp = arr[b];
		arr[b] = arr[a];
		arr[a] = temp;
	}

	static void quickSelection(int[] arr, int left, int right) {
		if (left >= right) {
			return;
		}

		int pi = partition(arr, left, right);

		if (pi == K) {
			return;
		} else if (pi < K) {
			quickSelection(arr, pi + 1, right);
		} else {
			quickSelection(arr, left, pi - 1);
		}

	}
}