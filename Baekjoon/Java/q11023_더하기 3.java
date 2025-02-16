package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q11023 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] arr = str.split(" ");
		int sum = 0;
		
		for(int i = 0 ; i < arr.length; i++) {
			sum+= Integer.parseInt(arr[i]);
		}
		
		System.out.println(sum);
	}
}
