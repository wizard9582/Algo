package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1247 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] company = new int[2];
	static int[] home = new int[2];
	static int[][] target;
	static int N,answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			answer = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			company[0] = Integer.parseInt(st.nextToken());
			company[1] = Integer.parseInt(st.nextToken());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			target = new int[N][2];
			
			for (int n = 0; n < N; n++) {
				target[n][0] = Integer.parseInt(st.nextToken());
				target[n][1] = Integer.parseInt(st.nextToken());
			}
			
			makePermutation(0, new int[N], new boolean[N]);
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}

		System.out.println(sb);
	}
	
	static void makePermutation(int count, int[] choosed, boolean[] visited) {
		if (count == N) {
			checkLength(choosed);
			return;
		}
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				choosed[count] = i;
				makePermutation(count+1, choosed, visited);
				visited[i] = false;
			}
		}
	}
	static void checkLength(int[] choosed) {
		int l = 0;
		int x = company[0];
		int y = company[1];
		
		for(int n =0; n < N; n++) {
			int a = choosed[n];
			l += Math.abs(target[a][0]-x) + Math.abs(target[a][1]-y);
			x = target[a][0];
			y = target[a][1];
			
			if(l > answer) {
				return;
			}
		}
		
		l+=Math.abs(home[0]-x) + Math.abs(home[1]-y);
		
		answer = Math.min(answer, l);
	}
}
