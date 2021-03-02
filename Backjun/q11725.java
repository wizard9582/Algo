package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class q11725 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static List<LinkedList> list = new ArrayList<>();
	static int[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		visited = new int[N + 1];

		for (int n = 0; n <= N; n++) {
			list.add(new LinkedList<Integer>());
		}

		for (int n = 1; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			list.get(a).add(b);
			list.get(b).add(a);
		}
		visited[1] = 1;
		search(1);
		
		for (int n = 2; n <= N; n++) {
			sb.append(visited[n]).append("\n");
		}

		System.out.println(sb);
	}

	static void search(int now) {

		List nowList = list.get(now);

		for (int i = 0; i < nowList.size(); i++) {
			int next = (int) nowList.get(i);
			if (visited[next] == 0) {
				visited[next] = now;
				search(next);
			}
		}
	}
}
