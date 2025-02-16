package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2475 {
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		int N1 = Integer.parseInt(st.nextToken());
		int N2 = Integer.parseInt(st.nextToken());
		int N3 = Integer.parseInt(st.nextToken());
		int N4 = Integer.parseInt(st.nextToken());
		int N5 = Integer.parseInt(st.nextToken());
		
		int answer = N1*N1 + N2*N2 + N3*N3 + N4*N4 + N5*N5;
		answer %= 10;
		System.out.println(answer);
	}
}