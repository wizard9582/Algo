package backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q14889 {
	static int[][] stat;
	static int half, N, result = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		stat = new int[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				stat[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		half = N/2;
		
		boolean[] pick = new boolean[N];
		
		Combination(0,1,pick);
		pick[0] = true;
		Combination(1,1,pick);
		
		System.out.println(result);
	}
	static void Combination(int count, int start, boolean[] pick) {
		if(count == half) {
			result = Math.min(result, Sum(pick));
			return;
		}
		for(int i =start; i < N; i++) {
			pick[i] = true;
			Combination(count+1, i+1, pick);
			pick[i] = false;
		}
	}

	static int Sum(boolean use[]){
		int sumA = 0;
		int sumB = 0;

        for(int i =0; i < use.length; i++) {
            for(int j =i+1; j < use.length; j++) {
            	if(use[i] && use[j]) {
            		sumA += stat[i][j];
            		sumA += stat[j][i];
            	}
            	if(!use[i] && !use[j]) {
            		sumB += stat[i][j];
            		sumB += stat[j][i];
            	}
            }
        }
		return Math.abs(sumA - sumB);
	}
}