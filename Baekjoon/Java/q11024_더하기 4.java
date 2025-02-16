package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q11024 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int N = Integer.parseInt(str);
		
		for(int i = 0 ; i < N ; i++) {
		str = br.readLine();
		String[] arr = str.split(" ");
		int sum = 0;
		
		for(int j = 0 ; j < arr.length; j++) {
			sum+= Integer.parseInt(arr[j]);
		}
		
		System.out.println(sum);
		}
	}
}
