package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q2775 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());

			int[][] arr = new int[15][14];

			for (int j = 0; j < 14; j++) {
				arr[0][j] = j + 1;
			}

			for (int j = 1; j < 15; j++) {
				for (int l = 0; l < 14; l++) {

					int sum = 0;

					for (int m = 0; m <= l; m++) {
						sum += arr[j-1][m];
					}

						arr[j][l] = sum;
				}
			}
			System.out.println(arr[k][n-1]);
		}
	}
}
