package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q10989 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[10001];
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0 ; i < N ; i++) {
			num[Integer.parseInt(br.readLine())] ++;
		}
		
		for(int i = 1 ; i < 10001 ; i++) {
			if(num[i]!=0) {
				for(int j = 0; j < num[i]; j++) {
					sb.append(i).append("\n");
				}
			}
		}
		
		System.out.println(sb);
	}
}
