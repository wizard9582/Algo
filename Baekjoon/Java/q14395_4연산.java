package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q14395_BOJ_4연산 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long s = Long.parseLong(st.nextToken());
		long t = Long.parseLong(st.nextToken());

		if (s == t) {
			System.out.println("0");
		} else {
			HashSet<Long> set = new HashSet<>();
			Queue<node> queue = new LinkedList<>();
			queue.offer(new node(s, new int[50]));
			set.add(s);
			int count = 0;
			boolean flag = true;

			loop: while (!queue.isEmpty()) {
				int size = queue.size();

				while (size-- > 0) {
					node now = queue.poll();
					if (now.num == t) {
						printAnswer(count, now.op);
						flag = false;
						break loop;
					}

					long next = now.num * now.num;
					if (set.add(next)) {
						int[] nextop = now.op.clone();
						queue.offer(new node(next, nextop));
					}

					next = now.num * 2;
					if (set.add(next)) {
						int[] nextop = now.op.clone();
						nextop[count] = 1;
						queue.offer(new node(next, nextop));
					}

					next = 0;
					if (set.add(next)) {
						int[] nextop = now.op.clone();
						nextop[count] = 2;
						queue.offer(new node(next, nextop));
					}

					if (now.num != 0) {
						next = 1;
						if (set.add(next)) {
							int[] nextop = now.op.clone();
							nextop[count] = 3;
							queue.offer(new node(next, nextop));
						}
					}
				}
				count++;
				if(count == 50) {
					break;
				}
			}

			if (flag) {
				System.out.println("-1");
			}
		}
	}

	static void printAnswer(int count, int[] op) {
		StringBuilder sb = new StringBuilder();
		for (int c = 0; c < count; c++) {
			if (op[c] == 0) {
				sb.append("*");
			} else if (op[c] == 1) {
				sb.append("+");
			} else if (op[c] == 2) {
				sb.append("-");
			} else if (op[c] == 3) {
				sb.append("/");
			}
		}
		System.out.println(sb.toString());
	}

	static class node {
		long num;
		int[] op;

		node(long num, int[] op) {
			this.num = num;
			this.op = op;
		}
	}
}
