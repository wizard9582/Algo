package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q10773 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stack = new int[N];
		int size = 0;
		int x = 0;

		for (int n = 0; n < N; n++) {
			x = Integer.parseInt(br.readLine());
			if (x == 0 && 0 < size) {
				size--;
			} else {
				stack[size] = x;
				size++;
			}
		}
		int sum = 0;
		for (int n = 0; n < size; n++) {
			sum += stack[n];
		}
		System.out.println(sum);
	}
}
