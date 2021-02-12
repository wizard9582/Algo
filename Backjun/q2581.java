package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q2581 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int min = 0;
		int sum = 0;
		int check;

		for (int i = M; i <= N; i++) {
			check = 0;
			if(i == 1)continue;

			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					check = 1;
					break;
				}
			}

			if (check == 0) {
				if (sum == 0) {
					min = i;
				}
				sum += i;
			}
		}
		
		if(sum == 0) System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
}
