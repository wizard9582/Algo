package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q5644_SWEA_무선충전 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] delta = { { 0, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };
	static int[][][][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int answer;

		for (int tc = 1; tc <= T; tc++) {
			answer = 0;
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			map = new int[11][11][P][2];

			int[] personA = new int[M];
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				personA[m] = Integer.parseInt(st.nextToken());
			}

			int[] personB = new int[M];
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				personB[m] = Integer.parseInt(st.nextToken());
			}

			Queue<int[]> queue = new LinkedList<>();

			for (int p = 0; p < P; p++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int l = Integer.parseInt(st.nextToken());
				int power = Integer.parseInt(st.nextToken());

				map[x][y][p][0] = power;
				map[x][y][p][1] = p+1;
				queue.offer(new int[] { x, y, l, power });

				while (!queue.isEmpty()) {
					int[] now = queue.poll();
					x = now[0];
					y = now[1];
					l = now[2];
					power = now[3];

					if (l != 0) {
						for (int i = 1; i <= 4; i++) {
							int nX = x + delta[i][0];
							int nY = y + delta[i][1];
							if (isIn(nX, nY) && map[nX][nY][p][0] == 0) {
								map[nX][nY][p][0] = power;
								map[nX][nY][p][1] = p+1;
								queue.offer(new int[] { nX, nY, l - 1, power });
							}
						}
					}

				}

				queue.clear();
			}

			for (int i = 1; i <= 10; i++) {
				for (int j = 1; j <= 10; j++) {
					Arrays.sort(map[i][j], (e1,e2)->{
						return e2[0]-e1[0];
					});
				}
			}
			
			int aX = 1, aY = 1;
			int bX = 10, bY = 10;
			answer += map[aX][aY][0][0] + map[bX][bY][0][0];
			
			for(int m = 0; m < M; m++) {
				//System.out.printf("%d\n A:(%d,%d) B:(%d,%d)",answer,aX,aY,bX,bY);
				
				aX += delta[personA[m]][0];
				aY += delta[personA[m]][1];
				bX += delta[personB[m]][0];
				bY += delta[personB[m]][1];
				
				if(map[aX][aY][0][1] == map[bX][bY][0][1]) {
					if(P == 1 || (map[aX][aY][1][0] == 0 && map[bX][bY][1][0] == 0)) {
						answer += map[aX][aY][0][0];
					}else {
						answer += map[aX][aY][0][0] + Math.max(map[aX][aY][1][0], map[bX][bY][1][0]);
					}
					
				}else {
					answer += map[aX][aY][0][0] + map[bX][bY][0][0];
				}
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}

		System.out.println(sb);
	}

	static boolean isIn(int x, int y) {
		if (0 < x && x <= 10 && 0 < y && y <= 10) {
			return true;
		}
		return false;
	}
}
