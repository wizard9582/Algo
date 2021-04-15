package jungOl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q1828_JO_냉장고 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		int ondo = -300;
		int[][] yak = new int[N][2];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			yak[n][0] = Integer.parseInt(st.nextToken());
			yak[n][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(yak, (e1, e2) -> {
			if (e1[0] == e2[0]) {
				return e2[1] - e1[1];
			} else {
				return e1[0] - e2[0];
			}
		});

		for (int n = 0; n < N; n++) {

			if (ondo < yak[n][0]) {
				ondo = yak[n][1];
				answer++;
				continue;
			}
			if(yak[n][1] < ondo) {
				ondo = yak[n][1];
			}
		}

		System.out.println(answer);
	}
}
