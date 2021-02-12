package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class q1228 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		LinkedList<Integer> list;

		int T = 10;
		int N, idx, count, num;

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			list = new LinkedList<>();
			st = new StringTokenizer(br.readLine());

			for (int n = 0; n < N; n++) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			for (int n = 0; n < N; n++) {
				st.nextToken();
				idx = Integer.parseInt(st.nextToken());
				count = Integer.parseInt(st.nextToken());

				for (int i = 0; i < count; i++) {
					num = Integer.parseInt(st.nextToken());
					list.add(idx + i, num);
				}
			}

			sb.append("#").append(tc).append(" ");

			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
