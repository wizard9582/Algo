package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q1865_BOJ_웜홀 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M, W;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			int[] times = new int[N + 1];
			Arrays.fill(times, 5_000_000);
			Edge[] edges = new Edge[2 * M + W];
			int idx = 0;

			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());

				edges[idx++] = new Edge(from, to, weight);
				edges[idx++] = new Edge(to, from, weight);
			}

			for (int w = 0; w < W; w++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken()) * (-1);

				edges[idx++] = new Edge(from, to, weight);
			}
			
			times[1] = 0;
			for(int n = 1; n < N; n++) {
				for(int e = 0; e < edges.length; e++) {
					Edge edge = edges[e];
					
					if(times[edge.from] + edge.weight < times[edge.to]) {
						times[edge.to] = times[edge.from] + edge.weight;
					}
				}
			}
			
			String answer = "NO";
			
			for(int e = 0; e < edges.length; e++) {
				Edge edge = edges[e];
				
				if(times[edge.from] + edge.weight < times[edge.to]) {
					answer = "YES";
				}
			}
			sb.append(answer).append("\n");

		}
		System.out.print(sb);
	}

	static class Edge {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

	}
}
