package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class q2750 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		ArrayList<Integer> arr = new ArrayList<>();

		for (int n = 0; n < N; n++) {
			arr.add(Integer.parseInt(br.readLine()));
		}

		Collections.sort(arr);

		for (Integer i : arr) {
			sb.append(i).append("\n");
		}
		
		System.out.println(sb);
		
	}
}

//2751도 같음 ㅎㅎ;
