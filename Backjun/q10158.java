package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q10158 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());

		int a = (p + t) % w;
		int b = (q + t) % h;

		if (((p + t) / w) % 2 == 1) {
			p = w - a;
		} else {
			p = a;
		}
		if (((q + t) / h) % 2 == 1) {
			q = h - b;
		} else {
			q = b;
		}

		System.out.println(p + " " + q);

	}
}
