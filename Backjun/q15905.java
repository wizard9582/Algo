package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q15905 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[N];
		
		for(int n = 0; n < N ; n++) {
			arr[n] = br.readLine().charAt(0) - '0';
		}
		
		Arrays.sort(arr, (e1,e2)->{
			return e2-e1;
		});
		
		int last = arr[4];
		int answer = 0;
		for(int i = 5; i < N; i++) {
			if(arr[i] == last) {
				answer ++;
			}else {
				break;
			}
		}
		
		System.out.println(answer);
	}
}