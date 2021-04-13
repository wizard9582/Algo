package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q10966_SWEA_물놀이를가자 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		int answer;

		for (int tc = 1; tc <= T; tc++) {

			answer = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			boolean[][] visit = new boolean[N][M];

			Queue<int[]> queue = new LinkedList<>();

			for (int n = 0; n < N; n++) {
				String str = br.readLine();
				for (int m = 0; m < M; m++) {
					if (str.charAt(m) == 'W') {
						visit[n][m] = true;
						queue.add(new int[] { n, m, 0 });
					}
				}
			}

			while (!queue.isEmpty()) {
				int[] now = queue.poll();
				int x = now[0];
				int y = now[1];
				int l = now[2];
				answer += l;

				for (int i = 0; i < 4; i++) {
					int nX = x + delta[i][0];
					int nY = y + delta[i][1];
					
					if(isIn(nX,nY) && !visit[nX][nY]) {
						visit[nX][nY] = true;
						queue.offer(new int[] {nX,nY,l+1});
					}
				}
			}

			sb.append("#").append(tc).append(" ").append(answer).append("\n");
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
