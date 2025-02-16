package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q16562 {
	static StringTokenizer st;
	static int[] parent;
	static int[] rank;
	static boolean[] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int money = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		parent = new int[N + 1];
		rank = new int[N + 1];
		visit = new boolean[N + 1];

		for (int n = 1; n <= N; n++) {
			parent[n] = n;
			rank[n] = Integer.parseInt(st.nextToken());
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		int answer = 0;
		for (int n = 1; n <= N; n++) {
			int x = findParent(n);
			if(!visit[x]) {
				visit[x] = true;
				answer += rank[x];
			}
		}

		if (answer > money) {
			System.out.println("Oh no");
		} else {
			System.out.println(answer);
		}
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

		if (x == y) {
			return;
		}

		if (rank[x] < rank[y]) {
			parent[y] = x;

		} else {
			parent[x] = y;

		}
	}
}
