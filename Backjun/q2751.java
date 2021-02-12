package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q2751 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[2000001];

		for (int n = 0; n < N; n++) {
			arr[1000000 + Integer.parseInt(br.readLine())]++;
		}

		for (int i = 0; i < 2000001; i++) {
			if (arr[i] > 0) {
				sb.append(i - 1000000).append("\n");
			}
		}

		System.out.println(sb);
	}
}
