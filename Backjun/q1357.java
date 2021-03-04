package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1357 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		String str1 = new StringBuffer(st.nextToken()).reverse().toString();
		String str2 = new StringBuffer(st.nextToken()).reverse().toString();
		
		int num = Integer.parseInt(str1) + Integer.parseInt(str2);
		
		String answer = new StringBuffer(Integer.toString(num)).reverse().toString();
		
		System.out.println(Integer.parseInt(answer));
	}
}
