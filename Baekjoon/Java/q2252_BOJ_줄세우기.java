package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2252_BOJ_줄세우기 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<ArrayList<Integer>>list = new ArrayList<>();
		int[] in = new int[N+1];
		
		for(int n = 0; n <= N; n++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			in[b] ++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int n = 1; n <= N; n++) {
			if(in[n] == 0) {
				queue.offer(n);
			}
		}
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			ArrayList<Integer> nowList = list.get(now);
			
			sb.append(now).append(" ");
			
			for(int i = 0; i < nowList.size(); i++) {
				int next = nowList.get(i);
				in[next] --;
				if(in[next] == 0) {
					queue.offer(next);
				}
			}
		}
		
		System.out.println(sb);
	}
}
