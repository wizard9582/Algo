package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1292_BOJ_쉽게푸는문제 {
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[1001];
		int idx = 1, num = 1;
		loop: while(true) {
			for(int i = 0; i < num; i++) {
				arr[idx++] = num;
				if(idx == 1001) {
					break loop;
				}
			}
			num++;
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int answer = 0;
		
		for(int i = start; i <= end; i++) {
			answer += arr[i];
		}
		
		System.out.println(answer);
	}
}
