package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2583 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		boolean[][] map = new boolean[N][M];

		for (int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			for (int i = y1; i < y2; i++) {
				for (int j = x1; j < x2; j++) {
					map[i][j] = true;
				}
			}
		}

		int answer = 0;
		Queue<int[]> queue = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (!map[n][m]) {
					answer++;
					map[n][m] = true;
					queue.add(new int[] {n,m});
					int size = 0;
					
					while(!queue.isEmpty()) {
						int x = queue.peek()[0];
						int y = queue.poll()[1];
						size ++;
						
						for(int i =0; i < 4; i++) {
							int nX = x + delta[i][0];
							int nY = y + delta[i][1];
							
							if(isIn(nX,nY) && !map[nX][nY]) {
								map[nX][nY] = true;
								queue.offer(new int[] {nX,nY});
							}
							
						}
					}
					list.add(size);
				}
			}
		}
		
		sb.append(answer).append("\n");
		
		Collections.sort(list);
		
		for(int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append(" ");
		}

		System.out.println(sb);
	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < M) {
			return true;
		}
		return false;
	}
}
