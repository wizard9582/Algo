package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q17143_BOJ_낚시왕 {
	static StringTokenizer st;
	static int[][] delta = { {}, { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static int R, C, M;
	static int[][] map;
	static boolean[] shark;
	static ArrayList<Shark> sharkList = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		shark = new boolean[M + 1];

		sharkList.add(new Shark());
		for (int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int speed = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int size = Integer.parseInt(st.nextToken());
			
			speed = dir/3 == 0? speed % ((R - 1) * 2): speed % ((C - 1) * 2) ;
			
			sharkList.add(new Shark(x, y, speed, dir, size));
			map[x][y] = m;
		}

		int catchShark = 0;

		for (int c = 0; c < C; c++) {
			for (int r = 0; r < R; r++) {
				if (map[r][c] != 0) {
					shark[map[r][c]] = true;
					catchShark += sharkList.get(map[r][c]).size;
					break;
				}
			}
			map = new int[R][C];
			sharkMove();
		}

		System.out.println(catchShark);
	}

	static void sharkMove() {

		for (int m = 1; m <= M; m++) {
			if (!shark[m]) {
				Shark s = sharkList.get(m);
				int x = s.x, y = s.y, speed = s.speed, dir = s.dir, size = s.size;

				if (dir / 3 == 0) {
					while (speed-- > 0) {
						if (x == R - 1) {
							dir = 1;
						}
						if (x == 0) {
							dir = 2;
						}
						x += delta[dir][0];
					}
				} else {
					while (speed-- > 0) {
						if (y == C - 1) {
							dir = 4;
						}
						if (y == 0) {
							dir = 3;
						}
						y += delta[dir][1];
					}
				}
				if (map[x][y] == 0) {
					map[x][y] = m;
				} else if (sharkList.get(map[x][y]).size < size) {
					shark[map[x][y]] = true;
					map[x][y] = m;
				} else {
					shark[m] = true;
				}
				s.x = x;
				s.y = y;
				s.dir = dir;
			}
		}
	}

	static class Shark {
		int x, y, speed, dir, size;

		public Shark() {

		}

		public Shark(int x, int y, int speed, int dir, int size) {
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
		}
	}
}
