package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q16953 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int to = Integer.parseInt(st.nextToken());
		int from = Integer.parseInt(st.nextToken());

		Queue<int[]> queue = new LinkedList<>();
		boolean flag = false;
		int count = 0;

		queue.offer(new int[] { from, 1 });

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			
			if(now[0] < to) {
				break;
			}

			if (now[0] == to) {
				count = now[1];
				flag = true;
				break;
			} else {

				if (now[0] % 2 == 0) {
					queue.offer(new int[] { now[0] / 2, now[1] + 1 });
					
				} else if (now[0] % 10 == 1) {
					queue.offer(new int[] { now[0] / 10, now[1] + 1 });
				}else {
					break;
				}

			}

		}

		if (flag) {
			System.out.println(count);
		} else {
			System.out.println(-1);
		}
	}
}
