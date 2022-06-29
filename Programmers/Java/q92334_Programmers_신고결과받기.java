package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class q92334_Programmers_신고결과받기 {

	static String[] id_list = { "muzi", "frodo", "apeach", "neo" };
	static String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
	static int k = 2;

	public static void main(String[] args) {

		int user = id_list.length;
		boolean[][] log = new boolean[user][user];
		int[] count = new int[user];
		int[] answer = new int[user];
		Map<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < id_list.length; i++) {
			map.put(id_list[i], i);
		}

		for (int i = 0; i < report.length; i++) {
			StringTokenizer st = new StringTokenizer(report[i]);
			int reporter = map.get(st.nextToken());
			int target = map.get(st.nextToken());

			if (!log[reporter][target]) {
				log[reporter][target] = true;
				count[target]++;
			}
		}
		
		for(int i = 0; i < id_list.length; i++) {
			if(count[i] >= k) {
				for(int j = 0; j < id_list.length; j++) {
					if(log[j][i]) {
						answer[j]++;
					}
				}
			}
		}
		
		System.out.println(Arrays.toString(answer));
	}
}
