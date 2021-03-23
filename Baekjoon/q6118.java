package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q6118 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		boolean[] visit = new boolean[N+1];

		for (int n = 0; n <= N; n++) {
			list.add(new ArrayList<>());
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		visit[1] = true;
		int answer = 0;
		int size = 0;
		int dis = -1;
		
		while(!queue.isEmpty()) {
			size = queue.size();
			answer = Integer.MAX_VALUE;
			dis ++;
			for(int s = 0; s < size; s++) {
				
				int now = queue.poll();
				answer = Math.min(now, answer);
				
				for(int i = 0; i < list.get(now).size(); i++) {
					int next = list.get(now).get(i);
					
					if(!visit[next]) {
						visit[next] = true;
						queue.offer(next);
					}
				}
				
			}
		}
		
		System.out.printf("%d %d %d\n", answer, dis, size);
	}
}