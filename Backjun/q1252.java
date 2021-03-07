package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1252 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		String str1 = st.nextToken();
		String str2 = st.nextToken();
		
		int size = Math.max(str1.length(), str2.length());
		
		int[] first = new int[size];
		int[] second = new int[size];
		
		for(int i = 0, j = 0; i < size; i++) {
			if(size - str1.length() - i <= 0) {
				first[i] = str1.charAt(j++) - '0';
			}
		}
		for(int i = 0, j = 0; i < size; i++) {
			if(size - str2.length() - i <= 0) {
				second[i] = str2.charAt(j++) - '0';
			}
		}
		boolean flag = false;
		for(int i = size-1; i > -1; i--) {
			first[i] = first[i] + second[i];
			if(flag) {
				first[i]++;
			}
			if(first[i]>1) {
				flag = true;
				first[i] -=2;
			}else {
				flag = false;
			}
		}
		
		if(flag) {
			sb.append(1);
		}
		for(int i = 0; i < size; i++) {
			if(!flag && first[i] == 1) {
				flag = true;
			}
			
			if(flag) {
			sb.append(first[i]);
			}
		}
		
		
		if(flag) {
			System.out.println(sb);
		}else{
			System.out.println(0);
		}
	}
}
