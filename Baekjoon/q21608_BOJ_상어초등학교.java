package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class q21608_BOJ_상어초등학교 {
	static StringTokenizer st;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		int[][] friend = new int[N * N + 1][4];
		int answer = 0;

		for (int n = 0; n < N * N; n++) {
			st = new StringTokenizer(br.readLine());

			int me = Integer.parseInt(st.nextToken());
			LinkedList<position> list = new LinkedList<>();

			for (int i = 0; i < 4; i++) {
				friend[me][i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0) {
						int space = 0, myFriend = 0;
						for (int k = 0; k < 4; k++) {
							int nX = i + delta[k][0];
							int nY = j + delta[k][1];
							if (isIn(nX, nY)) {
								if (map[nX][nY] == 0) {
									space++;
								} else {
									for (int l = 0; l < 4; l++) {
										if (map[nX][nY] == friend[me][l]) {
											myFriend++;
											break;
										}
									}
								}
							}
						}
						list.add(new position(i, j, myFriend, space));
					}
				}
			}

			Collections.sort(list, (position e1, position e2) -> {
				if (e1.friend == e2.friend) {
					if (e1.space == e2.space) {
						if (e1.x == e2.x) {
							return e1.y - e2.y;
						} else {
							return e1.x - e2.x;
						}
					} else {
						return e2.space - e1.space;
					}
				} else {
					return e2.friend - e1.friend;
				}
			});

			position target = list.get(0);
			map[target.x][target.y] = me;

		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int myFriend = 0;
				for (int k = 0; k < 4; k++) {
					int nX = i + delta[k][0];
					int nY = j + delta[k][1];
					if (isIn(nX, nY)) {
						for (int l = 0; l < 4; l++) {
							if (map[nX][nY] == friend[map[i][j]][l]) {
								myFriend++;
							}
						}
					}
				}
				if (myFriend == 4) {
					answer += 1000;
				} else if (myFriend == 3) {
					answer += 100;
				} else if (myFriend == 2) {
					answer += 10;
				} else if (myFriend == 1) {
					answer += 1;
				}
			}
		}
		System.out.println(answer);
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < N) {
			return true;
		}
		return false;
	}

	static class position {
		int x, y, friend, space;

		position(int x, int y, int friend, int space) {
			this.x = x;
			this.y = y;
			this.friend = friend;
			this.space = space;
		}
	}
}
