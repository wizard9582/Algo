package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q9935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = br.readLine();
		String bomb = br.readLine();
		
		char[] answer = new char[str.length()];
		int size = 0;
		
		char c;
		char last = bomb.charAt(bomb.length()-1);
		boolean flag = false;
		
		for(int i = 0; i < str.length(); i++) {
			c = str.charAt(i);
			answer[size++] = c;
			
			if(c == last && bomb.length() <= size) {
				flag = false;
				for(int j = 0; j < bomb.length() ; j++) {
					if(answer[size - bomb.length()+j] == bomb.charAt(j)) {
						flag = true;
					}else {
						flag = false;
						break;
					}
				}
				if(flag == true) {
					size -= bomb.length();
					flag = false;
				}
			}
		}
		
		if(size == 0) {
			System.out.println("FRULA");
		}else {
			for(int i = 0; i < size; i++) {
				sb.append(answer[i]);
			}
			System.out.println(sb);
		}
		
	}
}
