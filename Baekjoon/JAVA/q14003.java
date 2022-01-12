package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class q14003 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			arr[n] = stoi(st.nextToken());
		}

		int[] from = new int[N];

		List<Integer> list = new ArrayList<>();
		list.add(arr[0]);
		int size = 1;
		from[0] = 1;

		for (int n = 1; n < N; n++) {
			int num = arr[n];

			if (num > list.get(size - 1)) {
				list.add(num);
				size++;
				from[n] = size;
			} else {
				int temp = Collections.binarySearch(list, num);
				if (temp < 0) {
					temp = Math.abs(temp) - 1;
					if (num < list.get(temp)) {
						list.set(temp, num);
					}
					from[n] = temp + 1;
				}
			}

		}

		sb.append(size).append("\n");

		Stack<Integer> stack = new Stack<>();

		for (int n = N - 1; n >= 0; n--) {
			if(size == 0) {
				break;
			}
			if(from[n] == size) {
				size--;
				stack.push(arr[n]-1000000000);
			}
		}
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}
		
		System.out.println(sb);
	}

	static int stoi(String str) {
		int num = Integer.parseInt(str);
		return num + 1000000000;
	}
}
