package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1105_BOJ_팔 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		long L = Long.parseLong(st.nextToken());
		long R = Long.parseLong(st.nextToken());
		long div = 1L;
		int count = 0;

		while (true) { 
			if (L / div == 0 && R / div == 0) {
				break;
			}

			long numL = (L / div) % 10;
			long numR = (R / div) % 10;
		 	
			//System.out.println(div + ":" + numL + " " + numR);
			
			if(numL == 8 && numR == 8) {
				count++;
			}else if(numL != numR) {
				count = 0;
			}

			div *= 10;
		}
		
		System.out.println(count);
	}
}
