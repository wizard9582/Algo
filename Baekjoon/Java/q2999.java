package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2999 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int l = str.length();
		int R = 1,C = l;
		
		for(int i = 1 ; i <= l/2; i++) {
			for(int j = 1 ; j <= l; j++) {
				if( i * j == l && i <= j) {
					R = i;
					C = j;
				}
				if(i*j > l) break;
			}
		}
		
		char[][] map = new char[R][C];
		
		for(int i = 0; i < l; i++) {
				map[i%R][i/R]= str.charAt(i);
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				sb.append(map[i][j]);
			}
		}
		
		System.out.println(sb);
	}
}
