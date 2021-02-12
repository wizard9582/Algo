package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] num = new int[41][2];
		
		num[0][0] = 1;
		num[1][1] = 1;
		
		for(int i =2; i<41; i++) {
			num[i][0] = num[i-2][0] + num[i-1][0];
			num[i][1] = num[i-2][1] + num[i-1][1];
		}
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			String str = String.format("%d %d\n", num[N][0], num[N][1]);
			sb.append(str);
		}
		System.out.println(sb);
	}
}
