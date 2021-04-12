package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1238Re_SWEA_Contact {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		
		for(int tc = 1; tc <= T ; tc++){
			int answer = 0;
			st = new StringTokenizer(br.readLine());
			int input = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[101][101];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < input; i+=2) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				map[from][to] = 1;
			}
			
			Queue<Integer> queue = new LinkedList<>();
			queue.offer(start);
			map[start][0] = 1;
			
			while(!queue.isEmpty()) {
				int size = queue.size();
				answer = 0;
				for(int s = 0; s < size; s++) {
					
					int now = queue.poll();
					answer = Math.max(answer, now);
					
					for(int i = 1; i <=100; i++) {
						if(map[now][i] == 1 && map[i][0] == 0) {
							map[i][0] = 1;
							queue.offer(i);
						}
					}
					
				}
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
	}
}
