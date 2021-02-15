package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q17089 {
	static StringTokenizer st;
	static int[] friend;
	static boolean[][] relation;
	static int N, M, answer = Integer.MAX_VALUE;
	static boolean flag = false;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		friend = new int[N + 1];
		relation = new boolean[N + 1][N + 1];

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			friend[a]++;
			friend[b]++;
			relation[a][b] = true;
			relation[b][a] = true;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = i + 1; j <= N; j++) {
				if (relation[i][j]) {
					for (int k = j + 1; k <= N; k++) {
						if(relation[j][k] && relation[k][i]) {
							answer = Math.min(answer, friend[i] + friend[j] + friend[k] - 6);
							flag = true;
						}
					}
				}
			}
		}

		if (flag) {
			System.out.println(answer);
		} else {
			System.out.println(-1);
		}
	}
}
