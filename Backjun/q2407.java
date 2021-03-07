package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class q2407 {
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		BigInteger[][] map = new BigInteger[101][101];
		
		map[0][0] = new BigInteger("1");
		map[1][0] = new BigInteger("1");
		map[1][1] = new BigInteger("1");
		
		for(int n = 2; n <= 100; n++) {
			for(int m = 0; m <= n; m++) {
				if(n==m || m==0) {
					map[n][m] = new BigInteger("1");
				}else {
					map[n][m] = map[n-1][m-1].add(map[n-1][m]);
				}
			}
		}
		
		System.out.println(map[N][M]);
	}
}
