package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1966 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<int[]> queue = new LinkedList<>();
		int[] num = new int[10];
		int T = Integer.parseInt(br.readLine());

		int N, M, count, a, Max;

		for (int tc = 0; tc < T; tc++) {
			count = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int n = 0; n < N; n++) {
				a = Integer.parseInt(st.nextToken());
				queue.offer(new int[] { n, a });
				num[a]++;
			}
			
			Max = 9;
			
			loop : while (!queue.isEmpty()) {
				if(num[Max] == 0) {
					Max --;
				}
				else {
					if(queue.peek()[1] == Max) {
						count++;
						num[Max]--;
						if(queue.poll()[0] == M) {
							break loop;
						}
					}else {
						queue.offer(queue.poll());
					}
				}
			}
			
			queue.clear();
			Arrays.fill(num, 0);
			sb.append(count).append("\n");
		}
		System.out.println(sb);
	}
}
