package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1149 {
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N+1][3];	//0 = lastR ,1 = lastG ,2 = lastB
		
		for(int n = 1; n <= N; n++) {
		st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		map[n][0] = R + Math.min(map[n-1][1], map[n-1][2]);
		map[n][1] = G + Math.min(map[n-1][0], map[n-1][2]);
		map[n][2] = B + Math.min(map[n-1][0], map[n-1][1]);
		
		}
		
		System.out.println(Math.min(map[N][0], Math.min(map[N][1], map[N][2])));
	}
}

