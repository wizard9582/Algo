package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q1251_SWEA_하나로 {
	static StringBuilder sb = new StringBuilder();
	static long[][] island;
	static boolean[] visit;
	static int[] parents;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		double answer;

		for (int tc = 1; tc <= T; tc++) {
			answer = 0;
			N = Integer.parseInt(br.readLine());
			StringTokenizer stX = new StringTokenizer(br.readLine());
			StringTokenizer stY = new StringTokenizer(br.readLine());
			double E = Double.parseDouble(br.readLine());

			island = new long[N][2];
			visit = new boolean[N];
			parents = new int[N];
			for (int n = 0; n < N; n++) {
				parents[n] = n;
			}

			for (int n = 0; n < N; n++) {
				island[n][0] = Long.parseLong(stX.nextToken());
				island[n][1] = Long.parseLong(stY.nextToken());
			}

			PriorityQueue<Line> queue = new PriorityQueue<>();
			queue.offer(new Line(-1, 0, 0));
			visit[0] = true;
			
			while (!queue.isEmpty()) {
				Line now = queue.poll();
				
				if(!union(now.x, now.y)) {
					continue;
				}
				
				answer += now.cost;
				visit[now.y] = true;
				addLine(queue, now.y);
			}
			answer *= E;
			sb.append("#").append(tc).append(" ").append(Math.round(answer)).append("\n");
		}

		System.out.println(sb);
	}

	static class Line implements Comparable<Line> {
		int x, y; 
		long cost;

		Line(int x, int y, long cost) {
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Line o) {
			return Long.compare(this.cost, o.cost);
		}
	}

	static int find(int x) {
		if (parents[x] == x) {
			return x;
		}

		return parents[x] = find(parents[x]);
	}

	static boolean union(int a, int b) {
		
		if(a == -1) {
			return true;
		}
		
		int ParentsA = find(a);
		int ParentsB = find(b);

		if (ParentsA != ParentsB) {
			parents[ParentsB] = ParentsA;
			return true;
		}

		return false;
	}
	static void addLine(PriorityQueue<Line> queue, int x) {
		for (int n = 0; n < N; n++) {
			if(!visit[n]) {
				long cost = (island[x][0]-island[n][0])*(island[x][0]-island[n][0]) + (island[x][1]-island[n][1])*(island[x][1]-island[n][1]);
				queue.offer(new Line(x,n,cost));
			}
		}
	}
}
