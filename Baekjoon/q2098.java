package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2098 {
	static StringTokenizer st;
	static int N, finish, inf = 987654321;
	static int[][] map;
	static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		finish = (1 << N) - 1;
		dp = new int[N][finish+1];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for (int m = 0; m < N; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}

		System.out.println(tsp(0, 1));
	}

	static int tsp(int now, int visit) {
		
		if (visit == finish) {
			if (map[now][0] == 0) {
				return inf;
			} else {
				return dp[now][visit] = map[now][0];
			}
		}
		
		if (dp[now][visit] != 0) {
			return dp[now][visit];
		}
		
		dp[now][visit] = inf;
		for (int i = 0; i < N; i++) {
			if ((visit & (1 << i)) == 0 && (map[now][i] != 0)) {
				dp[now][visit] = Math.min(dp[now][visit], map[now][i] + tsp(i, visit + (1 << i)));
			}
		}

		return dp[now][visit];
	}
}
