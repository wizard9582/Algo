package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class q2164 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Queue<Integer> queue = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int n = 1; n <= N; n++) {
			queue.offer(n);
		}
		
		for(int n = 1; n < N; n++) {
			queue.poll();
			queue.offer(queue.poll());
		}

		System.out.println(queue.poll());
	}
}
