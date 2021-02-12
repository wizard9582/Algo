package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class q15655 {
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static List<Integer> num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		num = new ArrayList<Integer>();

		for (int i = 0; i < N; i++) {
			num.add(Integer.parseInt(st.nextToken()));
		}

		Collections.sort(num);
		recur(M, new int[M], 0);
		System.out.println(sb);
	}

	static void recur(int count, int[] choose, int start) {
		if(count == 0) {
			for(int i = 0; i < M; i++) {
				sb.append(choose[i]).append(" ");
			}
			sb.append("\n");
			return ;
		}
		
		for(int i = start; i<N; i++) {
			choose[M-count] = num.get(i);
			recur(count-1,choose,i+1);
		}
	}
}
