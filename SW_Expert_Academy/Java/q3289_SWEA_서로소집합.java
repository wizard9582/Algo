package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q3289_SWEA_서로소집합 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			parent = new int[N + 1];
			for (int n = 1; n <= N; n++) {
				parent[n] = n;
			}

			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());

				if (Integer.parseInt(st.nextToken()) == 0) {

					union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

				} else {
					int answer = isUnion(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
					sb.append(answer);
				}
			}

			sb.append("\n");
		}

		System.out.println(sb);
	}

	static int findParent(int x) {
		if (x == parent[x]) {
			return x;
		}

		else {
			parent[x] = findParent(parent[x]);
			return parent[x];
		}
	}

	static void union(int x, int y) {

		x = findParent(x);
		y = findParent(y);

		if (x != y) {
			parent[y] = x;
		}
	}

	static int isUnion(int x, int y) {
		x = findParent(x);
		y = findParent(y);

		if (x == y) {
			return 1;
		}

		return 0;
	}
}
