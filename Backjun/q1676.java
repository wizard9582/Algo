package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1676 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int count = 0;

		for (int n = 1; n <= N; n++) {

			int num = n;

			while (num % 5 == 0) {
				count++;
				num /= 5;
			}
		}

		System.out.println(count);
	}
}
