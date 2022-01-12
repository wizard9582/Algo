package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q16922 {
	static int N, answer = 0;
	static boolean[] check;
	static int[] num = { 1, 5, 10, 50 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		check = new boolean[N*50 + 1];
		makeCombinationDuple(0, 0, new int[N]);

		System.out.println(answer);
	}

	static void makeCombinationDuple(int count, int idx, int[] choosed) {
		if (count == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += num[choosed[i]];
			}
			if (!check[sum]) {
				answer++;
				check[sum] = true;
			}
			return;
		}
		for (int i = idx; i < 4; i++) {
			choosed[count] = i;
			makeCombinationDuple(count + 1, i, choosed);
		}
	}
}