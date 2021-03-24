package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class q14502 {
	static StringTokenizer st;
	static int[][] map;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N, M, answer = 0, wallCount;
	static List<Pair> virus = new ArrayList<>();
	static List<Pair> wall = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());

				if (map[n][m] == 0) {
					wall.add(new Pair(n, m));
				}
				if (map[n][m] == 2) {
					virus.add(new Pair(n, m));
				}
			}
		}
		wallCount = wall.size();
		makeWall(0, 0, new int[3]);

		System.out.println(answer);
	}

	static void makeWall(int count, int start, int[] choose) {
		if (count == 3) {
			safeCount(choose);
			return;
		}

		for (int i = start; i < wallCount; i++) {
			choose[count] = i;
			makeWall(count + 1, i + 1, choose);
		}
	}

	static void safeCount(int[] choose) {

		int[][] temp = new int[N][M];

		for (int n = 0; n < N; n++) {
			temp[n] = map[n].clone();
		}

		for (int i = 0; i < 3; i++) {
			Pair p = wall.get(choose[i]);
			temp[p.x][p.y] = 1;
		}

		Queue<Pair> queue = new LinkedList<>();

		for (int i = 0; i < virus.size(); i++) {
			queue.offer(virus.get(i));
		}

		while (!queue.isEmpty()) {
			Pair p = queue.poll();
			int x = p.x;
			int y = p.y;
			
			for(int i = 0; i < 4; i++) {
				int nX = x + delta[i][0];
				int nY = y + delta[i][1];
				if(isIn(nX,nY) && temp[nX][nY] == 0) {
					temp[nX][nY] = 2;
					queue.offer(new Pair(nX,nY));
				}
			}
		}
		
		int count = 0;
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				if(temp[n][m] == 0) {
					count ++;
				}
			}
		}
		answer = Math.max(answer, count);
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < M) {
			return true;
		}
		return false;
	}

	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
