package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class q42888_Programmers_오픈채팅방 {
	public static void main(String[] args) {
		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		System.out.println(Arrays.toString(solution(record)));
	}

	private static String[] solution(String[] record) {
        Map<String, Integer> userMap = new HashMap<String, Integer>();
		ArrayList<String> userNick = new ArrayList<String>();
		int[][] log = new int[record.length][2];
		int index = 0;
		int count = 0;

		for (int i = 0; i < record.length; i++) {
			StringTokenizer st = new StringTokenizer(record[i]);
			String act = st.nextToken();
			switch (act) {
			case "Enter":
				String id1 = st.nextToken();
				if (!userMap.containsKey(id1)) {
					userMap.put(id1, index);
					log[i][0] = index;
					userNick.add(st.nextToken());
					index++;
				} else {
					userNick.set(userMap.get(id1), st.nextToken());
					log[i][0] = userMap.get(id1);
				}
				log[i][1] = 1;
				count++;
				break;
			case "Leave":
				String id2 = st.nextToken();
				log[i][0] = userMap.get(id2);
				log[i][1] = 2;
				count++;
				break;
			case "Change":
				String id3 = st.nextToken();
				userNick.set(userMap.get(id3), st.nextToken());
				break;
			default:
				break;
			}
		}

		String[] answer = new String[count];
		index = 0;

		for (int i = 0; i < log.length; i++) {
			if (log[i][1] == 1) {
				answer[index++] = new StringBuilder().append(userNick.get(log[i][0])).append("님이 들어왔습니다.").toString();
			}else if(log[i][1] == 2){
				answer[index++] = new StringBuilder().append(userNick.get(log[i][0])).append("님이 나갔습니다.").toString();
			}
		}

		return answer;
    }
}
