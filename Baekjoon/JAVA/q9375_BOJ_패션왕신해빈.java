package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class q9375_BOJ_패션왕신해빈 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			ArrayList<String> list = new ArrayList<String>();

			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String category = st.nextToken();

				if (map.containsKey(category)) {
					int count = map.get(category);
					map.put(category, count + 1);
				} else {
					map.put(category, 1);
					list.add(category);
				}
			}

			int answer = 1;
			for (int i = 0; i < list.size(); i++) {
				answer *= map.get(list.get(i)) + 1;
			}
			sb.append(answer - 1).append("\n");
		}

		System.out.println(sb);
	}
}
