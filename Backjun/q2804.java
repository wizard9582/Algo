package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2804 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		String str1 = st.nextToken();
		String str2 = st.nextToken();
		
		int a =0, b=0;
		
		loop : for(int i = 0; i < str1.length(); i++) {
			char c = str1.charAt(i);
			for(int j = 0; j < str2.length(); j++) {
				if(c == str2.charAt(j)) {
					a = i;
					b = j;
					break loop;
				}
			}
		}
		
		for(int i = 0; i < str2.length(); i++) {
			for(int j = 0; j < str1.length(); j++) {
				if(j == a) {
					sb.append(str2.charAt(i));
				}else if(i == b) {
					sb.append(str1.charAt(j));
				}else {
					sb.append('.');
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
