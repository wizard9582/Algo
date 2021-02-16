package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2961 {
	static StringTokenizer st;
	static int N, answer = Integer.MAX_VALUE;
	static int[][] food;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		food = new int[N][2];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			food[n][0] = Integer.parseInt(st.nextToken());
			food[n][1] = Integer.parseInt(st.nextToken());
		}

		powerset(0, 0);

		System.out.println(answer);

	}

	static void powerset(int flag, int Idx) {
		if (Idx == N) {
			if (flag == 0) {
				return;
			}
			int A = 1, B = 0;
			for (int i = 0; i < N; i++) {
				if ((flag & 1 << i) != 0) {
					A*= food[i][0];
					B+= food[i][1];
				}
			}
			answer = Math.min(answer, Math.abs(A-B));
			return;
		}

		powerset(flag | 1 << Idx, Idx + 1);
		powerset(flag, Idx + 1);
	}
}
