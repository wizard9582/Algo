package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class q2605 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		LinkedList<Integer> list = new LinkedList<>();
		
		for(int i = 0; i < N; i++) {
			list.add(i - Integer.parseInt(st.nextToken()), i+1);
		}
		for(int i = 0; i < N; i ++) {
			sb.append(list.get(i)).append(" ");
		}
		System.out.println(sb);
	}
}
