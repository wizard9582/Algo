package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q3182 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] map = new int[N+1];
		
		for(int n = 1; n <= N; n++) {
			
			map[n] = Integer.parseInt(br.readLine());
			
		}
		
		int answer = 0;
		int Max = 0, now = 0;
		for(int n = 1; n <= N; n++) {
			boolean[] visit = new boolean[N+1];
			now = 1;
			int next = map[n];
			visit[n] = true;
			
			while(!visit[next]) {
				now++;
				visit[next] = true;
				next = map[next];
			}
			
			if(Max < now) {
				Max = now;
				answer = n;
			}
		}
		
		System.out.println(answer);
	}
}
