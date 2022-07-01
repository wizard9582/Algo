package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q11285_SWEA_다트게임Re {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T, TC, sum, x, y;
		T = Integer.parseInt(br.readLine());

		for (int t = 1; t < T + 1; t++) {
			TC = Integer.parseInt(br.readLine());
			sum = 0;

			for (int tc = 0; tc < TC; tc++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				int far = (x * x) + (y * y);

				if (40000 < far)
					sum += 0;

				else if (32400 < far)
					sum += 1;

				else if (25600 < far)
					sum += 2;

				else if (19600 < far)
					sum += 3;

				else if (14400 < far)
					sum += 4;

				else if (10000 < far)
					sum += 5;

				else if (6400 < far)
					sum += 6;

				else if (3600 < far)
					sum += 7;

				else if (1600 < far)
					sum += 8;

				else if (400 < far)
					sum += 9;

				else
					sum += 10;
			}
			sb.append("#").append(t).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
