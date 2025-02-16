package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;

public class q1038_BOJ_감소하는수 {
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Long> list = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		if (N > 1022) {
			sb.append(-1);
		} else {

			for (int i = 0; i < 10; i++) {
				solution(i, 0);
			}
			Collections.sort(list);
			sb.append(list.get(N));
		}

		System.out.println(sb);
	}

	static void solution(long num, int idx) {
		if (idx > 9) {
			return;
		}
		list.add(num);
		for (int i = 0; i < num % 10; i++) {
			solution((num * 10) + i, idx + 1);
		}
	}
}

//public class q1038_BOJ_감소하는수 {
//	static StringBuilder sb = new StringBuilder();
//	static LinkedList<Long> list = new LinkedList<>();
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//		int N = Integer.parseInt(br.readLine());
//
//		if (N > 1022) {
//			sb.append(-1);
//		} else {
//
//			for (int i = 0; i < 10; i++) {
//				solution(i, 0);
//			}
//			Collections.sort(list);
//			sb.append(list.get(N));
//		}
//
//		System.out.println(sb);
//	}
//
//	static void solution(long num, int idx) {
//		if (idx > 9) {
//			return;
//		}
//		list.add(num);
//		for (int i = 0; i < num % 10; i++) {
//			solution((num * 10) + i, idx + 1);
//		}
//	}
//}
