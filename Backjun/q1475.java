package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1475 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] strArr = str.split("");
		int[] num = new int[10];
		
		for(int i = 0; i<strArr.length; i++) {
			num[Integer.parseInt(strArr[i])]++;
		}
		
		int sum = num[6] + num[9];
		
		num[6] = sum/2 + sum%2;
		num[9] = sum/2;
		
		int Max = 0;
		
		for(int i = 0 ; i<10; i++) {
			if(num[i]>Max) {
				Max = num[i];
			}
		}
		System.out.println(Max);
	}
}
