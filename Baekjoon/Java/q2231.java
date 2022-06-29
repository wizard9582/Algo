package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q2231 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 0;
		int answer = 0;
		String str;
		String[] arr;
		
		for(int i = 1; i < N ; i ++) {
			str = Integer.toString(i);
			arr = str.split(""); 
			sum = i;
			
			for(int j = 0; j < arr.length; j++) {
				sum += Integer.parseInt(arr[j]);
			}
			
			if (sum == N) {
				answer = i;
				break;
			}
		}
		System.out.println(answer);
	}
}
