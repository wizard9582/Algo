package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class q19583_BOJ_싸이버개강총회 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Map<String, Integer> map = new HashMap<String, Integer>();

		st = new StringTokenizer(br.readLine());

		int startTime = getTime(st.nextToken());
		int endTime = getTime(st.nextToken());
		int streamEndTime = getTime(st.nextToken());
		int answer = 0;
		String str;

		while ((str = br.readLine()) != null) {

			st = new StringTokenizer(str);
			int time = getTime(st.nextToken());
			String name = st.nextToken();

			if (time <= startTime && !map.containsKey(name)) {
				map.put(name, 0);
			} else if (endTime <= time && time <= streamEndTime) {
				if (map.containsKey(name) && map.get(name) == 0) {
					answer++;
					map.put(name, 1);
				}
			}
		}
		System.out.println(answer);
	}

	private static int getTime(String str) {
		int time = 0;
		char[] timeData = str.toCharArray();

		time += (timeData[0] - '0') * 600;
		time += (timeData[1] - '0') * 60;
		time += (timeData[3] - '0') * 10;
		time += (timeData[4] - '0');

		return time;
	}
}
