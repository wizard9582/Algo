package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2096_BOJ_내려가기 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] before = new int[3];
		int[] max = new int[3];
		int[] min = new int[3];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(st.nextToken());
			int center = Integer.parseInt(st.nextToken());
			int right = Integer.parseInt(st.nextToken());

			before = max.clone();
			max[0] = Math.max(before[0], before[1]) + left;
			max[1] = Math.max(before[0], Math.max(before[1], before[2])) + center;
			max[2] = Math.max(before[1], before[2]) + right;

			before = min.clone();
			min[0] = Math.min(before[0], before[1]) + left;
			min[1] = Math.min(before[0], Math.min(before[1], before[2])) + center;
			min[2] = Math.min(before[1], before[2]) + right;
		}

		sb.append(Math.max(max[0], Math.max(max[1], max[2]))).append(" ").append(Math.min(min[0], Math.min(min[1], min[2])));
		
		System.out.println(sb);
	}
}
