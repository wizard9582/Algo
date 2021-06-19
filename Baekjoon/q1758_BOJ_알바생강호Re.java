package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q1758_BOJ_알바생강호Re {
	static Integer[] customer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		customer = new Integer[N];

		for (int n = 0; n < N; n++) {
			customer[n] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(customer, (e1,e2)->{
			return e2-e1;
		});

		long answer = 0l;

		for (int n = 0; n < N; n++) {
			answer += Math.max((long) customer[n] - n, 0);
		}

		System.out.println(answer);
	}
}
