package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1018_BOJ_체스판다시칠하기 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		char[][] chess = new char[N][M];

		for (int n = 0; n < N; n++) {
			str = br.readLine();
			String[] strArr = str.split("");
			for (int m = 0; m < M; m++) {
				chess[n][m] = strArr[m].charAt(0);
			}
		}
		
		int min = 64;
		int minnow;
		
		for (int n = 0; n < N - 7; n++) {
			for (int m = 0; m < M - 7; m++) {

				int in = n;
				int jn = m;
				int W1 = 0, W2 = 0;
				for (int i = in; i < in+8; i++) {
					for (int j = jn; j < jn+8 ; j++) {
						if((i+j) %2 ==0) {
						if(chess[i][j] == 'W') W1++;
						}
						else {
							if(chess[i][j] == 'W') W2++;
						}
					}
				}
				minnow = Math.min((32-W1)+W2, (32-W2)+W1);
				min = Math.min(minnow, min);
			}
		}
		System.out.println(min);
	}
}
