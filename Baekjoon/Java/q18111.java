package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q18111 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int[][] field = new int[N][M];
		int sum = 0;
		
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < M; j++) {
				field[i][j] = Integer.parseInt(st.nextToken());
				sum += field[i][j];
			}
		}
		
		sum = sum + B;
		int max = sum / (M*N);
		int time = Integer.MAX_VALUE;
		int height = -1;
		
		for(int n = 0; n<=max; n++) {
			int t = 0;
			for(int i = 0 ; i < N; i++) {
				for(int j = 0 ; j < M; j++) {
					if(field[i][j] < n) {
						t += (n - field[i][j]);
					}
					else if(field[i][j] == n) {
						continue;
					}
					if(field[i][j] > n) {
						t += (field[i][j] - n)*2;
					}
				}
			}
			if(t <= time ) {
				time = t;
				height = n;
			}
		}
		System.out.println(time +" "+ height);
	}
}
