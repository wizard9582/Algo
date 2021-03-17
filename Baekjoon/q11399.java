package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q11399 {
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int n=0; n<N; n++) {
			num[n] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		
		int answer = 0, sum = 0;
		for(int n =0; n<N; n++) {
			sum += num[n];
			answer += sum;
		}
		
		System.out.println(answer);
	}
}
