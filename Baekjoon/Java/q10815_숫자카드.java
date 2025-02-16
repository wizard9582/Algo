package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class q10815_BOJ_숫자카드 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			map.put(Integer.parseInt(st.nextToken()), 1);
		}

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int m = 0; m < M; m++) {
			if(map.containsKey(Integer.parseInt(st.nextToken()))) {
				sb.append("1 ");
			}else {
				sb.append("0 ");
			}
		}
		System.out.println(sb);
	}
}
