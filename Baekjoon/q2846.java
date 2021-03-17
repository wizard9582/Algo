package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2846 {
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int answer = 0;
		st = new StringTokenizer(br.readLine());
		
		int start, before, now;
		start = Integer.parseInt(st.nextToken());
		before = start;
		
		for(int n =1; n < N; n++) {
			now = Integer.parseInt(st.nextToken());
			if(now > before) {
				answer = Math.max(answer, now-start);
			}else {
				start = now;
			}
			
			before = now;
		}
		
		System.out.println(answer);
	}
}
