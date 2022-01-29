package keep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class q23349_BOJ_졸업사진 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> duple = new HashMap<String, Integer>();
		PriorityQueue<Submit> pq = new PriorityQueue<>((e1, e2) -> {
			if (e1.place.equals(e2.place)) {
				return e1.time - e2.time;
			} else {
				return e1.place.compareTo(e2.place);
			}
		});

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();

			if (!duple.containsKey(name)) {
				duple.put(name, 1);

				String place = st.nextToken();
				int startTime = Integer.parseInt(st.nextToken());
				int endTime = Integer.parseInt(st.nextToken());

				pq.offer(new Submit(place, startTime, true));
				pq.offer(new Submit(place, endTime, false));
			}
		}

		String busyPlace = "";
		int busy = 0;
		int busyMax = 0;
		int startTime = 0;
		int endTime = 0;
		boolean maxFlag = false;

		while (!pq.isEmpty()) {
			Submit now = pq.poll();

			if (now.type) {
				busy++;
				if (busy > busyMax) {
					busyMax = busy;
					busyPlace = now.place;
					startTime = now.time;
					maxFlag = true;
				}
			} else {
				busy--;
				if (maxFlag) {
					maxFlag = false;
					endTime = now.time;
				}
			}
		}

		sb.append(busyPlace).append(" ").append(startTime).append(" ").append(endTime);
		System.out.println(sb);
	}

	private static class Submit {
		String place;
		int time;
		boolean type;

		Submit(String place, int time, boolean type) {
			super();
			this.place = place;
			this.time = time;
			this.type = type;
		}
	}
}
