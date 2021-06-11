package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q_summer_SWEA_좀비아파트 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M, H;
	static int[][][] apart;
	static int[][] delta = { { 0, -1, 0 }, { 0, 1, 0 }, { 0, 0, -1 }, { 0, 0, 1 }, { -1, 0, 0 }, { 1, 0, 0 } };
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T ; tc++){
			int answer = -1;
			
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			apart = new int[H][N][M];

			Queue<int[]> queue = new LinkedList<>();

			for (int h = 0; h < H; h++) {
				for (int n = 0; n < N; n++) {
					st = new StringTokenizer(br.readLine());
					for (int m = 0; m < M; m++) {
						apart[h][n][m] = Integer.parseInt(st.nextToken());
						if (apart[h][n][m] == 1) {
							queue.offer(new int[] { h, n, m});
						}
					}
				}
			}
			
			if(checkZombie()) {
				sb.append("#").append(tc).append(" ALL HUMANS\n");
			}else {
				
				while (!queue.isEmpty()) {
					
					int size = queue.size();
					answer ++;
					while(size-->0) {
						int[] now = queue.poll();
						int h = now[0];
						int x = now[1];
						int y = now[2];

						for (int i = 0; i < 6; i++) {
							int nH = h + delta[i][0];
							int nX = x + delta[i][1];
							int nY = y + delta[i][2];

							if (isIn(nH, nX, nY) && apart[nH][nX][nY] == -1) {
								queue.offer(new int[] { nH, nX, nY });
								apart[nH][nX][nY] = 1;
							}
						}
					}
				}
				
				if(!checkZombie()) {
					sb.append("#").append(tc).append(" STILL ZOMBIES\n");
				}else {
					sb.append("#").append(tc).append(" ").append(answer).append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}
	static boolean checkZombie() {
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if (apart[h][n][m] == -1) return false;
				}
			}
		}
		
		return true;
	}
	static boolean isIn(int h, int x, int y) {
		if (0 <= h && h < H && 0 <= x && x < N  && 0 <= y && y < M) {
			return true;
		}
		return false;
	}
}
