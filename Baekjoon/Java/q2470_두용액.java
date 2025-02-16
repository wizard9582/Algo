package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q2470_BOJ_두용액 {
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N ; n ++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		int left = 0, right = N-1;
		int min = arr[left], max = arr[right];
		int minGap = Math.abs(max + min);
		
		while(left < right) {
			int nMin = arr[left], nMax = arr[right];
			int nGap = Math.abs(nMax + nMin);
			
			if(nGap < minGap) {
				min = nMin;
				max = nMax;
				minGap = nGap;
			}
			
			if(nMax + nMin <= 0) { 
				left++; 
			}else{
				right--;
			}
		}
		System.out.println(min + " " + max);
	}
}