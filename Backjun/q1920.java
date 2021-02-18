package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class q1920 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		HashMap<Integer, Integer> map = new HashMap<>();
		int num = 0;

		for (int n = 0; n < N; n++) {
			num = Integer.parseInt(st.nextToken());
			map.put(num, 1);
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		for (int m = 0; m < M; m++) {
			num = Integer.parseInt(st.nextToken());
			if(map.containsKey(num)) {
				sb.append("1\n");
			}else {
				sb.append("0\n");
			}
		}
		

		System.out.println(sb);
	}
}
