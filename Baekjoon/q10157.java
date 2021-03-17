package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q10157 {
	static StringTokenizer st;
	static int[][] delta = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		if (C * R < K) {
			System.out.println(0);
		} else {

			int num = 0, x = 1, y = 0, d = 0;

			loop : while (true) {
				for (int i = 0; i < R; i++) {
					x += delta[d][0];
					y += delta[d][1];
					num++;
					if (num == K) {
						break loop;
					}
				}
				d ++;
				for (int a = 1;;) {

					for (int i = 0; i < C - a; i++) {
						x += delta[d][0];
						y += delta[d][1];
						num++;
						if (num == K) {
							break loop;
						}
					}
					d = (d+1)%4;
					for (int i = 0; i < R - a; i++) {
						x += delta[d][0];
						y += delta[d][1];
						num++;
						if (num == K) {
							break loop;
						}
					}
					d = (d+1)%4;

						a++;
				}
			}
			
			System.out.println(x + " " + y);
		}
	}
}