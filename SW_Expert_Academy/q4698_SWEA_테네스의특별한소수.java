package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q4698_SWEA_테네스의특별한소수 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			int cnt = 0;

			int[] arr = new int[B + 1];
			arr[1] = 1;

			for (int i = 2; i < B + 1; i++) {
				if (arr[i] == 0) {
					for (int j = 2; i * j < B + 1; j++) {
						arr[i * j] = 1;
					}
				} else {
					continue;
				}
			}
			for (int i = A; i < B + 1; i++) {
				if (arr[i] == 0) {
					if (String.valueOf(i).contains(String.valueOf(D)))
						cnt++;
				}
			}

			sb.append("#").append(t).append(" ");
			sb.append(cnt).append("\n");
		}

		System.out.println(sb);
	}
}
