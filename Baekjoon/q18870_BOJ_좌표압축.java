package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q18870_BOJ_좌표압축 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		int[] answer = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int n = 0 ; n < N ; n++) {
			arr[n][0] = Integer.parseInt(st.nextToken());
			arr[n][1] = n;
		}
		
		Arrays.sort(arr, (e1,e2)->{
			return e1[0] - e2[0];
		});
		
		int before = arr[0][0], idx = 0;
		answer[arr[0][1]] = idx;
		
		
		for(int n = 1 ; n < N ; n++) {
			if(before == arr[n][0]) {
				answer[arr[n][1]] = idx;
			}else {
				before = arr[n][0];
				answer[arr[n][1]] = ++idx;
			}
		}
		
		for(int n = 0; n < N; n++) {
			sb.append(answer[n]).append(" ");
		}
		
		System.out.println(sb);
	}
}
