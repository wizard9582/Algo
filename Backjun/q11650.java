package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q11650 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] pArr = new int[N][2];
		StringTokenizer st = new StringTokenizer("");

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pArr[i][0] = Integer.parseInt(st.nextToken());
			pArr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(pArr, (e1, e2) -> {
			if(e1[0] == e2[0]) {
				return e1[1] - e2[1];
			}
			else {
				return e1[0] - e2[0];
			}
		});

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N; i++) {
			sb.append(pArr[i][0]).append(" ").append(pArr[i][1]).append("\n");
		}
		System.out.println(sb);
	}
}