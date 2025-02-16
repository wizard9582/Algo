package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1037_BOJ_약수 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int Max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int n = 0; n < N; n++) {
			int num = Integer.parseInt(st.nextToken());
			if (num < min) {
				min = num;
			}
			if (Max < num) {
				Max = num;
			}
		}

		System.out.println(Max * min);
	}
}
