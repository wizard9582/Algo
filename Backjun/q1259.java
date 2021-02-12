package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1259 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			char[] arr = br.readLine().toCharArray();
			
			if(arr.length == 1 && arr[0] == '0') {
				break;
			}
			
			boolean flag = true;
			for(int i =0; i< arr.length/2; i++) {
				if(arr[i] == arr[arr.length-i-1]) {
					continue;
				}
				flag = false;
				break;
			}
			
			if(flag) {
				sb.append("yes\n");
			}
			else{
				sb.append("no\n");
			}
		}
		System.out.println(sb);
	}
}
