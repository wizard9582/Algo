package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2422 {
	static StringTokenizer st;
	static int N, M, answer;
	static boolean [][] hate;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		hate = new boolean[N+1][N+1];

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			hate[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
		}
		
		Combination(0,1,new int[3]);
		
		System.out.println(answer);
	}
	
	static void Combination(int count, int start, int[] choosed) {
		if(count == 3) {
			
			for(int i =0; i < 3; i ++) {
				for(int j =0; j < 3; j ++) {
					if(i!=j && hate[choosed[i]][choosed[j]]) {
						return;
					}
				}
			}
			answer ++;
			return;
		}
		for(int n=start; n<=N; n++) {
			choosed[count] = n;
			Combination(count+1, n+1, choosed);
		}
	}
}
