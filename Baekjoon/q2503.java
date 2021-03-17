package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2503 {
	static StringTokenizer st;
	static boolean[][][] num = new boolean[10][10][10];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int count = 0;
		int[] ball = new int[5];
		
		check();

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int number = Integer.parseInt(st.nextToken());
			ball[0] = number/100;
			ball[1] = (number%100)/10;
			ball[2] = number%10;
			ball[3] = Integer.parseInt(st.nextToken());
			ball[4] = Integer.parseInt(st.nextToken());

			int s = 0;
			int b = 0;
			for (int i = 1; i < 10; i++) {
				for (int j = 1; j < 10; j++) {
					for (int k = 1; k < 10; k++) {
						s = 0;
						b = 0;
						if(num[i][j][k]) {
							if(ball[0] == i) {
								s++;
							}
							if(ball[1] == i || ball[2] == i) {
								b++;
							}
							if(ball[1] == j) {
								s++;
							}
							if(ball[0] == j || ball[2] == j) {
								b++;
							}
							if(ball[2] == k) {
								s++;
							}
							if(ball[0] == k || ball[1] == k) {
								b++;
							}
							
							if(s!=ball[3] || b!=ball[4]) {
								num[i][j][k] = false;
							}
						}
					}
				}
			}
			
		}

		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				for (int k = 1; k < 10; k++) {
						if(num[i][j][k]) count++;
				}
			}
		}
		
		System.out.println(count);
	}
	
	static void check() {
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				for (int k = 1; k < 10; k++) {

					if (i != j && j != k && k != i) {
						num[i][j][k] = true;
					}

				}
			}
		}
	}
}
