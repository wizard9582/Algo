package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2563 {
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] white = new int[100][100];
		
		int N = Integer.parseInt(br.readLine());
		int x,y;
		
		for(int n =0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			for(int i = x; i < x+10; i++) {
				for(int j = y; j < y+10; j++) {
					white[i][j] = 1;
				}
			}
		}
		
		int answer = 0;
		
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				answer += white[i][j];
			}
		}
		
		System.out.println(answer);
	}
}