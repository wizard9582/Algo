package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q5525_BOJ_IOIOI {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		int[] index = new int[M];
		int count = 0;

		for (int m = 2; m < M; m++) {
			if (arr[m] == 'I' && arr[m - 1] == 'O' && arr[m - 2] == 'I') {
				index[m] = index[m - 2] + 1;
			}
			if (index[m] >= N) {
				count++;
			}
		}

		System.out.println(count);
	}
}
