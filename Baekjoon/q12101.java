package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q12101 {
	static int count, k, N;
	static StringBuilder sb = new StringBuilder("-1");
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			count = 0;
			recur(0, new int[N], 0, 0);

		System.out.println(sb);
	}

	static void recur(int d, int[] choose, int sum, int idx) {
		if (sum == N) {
			count++;
			if(count == k) {
				sb = new StringBuilder();
				for(int i = 0; i < d-1; i++) {
					sb.append(choose[i]).append("+");
				}
				sb.append(choose[d-1]);
			}
			return;
		}
		if (sum > N) {
			return;
		}

		for (int i = 1; i < 4; i++) {
			choose[idx] = i;
			recur(d+1, choose, sum + i, idx + 1);
		}
	}
}
