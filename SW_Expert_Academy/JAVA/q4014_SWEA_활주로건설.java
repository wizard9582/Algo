package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q4014_SWEA_활주로건설 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int answer;

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			answer = 2 * N;

			int[][] map = new int[N][N];
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < N; m++) {
					map[n][m] = Integer.parseInt(st.nextToken());
				}
			}

			boolean[][] visit = new boolean[N][N];
			for (int n = 0; n < N; n++) {
				int before = map[n][0];
				boolean flag = false;

				for (int m = 0; m < N; m++) {
					int now = map[n][m];
					if (now == before) {
						continue;
					} else if (Math.abs(now - before) != 1) {
						flag = true;
					} else {

						if ((now - before) == 1) { // 올라가는 경사로

							if (X <= m) {
								for (int x = m - X; x < m; x++) {
									if (visit[n][x]) {
										flag = true;
										break;
									}
									visit[n][x] = true;
								}
							} else {
								flag = true;
							}

						} else { // 내려가는 경사로
							if (m < N - X + 1) {
								for (int x = m; x < m + X; x++) {
									if (visit[n][x] || map[n][x] != now) {
										flag = true;
										break;
									}
									visit[n][x] = true;
								}
								m += X - 1;
							} else {
								flag = true;
							}
						}

					}

					if (flag) {
						answer--;
						//System.out.printf("%d번 %d행체크 불통과\n", tc, n);
						break;
					}
					before = now;

				}
			}

			visit = new boolean[N][N];
			for (int m = 0; m < N; m++) {
				int before = map[0][m];
				boolean flag = false;

				for (int n = 0; n < N; n++) {
					int now = map[n][m];
					if (now == before) {
						continue;
					} else if (Math.abs(now - before) != 1) {
						flag = true;
					} else {

						if ((now - before) == 1) { // 올라가는 경사로

							if (X <= n) {
								for (int x = n - X; x < n; x++) {
									if (visit[x][m]) {
										flag = true;
										break;
									}
									visit[x][m] = true;
								}
							} else {
								flag = true;
							}

						} else { // 내려가는 경사로
							if (n < N - X + 1) {
								for (int x = n; x < n + X; x++) {
									if (visit[x][m] || map[x][m] != now) {
										flag = true;
										break;
									}
									visit[x][m] = true;
								}
								n += X - 1;
							} else {
								flag = true;
							}
						}

					}

					if (flag) {
						answer--;
						//System.out.printf("%d번 %d열체크 불통과\n", tc, m);
						break;
					}
					before = now;

				}
			}

			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}

		System.out.println(sb);
	}
}
