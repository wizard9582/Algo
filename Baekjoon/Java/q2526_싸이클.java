package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class q2526 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		Map<Integer, Integer> map = new HashMap<>();

		int count = 1;
		int n = N;
		map.put(n, count++);

		while (true) {
			n = (n * N) % P;

			if (map.containsKey(n)) {
				break;
			} else {
				map.put(n, count++);
			}
		}

		System.out.println(map.size() - map.get(n) + 1);
	}
}
