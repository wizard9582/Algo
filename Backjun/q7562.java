package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q7562 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] delta = { { -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 } };
	static int N;
	static boolean[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			Queue<int[]> queue = new LinkedList<>();
			N = Integer.parseInt(br.readLine());
			map = new boolean[N][N];
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());

			queue.add(new int[] { startX, startY, 0 });
			map[startX][startY] = true;
			
			while (!queue.isEmpty()) {
				int[] now = queue.poll();
				int nowX = now[0];
				int nowY = now[1];
				
				if(nowX == endX && nowY == endY) {
					sb.append(now[2]).append("\n");
					break;
				}
				
				for(int i = 0; i < 8; i++) {
					int newX = nowX + delta[i][0];
					int newY = nowY + delta[i][1];
					
					if(isIn(newX,newY) && !map[newX][newY]) {
						map[newX][newY] = true;
						queue.add(new int[] {newX,newY,now[2]+1});
					}
				}

			}
		}

		System.out.println(sb);
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < N) {
			return true;
		}
		return false;
	}
}
