package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class q1620 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] strArr = new String[N+1];
		Map<String, Integer> map = new HashMap<>();
		
		for(int n =1; n <=N; n++) {
			strArr[n] = br.readLine();
			map.put(strArr[n], n);
		}
		for(int m = 0; m < M; m++) {
			String str = br.readLine();
			if(1<= str.charAt(0) - '0' && str.charAt(0) - '0' <= 9) {
				sb.append(strArr[Integer.parseInt(str)]).append("\n");
			}else {
				sb.append(map.get(str)).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
