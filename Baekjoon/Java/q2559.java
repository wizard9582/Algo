package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2559 {
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] num = new int[N];
		
		for(int n =0; n < N; n++) {
			num[n ]= Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		for(int k =0; k < K; k++) {
			answer += num[k];
		}
		int compare = answer;
		
		for(int i = K; i < N; i++) {
			compare = compare + num[i] - num[i-K];
			answer = Math.max(answer, compare);
		}
		
		System.out.println(answer);
	}
}

