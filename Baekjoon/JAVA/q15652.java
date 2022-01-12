package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q15652 {
	static int N, M;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		recur(M, new int[M], 0);

		System.out.println(sb);
	}

	static void recur(int count, int[] choose, int start) {
		if(count == 0) {
			for(int i =0; i<M; i++) {
				sb.append(choose[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = start; i<N; i++) {
			choose[M-count] = i+1;
			recur(count-1, choose, i);
		}
	}
}
