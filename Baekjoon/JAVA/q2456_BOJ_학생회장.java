package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class q2456_BOJ_학생회장 {
	static int[][] cand = new int[][] { { 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 2 }, { 0, 0, 0, 0, 3 } };
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			cand[0][0] += a;
			cand[1][0] += b;
			cand[2][0] += c;

			cand[0][a]++;
			cand[1][b]++;
			cand[2][c]++;
		}

		/*Arrays.sort(cand, (e1, e2) -> {
			if (e1[0] != e2[0]) {
				return e2[0] - e1[0];
			} else if (e1[3] != e2[3]) {
				return e2[3] - e1[3];
			} else {
				return e2[2] - e1[2];
			}
		});*/
		
		Arrays.sort(cand, new Comparator<int[]>() {
			@Override
			public int compare(int[] e1, int[] e2) {
				if (e1[0] != e2[0]) {
					return e2[0] - e1[0];
				} else if (e1[3] != e2[3]) {
					return e2[3] - e1[3];
				} else {
					return e2[2] - e1[2];
				}
			}
		});

		if (cand[0][0] == cand[1][0] && cand[0][3] == cand[1][3] && cand[0][2] == cand[1][2]) {
			System.out.println("0"+ " " + cand[0][0]);
		} else {
			System.out.println(cand[0][4] + " " + cand[0][0]);
		}
	}
}