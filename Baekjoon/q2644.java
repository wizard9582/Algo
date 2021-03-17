package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2644 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());

		boolean[][] map = new boolean[N + 1][N + 1];
		boolean[] visit = new boolean[N + 1];

		int M = Integer.parseInt(br.readLine());

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a][b] = true;
			map[b][a] = true;
		}
		
		Queue<int[]>queue = new LinkedList<>();
		queue.offer(new int[] {start,0});
		visit[start] = true;
		int answer = -1;
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			
			if(now[0] == goal) {
				answer = now[1];
				break;
			}
			
			for(int n = 1; n <= N; n++) {
				if(map[now[0]][n] && !visit[n]) {
					visit[n] = true;
					queue.offer(new int[] {n,now[1]+1});
				}
			}
		}
		
		System.out.println(answer);
	}
}
