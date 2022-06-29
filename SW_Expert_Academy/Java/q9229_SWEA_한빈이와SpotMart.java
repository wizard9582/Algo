package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q9229_SWEA_한빈이와SpotMart {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int answer, N, M;
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int[] bong;
		
		for (int tc = 1; tc <= T; tc++) {
			answer = -1;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			bong = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int n =0; n<N; n++) {
				bong[n] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<N; i++) {
				for(int j=i+1; j<N; j++) {
					if(bong[i] + bong[j] <=M) {
						answer = Math.max(answer, bong[i] + bong[j]);
					}
				}
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}
}
