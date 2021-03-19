package jungOl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1863 {
	static StringTokenizer st;
	static int[] parent;
	static int[] rank;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		parent = new int[N+1];
		
		for(int n = 1; n <=N; n++) {
			parent[n] = n;
		}
		
		rank = new int[N+1];
		
		for(int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			union(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		int answer = 0;
		
		for(int n = 1; n <=N; n++) {
			if(parent[n] == n) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}
	static int findParent(int x) {
		if (x == parent[x]) {
			return x;
		}

		else {
			parent[x] = findParent(parent[x]);
			return parent[x];
		}
	}

	static void union(int x, int y) {

		x = findParent(x);
		y = findParent(y);

		if (x == y) {
			return;
		}
		
		if (rank[x] > rank[y]) {
			parent[y] = x;

		}else if(rank[x] < rank[y]){
			parent[x] = y;

		}else {
			parent[y] = x;
			rank[x] ++;
		}
	}
}
