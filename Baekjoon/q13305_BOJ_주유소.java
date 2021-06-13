package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q13305_BOJ_주유소 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		long answer = 0;
		
		long lastMin = Integer.MAX_VALUE;
		for(int n = 1; n < N; n++) {
			long distance = Long.parseLong(st1.nextToken());
			long gas = Long.parseLong(st2.nextToken());
			lastMin = Math.min(lastMin, gas);
			
			answer += distance * lastMin;
		}
		
		System.out.println(answer);
	}
}
