package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1247Re {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] company = new int[2];
	static int[] home = new int[2];
	static int[][] target;
	static int[][] distance;
	static int[] np;
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
			np = new int[N];
			for (int n = 0; n < N; n++) {
				target[n][0] = Integer.parseInt(st.nextToken());
				target[n][1] = Integer.parseInt(st.nextToken());
				np[n] = n;
			}
			
			distance = new int[N][N];
			
			for (int n = 0; n < N; n++) {
				for (int m = n+1; m < N; m++) {
						distance[n][m] = Math.abs(target[n][0]-target[m][0]) + Math.abs(target[n][1]-target[m][1]);
						distance[m][n] = distance[n][m];
				}
			}
			
			
			do {
				checkLength(np);
			} while (nextPermutation());
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}

		System.out.println(sb);
	}
	
	static boolean nextPermutation() {
		int i = N - 1;
		while (i > 0 && np[i - 1] >= np[i]) {
			i--;
		}
		if (i == 0) {
			return false;
		}

		int j = N - 1;
		while (np[i - 1] >= np[j]) {
			j--;
		}
		swap(i - 1, j);
		
		int k = N -1;
		while(i < k) {
			swap(i++, k--);
		}
		return true;
	}
	static void swap(int a, int b) {
		int temp = np[a];
		np[a] = np[b];
		np[b] = temp;
	}
	
	static void checkLength(int[] choosed) {
		int l = 0;
		int a = choosed[0];
		
		l += Math.abs(target[a][0]-company[0]) + Math.abs(target[a][1]-company[1]);
		
		for(int n =1; n < N; n++) {
			
			l += distance[choosed[n-1]][choosed[n]];
			
			if(l > answer) {
				return;
			}
		}
		
		a = choosed[N-1];
		
		l+=Math.abs(home[0]-target[a][0]) + Math.abs(home[1]-target[a][1]);
		
		answer = Math.min(answer, l);
	}
}
