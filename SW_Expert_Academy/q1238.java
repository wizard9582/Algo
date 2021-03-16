package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1238 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int answer, max;
		
		for(int tc = 1; tc <= 10 ; tc++){
			answer = 0;
			max = 0;
			int[][] map = new int[101][101];
			boolean[] visit = new boolean[101];
			
			st = new StringTokenizer(br.readLine());
			int input = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			for(int n = 0; n < input; n+=2) {
				map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
			}
			
			Queue<int[]> queue = new LinkedList<>();
			
			queue.offer(new int[] {start,0});
			visit[start] = true;
			
			while(!queue.isEmpty()) {
				
				int now = queue.peek()[0];
				int stage = queue.poll()[1];
				
				if(stage == max) {
					if(now > answer) {
						answer = now;
						max = stage;
					}
				}else if(stage > max) {
					answer = now;
					max = stage;
				}
				
				for(int n = 1; n <= 100; n++) {
					if(map[now][n] == 1 && !visit[n]) {
						visit[n] = true;
						queue.offer(new int[] {n,stage+1});
					}
				}
				
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
	}
}
