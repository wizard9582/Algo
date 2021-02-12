package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q15688 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[2000001];

		for (int i = 0; i < N; i++) {
			arr[Integer.parseInt(br.readLine()) + 1000000]++;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				for (int j = 0; j < arr[i]; j++) {
					sb.append(i - 1000000).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}
