package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q8911_BOJ_거북이 {
	static StringBuilder sb = new StringBuilder();
	static int[][] delta = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int dir = 0;

		for (int t = 0; t < T; t++) {
			String str = br.readLine();
			int maxX = 0, maxY = 0, minX = 0, minY = 0;
			int x = 0, y = 0;

			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);

				switch (c) {
				case 'F':
					x += delta[dir][0];
					y += delta[dir][1];
					break;
				case 'B':
					x -= delta[dir][0];
					y -= delta[dir][1];
					break;
				case 'R':
					dir = (dir + 1) % 4;
					break;
				case 'L':
					dir --;
					if(dir == -1) {
						dir = 3;
					}
					break;
				}

				maxX = Math.max(maxX, x);
				maxY = Math.max(maxY, y);
				minX = Math.min(minX, x);
				minY = Math.min(minY, y);
			}
			
			sb.append((maxX-minX)*(maxY-minY)).append("\n");
		}

		System.out.println(sb);
	}
}
