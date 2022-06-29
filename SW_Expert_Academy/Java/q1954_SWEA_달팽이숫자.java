package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1954_SWEA_달팽이숫자 {
	static StringBuilder sb = new StringBuilder();
	static int[][] delta = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" \n");
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			boolean flag = true;
			int x = 0, y = -1, num = 1;
			int dir = 0;

			for (int i = N; i > 0;) {
				for (int j = 0; j < i; j++) {
					x += delta[dir][0];
					y += delta[dir][1];
					arr[x][y] = num;
					num++;
				}
				if(flag) {
					flag = false;
					i--;	
					dir++;
				}
				else {
					flag = true;
					if(dir == 3) {
						dir = 0;
						continue;
					}
					dir++;
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}
}
