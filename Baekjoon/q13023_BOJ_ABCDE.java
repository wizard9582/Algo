package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class q13023_BOJ_ABCDE {
	static StringTokenizer st;
	static ArrayList<ArrayList<Integer>> list;
	static boolean[] visited;
	static boolean flag;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		list = new ArrayList<ArrayList<Integer>>();
		visited = new boolean[N];

		for (int n = 0; n < N; n++) {
			list.add(new ArrayList<Integer>());
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list.get(from).add(to);
			list.get(to).add(from);
		}

		for (int n = 0; n < N; n++) {
			visited[n] = true;
			dfs(n, 1);
			visited[n] = false;
			if (flag) {
				break;
			}
		}

		if (flag) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	static void dfs(int now, int count) {
		if (count == 5) {
			flag = true;
			return;
		}

		ArrayList<Integer> nowList = list.get(now);
		for (int i = 0; i < nowList.size(); i++) {
			int next = nowList.get(i);
			if (!visited[next]) {
				visited[next] = true;
				dfs(next, count + 1);
				visited[next] = false;
			}
		}
		return;
	}
}
