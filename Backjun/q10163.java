package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q10163 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] map = new int[101][101];
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N + 1];

		int R, C, H, W;

		for (int n = 1; n <= N; n++) {
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			for (int i = R; i < R + H; i++) {
				for (int j = C; j < C + W; j++) {
					map[i][j] = n;
				}
			}
		}
		for (int i = 0; i <= 100; i++) {
			for (int j = 0; j <= 100; j++) {
				num[map[i][j]]++;
			}
		}
		for (int n = 1; n <= N; n++) {
			sb.append(num[n]).append("\n");
		}

		System.out.println(sb);
	}
}
