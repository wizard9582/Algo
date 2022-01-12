package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q17087 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] map = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			map[n] = Math.abs(Integer.parseInt(st.nextToken()) - M);
		}
		Arrays.sort(map);

		for (int i = map[0]; i > 0; i--) {

			boolean flag = true;
			
			for (int n = 0; n < N; n++) {
				if (map[n] % i != 0) {
					flag = false;
					break;
				}
			}

			if (flag) {
				System.out.println(i);
				break;
			}
		}
	}
}
