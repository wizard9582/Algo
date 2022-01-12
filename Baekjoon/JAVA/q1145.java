package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q1145 {
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[5];
		
		for(int i =0; i < 5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		for(int i = arr[2];; i++) {
			int count = 0;
			for(int j = 0; j < 5; j++) {
				if(i%arr[j] == 0) {
					count ++;
				}
			}
			if(count > 2) {
				System.out.println(i);
				break;
			}
		}
		
	}
}