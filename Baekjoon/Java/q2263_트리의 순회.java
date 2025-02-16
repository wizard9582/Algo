package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2263 {
	static int[] in, post, idx;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		in = new int[N];
		post = new int[N];
		idx = new int[N + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			in[n] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			post[n] = Integer.parseInt(st.nextToken());
		}
		for (int n = 0; n < N; n++) {
			idx[in[n]] = n;
		}

		find(0, N - 1, 0, N - 1);
		System.out.println(sb);
	}

	static void find(int leftStart, int leftEnd, int rightStart, int rightEnd) {
		
		if (leftStart > leftEnd || rightStart > rightEnd) {
			return;
		}
		
		int root = post[rightEnd];
		
		sb.append(root).append(" ");

		find(leftStart, idx[root] - 1, rightStart, idx[root] + rightStart - leftStart - 1);
		find(idx[root] + 1, leftEnd, idx[root] + rightStart - leftStart, rightEnd - 1);
	}
}
