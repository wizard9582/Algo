package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q11404 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] route = new int[N+1][N+1];
		int B = Integer.parseInt(br.readLine());
		int a,b,c;
		
		for(int n = 1; n <= N; n++) {
			Arrays.fill(route[n], 10000001);
		}
		
		for(int i = 0; i < B ; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			route[a][b] = Math.min(route[a][b], c);
		}
		
		for(int n = 1; n <= N; n++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if( i==n || j==n || i==j) {
						continue;
					}
					else {
						route[i][j] = Math.min(route[i][j], route[i][n] + route[n][j]);
					}
				}
			}
		}
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(route[i][j] == 10000001) {
					sb.append(0).append(" ");
				}
				else {
				sb.append(route[i][j]).append(" ");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
