package backjun;

import java.util.Arrays;
import java.util.Scanner;

public class q10809_BOJ_알파벳찾기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int[] arr = new int[26];
		Arrays.fill(arr, -1);
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			int num = (int)c;
			if(arr[num - 97] == -1) arr[num - 97] = i;
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
