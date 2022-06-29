package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q23559_BOJ_밥 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long answer = 0;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int money = Integer.parseInt(st.nextToken());
		int[][] menu = new int[N][2];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			menu[n][0] = Integer.parseInt(st.nextToken());
			menu[n][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(menu, (e1, e2) -> {
			return (e2[0] - e2[1]) - (e1[0] - e1[1]);
		});

		int n = 0;

		while (money - ((N - n) * 1000) >= 4000) {
			if(menu[n][1] > menu[n][0]) {
				break;
			}
			answer += menu[n][0];
			money -= 5000;
			n++;
		}
		while (n < N) {
			answer += menu[n][1];
			n++;
		}
		
		System.out.println(answer);
	}
}