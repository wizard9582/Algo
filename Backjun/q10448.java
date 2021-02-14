package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q10448 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] tn = new int[50];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int n = 1; n < 50; n++) {
			tn[n] = n + tn[n - 1];
		}
		
		for (int n = 0; n < N; n++) {
			boolean flag = false;
			int num = Integer.parseInt(br.readLine());

			loop: for (int i = 1; i < 50; i++) {
				for (int j = 1; j < 50; j++) {
					for (int k = 1; k < 50; k++) {
						if(tn[i]+tn[j]+tn[k] == num) {
							flag = true;
							break loop;
						}
					}
				}
			}

			if (flag) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}

		System.out.println(sb);
	}
}
