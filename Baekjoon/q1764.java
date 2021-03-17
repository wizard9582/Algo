package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class q1764 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<>();
		
		for(int n = 0; n < N; n++) {
			map.put(br.readLine(), 1);
		}
		int answer = 0;
		List<String> list = new ArrayList<>();
		for(int m = 0; m < M; m++) {
			String str = br.readLine();
			if(map.get(str) != null) {
				list.add(str);
				answer ++;
			}
		}
		Collections.sort(list);
		
		for(int i = 0; i<list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		
		System.out.println(answer);
		System.out.println(sb);
	}
}
