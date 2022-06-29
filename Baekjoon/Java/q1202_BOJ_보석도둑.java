package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q1202_BOJ_보석도둑 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		PriorityQueue<int[]> pqueue = new PriorityQueue<int[]>((e1, e2) -> {
			return e2[1] - e1[1];
		});
		int[][] jewels = new int[N][2];
		int[] bags = new int[K];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			jewels[n][0] = Integer.parseInt(st.nextToken());
			jewels[n][1] = Integer.parseInt(st.nextToken());
		}

		for (int k = 0; k < K; k++) {
			bags[k] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(jewels, (e1, e2) -> {
			return e1[0] - e2[0];
		});
		Arrays.sort(bags);

		int index = 0;
		long answer = 0;

		for (int k = 0; k < K; k++) {
			int nowBag = bags[k];

			while (index < N) {
				if (jewels[index][0] <= nowBag) {
					pqueue.add(jewels[index].clone());
					index++;
				} else {
					break;
				}
			}
			if(!pqueue.isEmpty()) {
				answer += pqueue.poll()[1];
			}
		}

		System.out.println(answer);
	}
}