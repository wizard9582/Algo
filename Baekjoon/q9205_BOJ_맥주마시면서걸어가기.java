package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q9205_BOJ_맥주마시면서걸어가기 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			boolean flag = false;
			int N = Integer.parseInt(br.readLine());
			int[][] list = new int[N+2][2];
			
			for(int n = 0; n < N+2; n++) {
				st = new StringTokenizer(br.readLine());
				list[n][0] = Integer.parseInt(st.nextToken());
				list[n][1] = Integer.parseInt(st.nextToken());
			}
			
			boolean[][] map = new boolean[N+2][N+2];
			
			for(int n = 0; n < N+2; n++) {
				for(int m = n+1; m < N+2; m++) {
					if(Math.abs(list[n][0] - list[m][0]) + Math.abs(list[n][1] - list[m][1]) <= 1000) {
						map[n][m] = true;
						map[m][n] = true;
					}
				}
			}
			
			Queue<Integer> queue = new LinkedList<>();
			boolean[] visit = new boolean[N+2];
			queue.offer(0);
			visit[0] = true;
			
			while(!queue.isEmpty()) {
				
				int now = queue.poll();
				if(now == N+1) {
					flag = true;
					break;
				}
				
				for(int n = 0; n < N+2; n++) {
					if(map[now][n] && !visit[n]) {
						visit[n] = true;
						queue.offer(n);
					}
				}
				
			}
			
			if(flag) {
				sb.append("happy\n");
			}else {
				sb.append("sad\n");
			}
		}
		
		System.out.println(sb);
	}
}
