package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q11723 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int bitmask = 0;
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			
			String str = st.nextToken();
			
			switch (str) {
			case "add":
				bitmask = bitmask | (1 << Integer.parseInt(st.nextToken())-1);
				break;
			case "remove":
				int num = Integer.parseInt(st.nextToken());
				if(0 < (bitmask & (1 << num-1))) {
					bitmask = bitmask ^ (1 << num-1);
				}
				break;
			case "check":
				if(0 < (bitmask & (1 << Integer.parseInt(st.nextToken())-1))) {
					sb.append("1\n");
				}else{
					sb.append("0\n");
				}
				break;
			case "toggle":
				bitmask = bitmask ^ (1 << Integer.parseInt(st.nextToken())-1);
				break;
			case "all":
				for(int i = 0; i <20; i++) {
					bitmask = bitmask | (1 << i);
				}
				break;
			case "empty":
				bitmask = 0;
				break;
			}
		}
		System.out.println(sb);
	}
}
