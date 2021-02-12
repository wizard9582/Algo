package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1233 {
	static boolean flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = 10;
		char c;
		
		for(int tc = 1; tc <= T ; tc++){
			int N = Integer.parseInt(br.readLine());
			flag = true;
			
			for(int n = 1; n<=N; n++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				c = st.nextToken().charAt(0);
				
				if( c == '-' || c == '+' || c == '*' || c == '/') {
					if(!st.hasMoreTokens()) {
						flag = false;
						continue;
					}
				}else {
					if(st.hasMoreTokens()) {
						flag = false;
						continue;
					}
				}
			}
			if(flag) {
			sb.append("#").append(tc).append(" ").append(1).append("\n");
			}else {
				sb.append("#").append(tc).append(" ").append(0).append("\n");
			}
		}
		System.out.println(sb);
	}
}
