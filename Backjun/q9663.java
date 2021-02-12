package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class q9663 {
	static int[] chess;
	static int N,count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		chess = new int[N];
		Queen(0);
		System.out.println(count);
	}
 
	static void Queen(int d) {
		if (d == N) {
			count++;
			return;
		}
		for (int i = 0; i < N; i++) {
			chess[d] = i;
			if (Possibility(d)) {
				Queen(d + 1);
			}
		}
	}
 
	static boolean Possibility(int d) {
		for (int i = 0; i < d; i++) {
			if (chess[d] == chess[i]) {
				return false;
			} 
			if ((d - i)*(d - i) == (chess[d] - chess[i])*(chess[d] - chess[i])) {
				return false;
			}
		}
		return true;
	}
}
