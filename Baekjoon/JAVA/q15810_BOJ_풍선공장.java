package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q15810_BOJ_풍선공장 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		long N = Integer.parseInt(st.nextToken());
		long M = Integer.parseInt(st.nextToken());
		long[] staffs = new long[(int) N];

		st = new StringTokenizer(br.readLine());
		long min = Integer.MAX_VALUE;
		for (int n = 0; n < N; n++) {
			staffs[n] = Integer.parseInt(st.nextToken());
			min = Math.min(min, staffs[n]);
		}
		
		long left = 0;
		long right = min * M;
		
		while(left+1 < right) {
			long center = (left + right)/2;
			long balloon = 0;
			
			for (int n = 0; n < N; n++) {
				balloon += (center / staffs[n]);
			}
			
			if(balloon >= M) {
				right = center;
			}else {
				left = center;
			}
		}
		
		System.out.println(right);
	}
}
