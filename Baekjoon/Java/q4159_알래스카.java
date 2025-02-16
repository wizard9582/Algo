package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q4159_BOJ_알래스카 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			if(N == 0) {
				break;
			}
			
			int[] arr = new int[N];
			for(int n = 0; n < N; n++) {
				arr[n] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(arr);
			
			int last = 0;
			boolean flag = true;
			for(int n = 1; n < N; n++) {
				if(arr[n] <= last + 200) {
					last = arr[n];
				}else {
					flag = false;
					break;
				}
			}
			
			if(arr[N-1] < 1322) {
				flag = false;
			}
			
			if(flag) {
				sb.append("POSSIBLE\n");
			}else {
				sb.append("IMPOSSIBLE\n");
			}
		}

		System.out.println(sb);
	}
}
