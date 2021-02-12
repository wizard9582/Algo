package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q11729 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		System.out.println( (int)Math.pow(2, N)-1);
		hanoi(N, 1, 2 ,3);
		System.out.println(sb);
	}
	static void hanoi(int n, int from, int by, int to) {
		if (n == 1) {
			sb.append(from + " " + to + "\n");
			return;
		}
		else {
			hanoi(n - 1, from, to, by);
			sb.append(from + " " + to + "\n");
			hanoi(n - 1, by, from, to);
		}
	}
}
