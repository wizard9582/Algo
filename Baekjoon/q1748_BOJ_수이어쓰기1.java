package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1748_BOJ_수이어쓰기1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int count = 1;
		int nine = 9;
		int answer = 0;
		
		while(N > 0) {
			if(N > nine) {
				answer += (nine * count);
				N -= nine;
			}else {
				answer += (N * count);
				N = 0;
			}
			
			nine *= 10;
			count ++;
		}
		
		System.out.println(answer);
	}
}
