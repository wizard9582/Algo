package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q14888 {
	static StringTokenizer st;
	static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int[] num;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			num[n] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		dfs(num[0], 1, Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		
		System.out.println(max);
		System.out.println(min);
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
