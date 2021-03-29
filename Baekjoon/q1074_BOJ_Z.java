package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1074_BOJ_Z {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int answer = 0;
		int x, y, num;

		for (int n = 0; n < N; n++) {
			x = R % 2;
			y = C % 2;
			num = (int) Math.pow(4, n);
			R /= 2;
			C /= 2;
			if (x == 0 && y == 0) {
				answer += num * 0;
			} else if (x == 0 && y == 1) {
				answer += num * 1;
			} else if (x == 1 && y == 0) {
				answer += num * 2;
			} else if (x == 1 && y == 1) {
				answer += num * 3;
			}
		}

		System.out.println(answer);
	}
}
