package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q14696 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int A, B, num;
		int[] cardA, cardB;

		for (int n = 0; n < N; n++) {
			boolean flag = true;
			cardA = new int[5]; 
			cardB = new int[5];
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			for (int a = 0; a < A; a++) {
				num = Integer.parseInt(st.nextToken());
				cardA[num]++;
			}

			st = new StringTokenizer(br.readLine());
			B = Integer.parseInt(st.nextToken());
			for (int b = 0; b < B; b++) {
				num = Integer.parseInt(st.nextToken());
				cardB[num]++;
			}

			for (int i = 4; i > 0; i--) {
				if (cardA[i] > cardB[i]) {
					sb.append("A").append("\n");
					flag = false;
					break;
				}
				if (cardA[i] < cardB[i]) {
					sb.append("B").append("\n");
					flag = false;
					break;
				}
			}
			if (flag) {
				sb.append("D").append("\n");
			}
		}

		System.out.println(sb);
	}
}
