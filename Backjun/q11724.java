package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q11724 {
	static StringTokenizer st;
	static int N, M;
	static boolean[][] map;
	static boolean[] visit;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new boolean[N + 1][N + 1];
		visit = new boolean[N + 1];

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = true;
			map[b][a] = true;
		}

		int answer = 0;
		
		for (int n = 1; n <= N; n++) {
			if(!visit[n]) {
				dfs(n);
				answer ++;
			}
		}

		System.out.println(answer);
	}
	static void dfs(int n) {
		visit[n] = true;
		
		for (int i = 1; i <= N; i++) {
			if(map[n][i] && !visit[i]) {
				dfs(i);
			}
		}
		
	}
}
