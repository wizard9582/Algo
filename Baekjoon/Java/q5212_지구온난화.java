package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q5212_BOJ_지구온난화 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int R, C;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		boolean[][] map = new boolean[R][C];
		boolean[][] nMap = new boolean[R][C];

		for (int r = 0; r < R; r++) {
			char[] input = br.readLine().toCharArray();
			for (int c = 0; c < C; c++) {
				if (input[c] == 'X') {
					map[r][c] = true;
				}
			}
		}

		int minR = -1, maxR = -1, minC = -1, maxC = -1;

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if (map[r][c]) {
					int count = 0;

					for (int i = 0; i < 4; i++) {
						int nR = r + delta[i][0];
						int nC = c + delta[i][1];
						if (isIn(nR, nC) && map[nR][nC]) {
							count++;
						}
					}
					if (count >= 2) {
						nMap[r][c] = true;
						
						if(minR == -1 || minC == -1) {
							minR = r;
							minC = c;
						}else{
							minR = Math.min(minR, r);
							minC = Math.min(minC, c);
						}
						maxR = Math.max(maxR, r);
						maxC = Math.max(maxC, c);
						
					}
				}
			}
		}
		
		for (int r = minR; r <= maxR; r++) {
			for (int c = minC; c <= maxC; c++) {
				if (nMap[r][c]) {
					sb.append('X');
				}else {
					sb.append('.');
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < R && 0 <= y && y < C) {
			return true;
		}
		return false;
	}
}