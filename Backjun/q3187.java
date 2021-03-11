package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q3187 {
	static StringTokenizer st;
	static int[][] delta = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];
		boolean[][] visit = new boolean[N][M];

		for (int n = 0; n < N; n++) {
			String str = br.readLine();
			for (int m = 0; m < M; m++) {
				map[n][m] = str.charAt(m);
			}
		}

		int wolf = 0;
		int sheep = 0;
		int nowWolf, nowSheep;

		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (!visit[n][m] && (map[n][m] == 'v' || map[n][m] == 'k')) {
					nowWolf = 0;
					nowSheep = 0;
					Queue<int[]> queue = new LinkedList<>();
					queue.offer(new int[] {n,m});
					visit[n][m] = true;
					
					while(!queue.isEmpty()) {
						int[] now = queue.poll();
						int x = now[0];
						int y = now[1];
						char c = map[x][y];
						
						if(c == 'v') {
							nowWolf++;
						}else if(c == 'k'){
							nowSheep++;
						}
						
						for(int i = 0; i < 4; i++) {
							int nX = x + delta[i][0];
							int nY = y + delta[i][1];
							
							if(isIn(nX,nY) && !visit[nX][nY]) {
								if(map[nX][nY] == '#') {
									visit[nX][nY] = true;
								}else {
									queue.offer(new int[] {nX,nY});
									visit[nX][nY] = true;
								}
							}
						}
					}
					if(nowWolf < nowSheep) {
						sheep += nowSheep;
					}else {
						wolf += nowWolf;
					}

				}
			}
		}
		
		System.out.println(sheep + " " + wolf);

	}

	static boolean isIn(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < M) {
			return true;
		}
		return false;
	}
}
