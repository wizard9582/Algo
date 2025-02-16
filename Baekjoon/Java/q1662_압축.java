package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1662 {
	static String str;
	static boolean[] visit = new boolean[50];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		int answer;
		
		answer = unzip(0);
		System.out.println(answer);
	}
	
	static int unzip(int idx) {
		int answer = 0;
		int num = 0;
		
		for(int i = idx; i < str.length(); i++) {
			if('0' <= str.charAt(i) && str.charAt(i) <= '9' && !visit[i]) {
				visit[i] = true;
				answer ++;
			}
			else if(str.charAt(i) == '(' && !visit[i]) {
				visit[i] = true;
				num = str.charAt(i-1) - '0';
				answer = answer - 1 + num * unzip(i+1);
			}
			else if(str.charAt(i) == ')' && !visit[i]){
				visit[i] = true;
				return answer;
			}
		}
		return answer;
	}
}
