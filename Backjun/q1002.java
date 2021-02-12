package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1002 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());

			check(x1, y1, x2, y2, r1, r2);
		}
	}

	public static void check(int x1, int y1, int x2, int y2, int r1, int r2) {
		int d = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
		int r = (r1 + r2) * (r1 + r2);
		int rn = (r1 - r2) * (r1 - r2);

		if (x1 == x2 && y1 == y2 && r1 == r2) {
			System.out.println(-1);
		}
		else if(d > r) {
			System.out.println(0);
		}
		else if(d < rn) {
			System.out.println(0);
		}
		else if(rn == d) {
			System.out.println(1);
		}
		else if(r == d) {
			System.out.println(1);
		}
		else {
			System.out.println(2);
		}
	}
}
