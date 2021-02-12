package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class q1021 {
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> list = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int answer = 0;
		
		for (int n = 1; n <= N; n++) {
			list.add(n);
		}
		
		
		st = new StringTokenizer(br.readLine());
		for (int m = 0; m < M; m++) {
			int target = Integer.parseInt(st.nextToken());

			while (true) {
				if (list.get(0) == target) {
					list.remove(0);
					break;
				} else {
					if (list.indexOf(target) <= list.size() / 2) {
						list.add(list.size() - 1, list.remove(0));
					}else {
						list.add(0, list.remove(list.size() - 1));
					}
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
}