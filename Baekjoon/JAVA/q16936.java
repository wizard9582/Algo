package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q16936 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static class num{
		public long l = 0;
		public int three = 0;
		public int two = 0;
		
		public num() {
			this.l = 0;
			this.three = 0;
			this.two = 0;
		}
		
		public num(long l, int three, int two){
			this.l = l;
			this.three = three;
			this.two = two;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		num[] list = new num[N];
		st = new StringTokenizer(br.readLine());

		for (int n = 0; n < N; n++) {
			long a = Long.parseLong(st.nextToken());
			list[n] = new num(a,three(a),two(a));
		}

		Arrays.sort(list, (e1, e2) -> {
			if (e1.three == e2.three) {
				return e1.two - e2.two;
			} else {
				return e2.three - e1.three;
			}

		});

		for (int n = 0; n < N; n++) {
			long b = list[n].l;
			sb.append(b).append(" ");
		}

		System.out.println(sb);
	}

	static int two(long a) {
		int count = 0;
		while (true) {
			if (a % 2 != 0) {
				break;
			} else {
				a /= 2;
				count++;
			}
		}
		return count;
	}

	static int three(long a) {
		int count = 0;
		while (true) {
			if (a % 3 != 0) {
				break;
			} else {
				a /= 3;
				count++;
			}
		}
		return count;
	}
}
