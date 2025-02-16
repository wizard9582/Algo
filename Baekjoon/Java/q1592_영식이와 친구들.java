package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1592 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[] man = new int[N + 1];

		int count = 0;
		int n = 1;

		while (true) {
			man[n]++;

			if (man[n] == M) {
				break;
			}
			if (man[n] % 2 == 1) {
				n = n + L;
				if (n > N) {
					n = n - N;
				}
				count++;
			} else {
				n = n - L;
				if (n <= 0) {
					n = N + n;
				}
				count++;
			}
		}

		System.out.println(count);
	}
}
