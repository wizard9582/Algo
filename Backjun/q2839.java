package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q2839 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int i,flag = 0;
		
		for(i = N/5; i>-1; i--) {
			if((N - 5*i)%3==0) {
			flag = 1;
			break;	
			}
		}
		
		if(flag == 1) {
			System.out.println( i + (N - 5*i)/3);
		}
		else System.out.println(-1);
	}
}
