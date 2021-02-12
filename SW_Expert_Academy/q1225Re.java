package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1225Re {
	static int[] queue;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			queue = new int[8];
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 8; i++) {
				queue[i] = Integer.parseInt(st.nextToken());
			}
			int i = 0, j =1; 
			loop : while(true) {
					if(queue[i]-j <= 0) {
						queue[i] = 0;
						break loop;
					}
					else {
						queue[i] -= j;
					}
					if(i !=0 && i%7 == 0) {
						i = 0;
					}else {
						i++;
					}
					if(j%5 == 0) {
						j = 1;
					}else {
						j++;
					}
			}
			
			sb.append("#").append(tc);
			for (int k = i+1; k < 8; k++) {
				sb.append(" ").append(queue[k]);
			}
			for (int k = 0; k <=i; k++) {
				sb.append(" ").append(queue[k]);
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
