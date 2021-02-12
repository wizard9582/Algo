package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1919 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] array = str.split("");

		int[] count = new int[26];
		int[] count2 = new int[26];

		for (int i = 0; i < array.length; i++) {
			char c = array[i].charAt(0);
			count[(int) c - 97]++;
		}
		
		str = br.readLine();
		array = str.split("");
		
		for (int i = 0; i < array.length; i++) {
			char c = array[i].charAt(0);
			count2[(int) c - 97]++;
		}
		
		int answer = 0;
		
		for(int i = 0 ; i < 26 ; i++) {
			
			if(count[i] > count2[i]) {
				answer += (count[i]-count2[i]);
			}
			else if(count[i] < count2[i]) {
				answer += (count2[i]-count[i]);
			}
			
		}
		
		System.out.println(answer);
	}
}
