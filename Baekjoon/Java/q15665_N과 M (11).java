package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class q15665 {
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static int[] num;
	static LinkedHashSet<String> set = new LinkedHashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		num = new int[N];

		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(num);
		recur(M, new int[M]);

		for (String s : set) {
			sb.append(s);
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static void recur(int count, int[] choose) {
		if (count == 0) {
			StringBuilder s = new StringBuilder();
			for (int i = 0; i < M; i++) {
				s.append(choose[i]).append(" ");
			}
			set.add(s.toString());
			return;
		}

		for (int i = 0; i < N; i++) {
			choose[M - count] = num[i];
			recur(count - 1, choose);
		}
	}
}
