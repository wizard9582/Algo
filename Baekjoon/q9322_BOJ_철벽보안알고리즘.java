package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class q9322_BOJ_철벽보안알고리즘 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T ; tc++){
			
			int N = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split(" ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			HashMap<String,Integer> map = new HashMap<>();
			
			for(int n =0; n < N; n++) {
				map.put(st.nextToken(), n);
			}
			
			int[] key = new int[N];
			
			for(int n =0; n < N; n++) {
				key[n] = map.get(arr[n]);
			}
			
			String[] answer = br.readLine().split(" ");
			
			for(int n = 0; n < N; n++) {
				sb.append(answer[key[n]]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}