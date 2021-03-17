package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class q17952 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int point = 0;
		Stack<int[]> stack = new Stack<>();
		int[] hw = new int[2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			if (Integer.parseInt(st.nextToken()) == 1) {
				stack.push(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
			}
			if (!stack.isEmpty()) {
				hw = stack.pop();
				hw[1]--;
				if (hw[1] == 0) {
					point += hw[0];
				} else {
					stack.push(hw);
				}
			}
		}

		System.out.println(point);
	}
}
