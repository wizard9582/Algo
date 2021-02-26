package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class q2836 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());

		List<int[]> list = new ArrayList<>();

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (a - b > 0) {
				list.add(new int[] { a, b });
			}
		}

		Collections.sort(list, (e1, e2) -> {
			return e2[0] - e1[0];
		});

		long back = 0;
		int start = 0, end = 0;
		boolean flag = true;

		for (int i = 0; i < list.size(); i++) {
			if (flag) {
				start = list.get(i)[0];
				end = list.get(i)[1];
				flag = false;
			} else {
				if (end <= list.get(i)[0]) {
					end = Math.min(list.get(i)[1],end);

				} else {
					back += start - end;
					start = list.get(i)[0];
					end = list.get(i)[1];
				}

			}
		}

		if (!flag) {
			back += start - end;
		}

		System.out.println(M + (2 * back));
	}
}