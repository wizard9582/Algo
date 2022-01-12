package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2660_BOJ_회장뽑기 {
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int point = Integer.MAX_VALUE;
		ArrayList<Integer> candi = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

		for (int n = 0; n <= N; n++) {
			list.add(new ArrayList<Integer>());
		}

		while (true) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			if (from == -1 && to == -1) {
				break;
			}
			list.get(from).add(to);
			list.get(to).add(from);
		}

		for (int n = 1; n <= N; n++) {
			Queue<Integer> queue = new LinkedList<Integer>();
			boolean[] visited = new boolean[N + 1];
			int count = -1;

			queue.offer(n);
			visited[n] = true;

			while (!queue.isEmpty()) {
				int size = queue.size();
				count++;
				while (size-- > 0) {
					int now = queue.poll();
					ArrayList<Integer> nowList = list.get(now);
					for (int i = 0; i < nowList.size(); i++) {
						int next = nowList.get(i);
						if (!visited[next]) {
							visited[next] = true;
							queue.offer(next);
						}
					}
				}
			}
			if(count < point) {
				point = count;
				candi = new ArrayList<Integer>();
				candi.add(n);
			}else if(count == point) {
				candi.add(n);
			}
		}
		
		Collections.sort(candi);
		sb.append(point).append(" ").append(candi.size()).append("\n");
		
		for(int i=0; i < candi.size(); i++) {
			sb.append(candi.get(i)).append(" ");
		}

		System.out.println(sb);
	}
}
