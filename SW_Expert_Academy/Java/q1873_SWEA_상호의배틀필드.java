package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1873_SWEA_상호의배틀필드 {
	static StringBuilder sb = new StringBuilder();
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static char[] tank = { '^', 'v', '<', '>' };
	static StringTokenizer st;
	static char[][] arr;
	static int x, y, H, W, dir;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine(), " ", false);
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			arr = new char[H][W];
			for (int h = 0; h < H; h++) {
				arr[h] = br.readLine().toCharArray();
			}

			loop: for (int h = 0; h < H; h++) {
				for (int w = 0; w < W; w++) {
					if (arr[h][w] == '^' || arr[h][w] == 'v' || arr[h][w] == '<' || arr[h][w] == '>') {
						x = w;
						y = h;
						switch (arr[h][w]) {
						case '^':
							dir = 0;
							break;
						case 'v':
							dir = 1;
							break;
						case '<':
							dir = 2;
							break;
						case '>':
							dir = 3;
							break;
						}
						break loop;
					}
				}
			}

			br.readLine();
			char[] order = br.readLine().toCharArray();

			for (int i = 0; i < order.length; i++) {
				if (order[i] == 'S') {
					shoot();
				} else {
					move(order[i]);
				}
				for (int h = 0; h < H; h++) {
					for (int w = 0; w < W; w++) {
						sb.append(arr[h][w]);
					}
					sb.append("\n");
				}
				sb.append("\n");
			}

			sb.append("#").append(tc).append(" ");

			for (int h = 0; h < H; h++) {
				for (int w = 0; w < W; w++) {
					sb.append(arr[h][w]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);
	}

	static void shoot() {
		int x1 = x;
		int y1 = y;
		while (isIn(x1, y1)) {
			if(arr[y1][x1] == '#') break;
			if(arr[y1][x1] == '*') {
				arr[y1][x1] = '.';
				break;
			}
			x1 += delta[dir][1];
			y1 += delta[dir][0];
		}
	}

	static void move(char c) {
		switch (c) {
		case 'U':
			dir = 0;
			break;
		case 'D':
			dir = 1;
			break;
		case 'L':
			dir = 2;
			break;
		case 'R':
			dir = 3;
			break;
		}

		if (isIn(x + delta[dir][1], y + delta[dir][0])) {
			if (arr[y + delta[dir][0]][x + delta[dir][1]] == '.') {
				arr[y][x] = '.';
				x += delta[dir][1];
				y += delta[dir][0];
			}
		}
		arr[y][x] = tank[dir];
	}

	static boolean isIn(int x, int y) {
		if (-1 < x && x < W && -1 < y && y < H) {
			return true;
		}
		return false;
	}
}
