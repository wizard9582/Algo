package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1978 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] arr = new int[T];

		for (int i = 0; i < T; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] sosu = new int[1001];
		sosu[1] = 1;

		for (int i = 2; i < 1001; i++) {
			if (sosu[i] == 0) {
				int j = i;
				int k = 2;
				while (j * k < 1001) {
					sosu[j * k] = 1;
					k++;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < T; i++) {
			if(sosu[arr[i]] == 0) count++;
		}
		System.out.println(count);
	}
}
