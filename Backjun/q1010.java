package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1010 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int[][] bridge = new int[30][30];
		int x, y;

		for (y = 1; y < 30; y++) {
			bridge[1][y] = y;
		}

		for (x = 2; x < 30; x++) {
			for (y = 2; y < 30; y++) {
				bridge[x][y] = bridge[x][y - 1] + bridge[x - 1][y - 1];
			}
		}

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			int answer = bridge[x][y];

			sb.append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
