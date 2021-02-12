package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class q1914{
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		if( N <= 20) {
		System.out.println( (int)Math.pow(2, N)-1);
		hanoi(N, 1, 2 ,3);
		System.out.println(sb);
		}else {
			BigInteger num = new BigInteger("1");
			BigInteger one = new BigInteger("1");
			BigInteger two = new BigInteger("2");
			
			for(int i = 0; i < N; i++) {
				num = num.multiply(two);
			}
			System.out.println(num.subtract(one));
		}
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
