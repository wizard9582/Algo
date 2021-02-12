package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q11866 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			queue.add(i);
		}

		int count = 0;
		sb.append("<");
		
		while (!queue.isEmpty()) {

				count++;
				if (count == K) {
					sb.append(queue.remove()).append(", ");
					count = 0;
				}else {
					queue.add(queue.remove());
				}
		}
		String str = sb.substring(0, sb.length()-2);
		System.out.println(str+">");
	}
}