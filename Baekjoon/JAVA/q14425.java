package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class q14425 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> set = new HashSet<>();
		int answer = 0;
		
		for(int i = 0; i < N ; i++) {
			set.add(br.readLine());
		}
		
		for(int i = 0; i < M ; i++) {
			if(set.contains(br.readLine())) {
				answer ++;
			}
		}
		
		System.out.println(answer);
		
	}
}
