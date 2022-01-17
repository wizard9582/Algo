package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1717_BOJ_집합의표현 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] num;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		num = new int[N + 1];
		
		for(int n = 0; n <= N; n++) {
			num[n] = n;
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());

			int order = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(order == 0) {
				union(a,b);
			}else {
				if(check(a,b)) {
					sb.append("YES\n");
				}else {
					sb.append("NO\n");
				}
			}
		}

		System.out.println(sb);
	}

	static private void union(int a, int b) {
		if(a == b) {
			return;
		}
		num[find(a)] = find(b);
	}

	static private int find(int a) {
		if (num[a] == a) {
			return a;
		}

		return num[a] = find(num[a]);
	}

	static private boolean check(int a, int b) {
		
		int aParent = find(a);
		int bParent = find(b);
		
		return aParent == bParent;
	}
}
