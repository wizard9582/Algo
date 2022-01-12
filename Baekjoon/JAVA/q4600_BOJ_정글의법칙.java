package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q4600_BOJ_정글의법칙 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			st = new StringTokenizer(br.readLine());
			int B = Integer.parseInt(st.nextToken())*-1;
			int P = Integer.parseInt(st.nextToken());

			if (B == 0 && P == 0) {
				break;
			}
			int[] trees = new int[B + 1];
			trees[0] = P;
			trees[B] = -P;
			int[][] bridges = new int[B][2];
			int[][] groups = new int[B][2];
			int totalTime = 0;

			for (int b = 0; b < B; b++) {
				st = new StringTokenizer(br.readLine());
				bridges[b][0] = Integer.parseInt(st.nextToken());
				bridges[b][1] = Integer.parseInt(st.nextToken());
			}

			while (trees[B] < 0) {
				int time = Integer.MAX_VALUE;
				for (int b = 0; b < B; b++) {
					if (trees[b] > 0 && groups[b][0] == 0) {
						groups[b][0] = Math.min(trees[b], bridges[b][0]);
						groups[b][1] = bridges[b][1];
						trees[b] -= groups[b][0];
					}
					if (groups[b][1] > 0) {
						time = Math.min(groups[b][1], time);
					}
				}

				totalTime += time;

				for (int b = 0; b < B; b++) {
					if (groups[b][1] > 0) {
						groups[b][1] -= time;
						if (groups[b][1] == 0) {
							trees[b + 1] += groups[b][0];
							groups[b][0] = 0;
						}
					}
				}
			}
			sb.append(totalTime).append("\n");
		}

		System.out.println(sb);
	}
}
