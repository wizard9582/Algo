package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q1427 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		String str = Integer.toString(N);
		String[] arr = str.split("");
		int[] num = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++) {
			num[i] = Integer.parseInt(arr[i]);
		}
		Arrays.sort(num);
		
		for(int i = arr.length; i > 0; i--) {
			sb.append(num[i-1]);
		}
		System.out.println(sb);
	}
}
