package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q12100_BOJ_2048Easy {
	static StringTokenizer st;
	static int N;
	static int answer;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		answer = 0;
		int[][] map = new int[N][N];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < N; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		solution(0, map);

		System.out.println(answer);
	}

	static void solution(int move, int[][] map) {
		if (move == 5) {
			answer = Math.max(answer, counting(map));
			return;
		}

		int[][] save = new int[N][N];

		for (int i = 0; i < 4; i++) {
			copyMap(map, save);
			moveMap(map, i);
			//print(map);
			solution(move + 1, map);
			copyMap(save, map);
		}
	}

	static int counting(int[][] map) {
		int max = 0;
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < N; m++) {
				max = Math.max(max, map[n][m]);
			}
		}
		return max;
	}

	static void copyMap(int[][] from, int[][] to) {
		for (int n = 0; n < N; n++) {
			to[n] = from[n].clone();
		}
	}

	static void moveMap(int[][] map, int dir) {
		boolean[][] crashed = new boolean[N][N];

		if (dir == 0) {
			for (int m = 0; m < N; m++) {
				for (int n = 0; n < N; n++) {
					if (map[n][m] != 0) {
						int nN = n + delta[dir][0];
						int nM = m + delta[dir][1];
						boolean flag = true;
						while (isIn(nN, nM)) {
							if (map[nN][nM] == 0) {
								nN += delta[dir][0];
								nM += delta[dir][1];
							} else {
								flag = false;
								if (map[nN][nM] == map[n][m] && !crashed[nN][nM]) {
									crashed[nN][nM] = true;
									map[nN][nM] *= 2;
									map[n][m] = 0;
								} else {
									nN -= delta[dir][0];
									nM -= delta[dir][1];
									if(nN!=n || nM!=m) {
										map[nN][nM] = map[n][m];
										map[n][m] = 0;
									}
								}
								break;
							}
						}
						if(flag) {
							nN -= delta[dir][0];
							nM -= delta[dir][1];
							if(nN!=n || nM!=m) {
								map[nN][nM] = map[n][m];
								map[n][m] = 0;
							}
						}
					}
				}
			}
		} else if (dir == 1) {
			for (int m = 0; m < N; m++) {
				for (int n = N - 1; n >= 0; n--) {
					if (map[n][m] != 0) {
						int nN = n + delta[dir][0];
						int nM = m + delta[dir][1];
						boolean flag = true;
						while (isIn(nN, nM)) {
							if (map[nN][nM] == 0) {
								nN += delta[dir][0];
								nM += delta[dir][1];
							} else {
								flag = false;
								if (map[nN][nM] == map[n][m] && !crashed[nN][nM]) {
									crashed[nN][nM] = true;
									map[nN][nM] *= 2;
									map[n][m] = 0;
								} else {
									nN -= delta[dir][0];
									nM -= delta[dir][1];
									if(nN!=n || nM!=m) {
										map[nN][nM] = map[n][m];
										map[n][m] = 0;
									}
								}
								break;
							}
						}
						if(flag) {
							nN -= delta[dir][0];
							nM -= delta[dir][1];
							if(nN!=n || nM!=m) {
								map[nN][nM] = map[n][m];
								map[n][m] = 0;
							}
						}
					}
				}
			}
		} else if (dir == 2) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < N; m++) {
					if (map[n][m] != 0) {
						int nN = n + delta[dir][0];
						int nM = m + delta[dir][1];
						boolean flag = true;
						while (isIn(nN, nM)) {
							if (map[nN][nM] == 0) {
								nN += delta[dir][0];
								nM += delta[dir][1];
							} else {
								flag = false;
								if (map[nN][nM] == map[n][m] && !crashed[nN][nM]) {
									crashed[nN][nM] = true;
									map[nN][nM] *= 2;
									map[n][m] = 0;
								} else {
									nN -= delta[dir][0];
									nM -= delta[dir][1];
									if(nN!=n || nM!=m) {
										map[nN][nM] = map[n][m];
										map[n][m] = 0;
									}
								}
								break;
							}
						}
						if(flag) {
							nN -= delta[dir][0];
							nM -= delta[dir][1];
							if(nN!=n || nM!=m) {
								map[nN][nM] = map[n][m];
								map[n][m] = 0;
							}
						}
					}
				}
			}
		} else {
			for (int n = 0; n < N; n++) {
				for (int m = N - 1; m >= 0; m--) {
					if (map[n][m] != 0) {
						int nN = n + delta[dir][0];
						int nM = m + delta[dir][1];
						boolean flag = true;
						while (isIn(nN, nM)) {
							if (map[nN][nM] == 0) {
								nN += delta[dir][0];
								nM += delta[dir][1];
							} else {
								flag = false;
								if (map[nN][nM] == map[n][m] && !crashed[nN][nM]) {
									crashed[nN][nM] = true;
									map[nN][nM] *= 2;
									map[n][m] = 0;
								} else {
									nN -= delta[dir][0];
									nM -= delta[dir][1];
									if(nN!=n || nM!=m) {
										map[nN][nM] = map[n][m];
										map[n][m] = 0;
									}
								}
								break;
							}
						}
						if(flag) {
							nN -= delta[dir][0];
							nM -= delta[dir][1];
							if(nN!=n || nM!=m) {
								map[nN][nM] = map[n][m];
								map[n][m] = 0;
							}
						}
					}
				}
			}
		}
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < N) {
			return true;
		}
		return false;
	}
	
//	//확인용 함수
//	static void print(int[][] map) {
//		for(int n = 0; n < N; n++) {
//			System.out.println(Arrays.toString(map[n]));
//		}
//		System.out.println();
//	}
}
