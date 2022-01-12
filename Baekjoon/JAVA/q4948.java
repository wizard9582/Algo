package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q4948 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] arr = new int[246913];
		arr[1] = 1;

		for (int i = 2; i < 246913; i++) {
			if (arr[i] == 0) {
				for (int j = 2; i * j < 246913; j++) {
					arr[i * j] = 1;
				}
			} else {
				continue;
			}
		}

		while (true) {
			int N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			int count = 0;

			for (int i = N + 1; i < 2 * N + 1; i++) {
				if (arr[i] == 0)
					count++;
			}
			System.out.println(count);
		}
	}
}