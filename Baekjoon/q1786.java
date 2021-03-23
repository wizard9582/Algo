package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class q1786 {
	static StringBuilder sb = new StringBuilder();
	static List<Integer> list = new ArrayList<>();
	static int l;
	static int[] fail;
	static String Text, find;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Text = br.readLine();
		find = br.readLine();
		l = find.length();
		
		fail = new int[l];
		
		for(int i = 1, j = 0; i < l ; i++) {
			while(j > 0 && find.charAt(i) != find.charAt(j)) {
				j = fail[j-1];
			}
			if(find.charAt(i) == find.charAt(j)) {
				j++;
				fail[i] = j;
			}
		}
		
		kmp();
		
		sb.append(list.size()).append("\n");
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i)).append("\n");
		}
		System.out.println(sb);
	}

	static void kmp() {
		
		for(int i = 0, j = 0; i < Text.length(); i++) {
			
			while(j > 0 && Text.charAt(i) != find.charAt(j)) {
				j = fail[j-1];
			}
			if(Text.charAt(i) == find.charAt(j)) {
				j++;
				if(j == l) {
					list.add(i-l+2);
					j = fail[--j];
				}
			}
		}
	}
}
