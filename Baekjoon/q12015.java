package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class q12015 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<>();
		list.add(Integer.parseInt(st.nextToken()));
		int size = 1;

		for (int n = 1; n < N; n++) {
			int num = Integer.parseInt(st.nextToken());

			if (num > list.get(size - 1)) {
				list.add(num);
				size++;
			} else {
				int temp = Collections.binarySearch(list, num);
				if (temp < 0) {
					temp = Math.abs(temp) - 1;
					if (num < list.get(temp)) {
						list.set(temp, num);
					}
				}
			}

		}

		System.out.println(size);
	}
}
