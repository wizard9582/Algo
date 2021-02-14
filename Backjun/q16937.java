package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class q16937 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());

		int N = Integer.parseInt(br.readLine());
		LinkedList<int[]> list = new LinkedList<>();
		int answer = 0;

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if ((a > H && a > W) || (b > H && b > W)) {
				continue;
			}
			if (a * b >= H * W) {
				continue;
			}
			list.add(new int[] { a, b, a * b, n });
			list.add(new int[] { b, a, a * b, n });
		}

		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (i == j) {
					continue;
				}
				int[] a = list.get(i);
				int[] b = list.get(j);
				
				if(a[3] == b[3]) {
					continue;
				}else {
					if(Math.max(a[0], b[0]) <= H && a[1] + b[1] <= W) {
						answer = Math.max(answer, a[2]+b[2]);
					}
					else if(Math.max(a[1], b[1]) <= W && a[0]+b[0] <= H) {
						answer = Math.max(answer, a[2]+b[2]);
					}
				}
			}
		}

		System.out.println(answer);
	}
}
