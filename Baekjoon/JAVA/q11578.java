package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q11578 {
	static StringTokenizer st;
	static int N, M, answer, finish;
	static int[] student;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		student = new int[M];
		finish = (1 << (N + 1)) - 1;

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int Q = Integer.parseInt(st.nextToken());
			student[m] = 1;
			for (int q = 0; q < Q; q++) {
				student[m] += 1 << Integer.parseInt(st.nextToken());
			}
		}

		int check = 1;
		for (int m = 0; m < M; m++) {
			check = check | student[m];
		}
		
		if(check != finish) {
			System.out.println(-1);
			return;
		}else {
			answer = Integer.MAX_VALUE;
			powerset(0, 0, 1);
			System.out.println(answer);
		}
	}

	static void powerset(int start, int count, int solved) {
		if(count >= answer) {
			return;
		}
		if (solved == finish) {
			answer = Math.min(answer, count);
			return;
		}
		if(start == M) {
			if (solved == finish) {
				answer = Math.min(answer, count);
			}
			return;
		}

		for (int i = start; i < M; i++) {
			powerset(i + 1, count, solved);
			powerset(i + 1, count + 1, solved | student[i]);
		}
	}
}
