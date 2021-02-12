package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1182 {
	static int[] num;
	static int count = 0;
	static int N, S;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		num = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		recur(0, 0);
		System.out.println(count);
	}

	static void recur(int start, int sum) {

		for (int i = start; i < num.length; i++) {
			if (sum + num[i] == S) {
				count++;
			}
			recur(i + 1, sum + num[i]);
		}
	}
}
