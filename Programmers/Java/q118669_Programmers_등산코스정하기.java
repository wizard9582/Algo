package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class q118669_Programmers_등산코스정하기 {
	public static void main(String[] args) {

		int[][] paths = new int[][] { { 1, 2, 3 }, { 2, 3, 5 }, { 2, 4, 2 }, { 2, 5, 4 }, { 3, 4, 4 }, { 4, 5, 3 },
				{ 4, 6, 1 }, { 5, 6, 1 } };
		int[] gates = new int[] { 1, 3 };
		int[] summits = new int[] { 5 };

		System.out.println(Arrays.toString(solution(6, paths, gates, summits)));
	}

	static public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
		int[] answer = { -1, 10_000_001 };

		boolean[] gateCheck = new boolean[n + 1];
		boolean[] summitCheck = new boolean[n + 1];

		for (int i = 0; i < gates.length; i++) {
			gateCheck[gates[i]] = true;
		}
		for (int i = 0; i < summits.length; i++) {
			summitCheck[summits[i]] = true;
		}

		ArrayList<ArrayList> pathList = new ArrayList<ArrayList>();

		for (int i = 0; i <= n; i++) {
			pathList.add(new ArrayList<int[]>());
		}

		for (int i = 0; i < paths.length; i++) {
			int from = paths[i][0];
			int to = paths[i][1];
			int dis = paths[i][2];

			pathList.get(from).add(new int[] { to, dis });
			pathList.get(to).add(new int[] { from, dis });
		}

		Arrays.sort(summits);

		for (int i = 0; i < summits.length; i++) {
			Queue<int[]> queue = new LinkedList<int[]>();
			int[] visited = new int[n + 1];
			Arrays.fill(visited, 10_000_001);
			queue.offer(new int[] { summits[i], 0 });
			visited[summits[i]] = 0;
			int minInten = answer[1];

			while (!queue.isEmpty()) {
				int now = queue.peek()[0];
				int maxInten = queue.poll()[1];

				if (maxInten >= minInten) {
					continue;
				}

				ArrayList<int[]> canMove = pathList.get(now);

				for (int j = 0; j < canMove.size(); j++) {
					int to = canMove.get(j)[0];
					int dis = canMove.get(j)[1];
					int nextInten = Math.max(maxInten, dis);

					if (visited[to] > nextInten) {
						if (gateCheck[to]) {
							visited[to] = nextInten;
							minInten = Math.min(nextInten, minInten);
						} else if (!summitCheck[to]) {
							queue.offer(new int[] { to, nextInten });
							visited[to] = nextInten;
						}
					}
				}
			}

			for (int j = 0; j < gates.length; j++) {
				int goal = gates[j];
				if (visited[goal] < answer[1]) {
					answer[0] = summits[i];
					answer[1] = visited[goal];
				}
			}
		}
		return answer;
	}
}
