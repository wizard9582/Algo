package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1251 {
	static char[] arr;
	static int l;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = br.readLine().toCharArray();
		l = arr.length;
		
		String answer = "";
		
		boolean flag = true;
		
		for(int i = 0; i < l-2; i++) {
			for(int j = i+1; j < l-1; j++) {
				
				if(flag) {
					flag = false;
					answer = makeStr(i,j);
					
				}else {
					String now = makeStr(i,j);
					if(answer.compareTo(now) > 0) {
						answer = String.valueOf(now);
					}
				}
			}
		}
		
		System.out.println(answer);
	}
	
	static String makeStr(int first, int second) {
		StringBuilder sb = new StringBuilder();
		
		for(int i = first ; i > -1; i--) {
			sb.append(arr[i]);
		}
		for(int i = second ; i > first; i--) {
			sb.append(arr[i]);
		}
		for(int i = l-1 ; i > second; i--) {
			sb.append(arr[i]);
		}
		
		return sb.toString();
	}
}
