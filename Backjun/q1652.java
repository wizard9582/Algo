package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1652 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		int count = 0;
		int a = 0, b = 0;
		
		for(int i = 0; i < N; i++) {
			boolean flag = true;
			count = 0;
			for(int j = 0; j < N; j++) {
				if(map[i][j] == '.') {
					count ++;
				}else {
					count = 0;
					flag = true;
				}
				
				if(count > 1 && flag) {
					a++;
					flag = false;
				}
			}
		}
		for(int i = 0; i < N; i++) {
			boolean flag = true;
			count = 0;
			for(int j = 0; j < N; j++) {
				if(map[j][i] == '.') {
					count ++;
				}else {
					count = 0;
					flag = true;
				}
				
				if(count > 1 && flag) {
					b++;
					flag = false;
				}
			}
		}
		
		System.out.printf("%d %d",a,b);
	}
}