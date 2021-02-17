package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q15686 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] map, chicken;
	static int house = 0, houseC = 0, N, M;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) house++;
				if(map[i][j] == 2) houseC++;
			}
		}
		
		chicken = new int[houseC][house];
		
		for (int i = 0, k = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 2) {
					chicken[k] = search(i,j);
					k++;
				}
			}
		}
		
		makeCombination(0, 0, new int[M]);
		
		
		System.out.println(answer);
	}
	
	static int[] search(int x, int y) {
		int[] distance = new int[house];
		
		for (int i = 0, k =0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					distance[k] = Math.abs(x-i) + Math.abs(y-j);
					k++;
				}
			}
		}
		
		return distance;
	}
	
	static void makeCombination(int count, int start, int[] choosed) {
		
		if(count == M) {
			int[] min = new int[house];
			Arrays.fill(min, Integer.MAX_VALUE);
			for(int i = 0; i <M; i++) {
				for(int j = 0; j <house; j++) {
					min[j] = Math.min(min[j],chicken[choosed[i]][j]);
				}
			}
			int nowA = 0;
			for(int j = 0; j <house; j++) {
				nowA += min[j];
			}
			answer = Math.min(answer, nowA);
			return;
		}
		
		for(int i = start; i < houseC; i++) {
			choosed[count] = i;
			makeCombination(count+1,i + 1,choosed);
		}
		
	}
}
