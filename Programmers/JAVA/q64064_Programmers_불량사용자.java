package programmers;

public class q64064_Programmers_불량사용자 {

	public static void main(String[] args) {
		String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
		String[] banned_id = { "fr*d*", "*rodo", "******", "******" };
		System.out.println(solution(user_id, banned_id));
	}

	private static int solution(String[] user_id, String[] banned_id) {
		int answer = 0;
		boolean[] bitmask = new boolean[1 << user_id.length];

		boolean[][] possible = new boolean[user_id.length][banned_id.length];

		for (int u = 0; u < user_id.length; u++) {
			for (int b = 0; b < banned_id.length; b++) {
				boolean flag = true;

				if (user_id[u].length() != banned_id[b].length()) {
					flag = false;
				} else {
					for (int i = 0; i < user_id[u].length(); i++) {
						if (banned_id[b].charAt(i) == '*')
							continue;
						else if (user_id[u].charAt(i) != banned_id[b].charAt(i)) {
							flag = false;
							break;
						}
					}
				}

				possible[u][b] = flag;
			}
		}

		recur(possible, bitmask, 0, 0);

		for (int i = 0; i < bitmask.length; i++) {
			if (bitmask[i])
				answer++;
		}
		return answer;
	}

	private static void recur(boolean[][] possible, boolean[] bitmask, int mask, int idx) {
		if (idx == possible[0].length) {
			bitmask[mask] = true;
			return;
		}

		for (int u = 0; u < possible.length; u++) {
			if (possible[u][idx] && (mask & (1 << u)) == 0) {
				recur(possible, bitmask, mask | (1 << u), idx + 1);
			}
		}
	}
}
