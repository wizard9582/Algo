package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q1246 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Integer[] arr = new Integer[M];

		for (int m = 0; m < M; m++) {
			arr[m] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(arr, (e1, e2) -> {
			return e2 - e1;
		});

		int value = 0, money = 0;

		for (int n = 0; (n < N) && (n < M); n++) {
			if ((arr[n] * (n + 1)) > money) {
				money = arr[n] * (n + 1);
				value = arr[n];
			}
		}

		System.out.println(value + " " + money);
	}
}
