package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q20040_BOJ_사이클게임 {
	static StringTokenizer st;
	static int[] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int answer = 0;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parent = new int[N];
		for (int n = 0; n < N; n++) {
			parent[n] = n;
		}

		for (int m = 1; m <= M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int aParent = findParent(a);
			int bParent = findParent(b);

			if (aParent == bParent) {
				answer = m;
				break;
			} else {
				parent[aParent] = bParent;
			}
		}

		System.out.println(answer);
	}

	static int findParent(int a) {
		if (parent[a] == a) {
			return a;
		} else {
			parent[a] = findParent(parent[a]);
			return parent[a];
		}
	}
}
