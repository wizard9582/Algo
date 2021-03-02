package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q13458 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] room = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int n = 0; n < N; n++) {
			room[n] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		long answer = 0;

		for (int n = 0; n < N; n++) {
			answer++;
			if (room[n] <= M) {
				continue;
			} else {
				answer = answer + (room[n] - M) / S;

				if ((room[n] - M) % S != 0) {
					answer++;
				}
			}
		}

		System.out.println(answer);
	}
}
