package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q1697 {
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] visit = new boolean[100001];
		
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {N,0});
		
		while(!queue.isEmpty()) {
			int x = queue.peek()[0];
			int l = queue.poll()[1];
			
			if(x == M) {
				System.out.println(l);
				break;
			}
			
			int nX = 2 * x;
			if(isIn(nX) && !visit[nX]) {
				visit[nX] = true;
				queue.offer(new int[] {nX,l+1});
			}
			
			nX = x-1;
			if(isIn(nX) && !visit[nX]) {
				visit[nX] = true;
				queue.offer(new int[] {nX,l+1});
			}
			
			nX = x+1;
			if(isIn(nX) && !visit[nX]) {
				visit[nX] = true;
				queue.offer(new int[] {nX,l+1});
			}
			
		}
	}

	static boolean isIn(int x) {
		if (0 <= x && x <= 100000) {
			return true;
		}
		return false;
	}
}
