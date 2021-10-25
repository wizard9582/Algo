package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2527_BOJ_직사각형 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i =0; i < 4 ; i++) {
			st = new StringTokenizer(br.readLine());
			int A1 = Integer.parseInt(st.nextToken());
			int A2 = Integer.parseInt(st.nextToken());
			int A3 = Integer.parseInt(st.nextToken());
			int A4 = Integer.parseInt(st.nextToken());
			
			int B1 = Integer.parseInt(st.nextToken());
			int B2 = Integer.parseInt(st.nextToken());
			int B3 = Integer.parseInt(st.nextToken());
			int B4 = Integer.parseInt(st.nextToken());
			
			if(B3 < A1 || A3 < B1 || B4 < A2 || A4 < B2) {
				sb.append("d\n");
			}else if((A3 == B1 &&(A2 == B4 || A4 == B2))||(B3 == A1 &&(B2 == A4 || B4 == A2))) {
				sb.append("c\n");
			}else if((A3 == B1 && A4 != B2) || (A1 == B3 && A4 != B2) || (A3 != B1 && A2 == B4) || (A1 != B3 && A2 == B4)) {
				sb.append("b\n");
			}else {
				sb.append("a\n");
			}
		}
		
		System.out.println(sb);
	}
}
