package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1210 {
	static int[][] arr = new int[102][102];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int answer, high;

		for (int t = 1; t <= 10; t++) {
			br.readLine();
			answer = 0;
			high = 100;
			for (int i = 1; i < 101; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < 101; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int j = 1; j < 101; j++) {
				if (arr[100][j] == 2) {
					answer = j;
					break;
				}
			}

			while (high > 1) {
				if (arr[high][answer - 1] == 1) {
					while (true) {
						answer--;
						if (arr[high - 1][answer] == 1) {
							high--;
							break;
						}
					}
				} else if (arr[high][answer + 1] == 1) {
					while (true) {
						answer++;
						if (arr[high - 1][answer] == 1) {
							high--;
							break;
						}
					}
				} else {
					high--;
				}
			}
			sb.append("#").append(t).append(" ").append(answer-1).append("\n");
		}
		System.out.println(sb);
	}
}
