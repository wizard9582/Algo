package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q4641_BOJ_Doubles {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr;
		
		loop : while(true) {
			st = new StringTokenizer(br.readLine());
			arr = new int[16];
			int idx = 0;
			int answer = 0;
			
			while(st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				if(num == -1) {
					break loop;
				}else if(num == 0) {
					break;
				}
				arr[idx] = num;
				idx++;
			}
			Arrays.sort(arr);
			for(int i = 16-idx; i < 16; i++) {
				int target = arr[i] * 2;
				for(int j = i+1; j < 16; j++) {
					if(arr[j] == target) {
						answer ++;
						break;
					}
				}
			}
			
			sb.append(answer).append("\n");
		}
		
		System.out.println(sb);
	}
}
