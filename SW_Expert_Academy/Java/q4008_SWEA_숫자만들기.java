package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q4008_SWEA_숫자만들기 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, max, min;
	static int[] num;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int answer;
		
		for(int tc = 1; tc <= T ; tc++){
			max = Integer.MIN_VALUE; 
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			num = new int[N];
			
			st = new StringTokenizer(br.readLine());
			int[] op = {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
			
			st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n++) {
				num[n] = Integer.parseInt(st.nextToken());
			}
			
			dfs(num[0], 1, op[0], op[1], op[2], op[3]);
			
			answer = max-min;
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int result, int count, int plus, int minus, int multiple, int divide) {
		
		if(count == N) {
			if(result < min) {
				min = result;
			}
			
			if(result > max) {
				max = result;
			}
		}
		
		if(plus > 0) {
			dfs(result + num[count], count+1, plus-1, minus, multiple, divide);
		}
		if(minus > 0) {
			dfs(result - num[count], count+1, plus, minus-1, multiple, divide);
		}
		if(multiple > 0) {
			dfs(result * num[count], count+1, plus, minus, multiple-1, divide);
		}
		if(divide > 0) {
			dfs(result / num[count], count+1, plus, minus, multiple, divide-1);
		}
		
	}
}
