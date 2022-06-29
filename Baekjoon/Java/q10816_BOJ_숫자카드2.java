package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class q10816_BOJ_숫자카드2 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<Integer,Integer> map = new HashMap<>();
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int n = 0; n <N; n++) {
			int num = Integer.parseInt(st.nextToken());
			if(map.containsKey(num)) {
				map.put(num, map.get(num)+1);
			}else {
				map.put(num, 1);
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for(int m = 0; m < M; m++) {
			int num = Integer.parseInt(st.nextToken());
			
			if(map.containsKey(num)) {
				sb.append(map.get(num)).append(" ");
			}else {
				sb.append("0 ");
			}
		}
		
		System.out.println(sb);
	}
}
