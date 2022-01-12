package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q8320_BOJ_직사각형을만드는방법 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int answer = 0;
		
		for(int i = 1; i <= N; i++) {
			for(int j = i; i * j <= N; j++) {
				answer ++;
			}
		}
		System.out.println(answer);
	}
}
