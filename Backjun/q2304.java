package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class q2304 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int Big = 0;
		Stack<Integer> stack = new Stack<>();

		int N = Integer.parseInt(br.readLine());
		int[] pillar = new int[1001];

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			pillar[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}

		for (int n = 1; n < 1001; n++) {
			if (pillar[Big] <= pillar[n]) {
				Big = n;
			}
		}

		int answer = 0;
		int x1 = 0, x2 = 0;
		for (int n = 1; n < Big; n++) {
			if (pillar[n] != 0) {
				if (stack.isEmpty()) {
					stack.push(pillar[n]);
					x1 = n;
				} else {
					if (stack.peek() < pillar[n]) {
						x2 = n;
						answer += stack.pop() * (x2 - x1);
						x1 = x2;
						stack.push(pillar[n]);
					}
				}
			}
		}
		
		if (stack.isEmpty()) {
			answer += pillar[Big];
		}
		else {
			x2 = Big;
			answer += stack.pop() * (x2 - x1);
			answer += pillar[Big];
		}
		
		for (int n = 1000; n >= Big; n--) {
			if (pillar[n] != 0) {
				if (stack.isEmpty()) {
					stack.push(pillar[n]);
					x1 = n;
				} else {
					if (stack.peek() < pillar[n]) {
						x2 = n;
						answer += stack.pop() * (x1 - x2);
						x1 = x2;
						stack.push(pillar[n]);
					}
				}
			}
		}

		System.out.println(answer);
	}
}
