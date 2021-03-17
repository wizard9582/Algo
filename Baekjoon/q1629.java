package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1629 {
	static StringTokenizer st;
	static int C;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		System.out.println(divide(A, B)%C);

	}

	static long divide(int A, int B) {
		if (B == 0) {
			return 1;
		} else if (B == 1) {
			return A;
		}
		if (B % 2 == 1) {
			long num = divide(A, B / 2) % C;
			num = (num * num) % C;
			return (num * A) % C;
		}

		long num = divide(A, B / 2) % C;
		return (num * num) % C;
	}
}
