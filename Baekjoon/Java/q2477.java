package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2477 {
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Queue<int[]>queue = new LinkedList<>();
		int[] dir = new int[5];
		
		for(int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			queue.offer(new int[] {a,b});
			
			dir[a]++;
		}
		
		int area = 0;
		int east,west,north,south;
		
		if(dir[1] == 2) {
			if(dir[3] == 2) {
				while(queue.peek()[0] != 4) {
					queue.offer(queue.poll());
				}
				north = queue.poll()[1];
				west = queue.poll()[1];
				queue.poll();
				east = queue.poll()[1];
				south = queue.poll()[1];
				
				area = (north * west) - (east * south);
				
			}else {
				while(queue.peek()[0] != 2) {
					queue.offer(queue.poll());
				}
				
				west = queue.poll()[1];
				south = queue.poll()[1];
				queue.poll();
				north = queue.poll()[1];
				east = queue.poll()[1];
				
				area = (south * west) - (east * north);
			}
		}else {
			if(dir[3] == 2) {
				while(queue.peek()[0] != 1) {
					queue.offer(queue.poll());
				}
				east = queue.poll()[1];
				north = queue.poll()[1];
				queue.poll();
				south = queue.poll()[1];
				west = queue.poll()[1];
				
				area = (east * north) - (west * south);
			
			}else {
				while(queue.peek()[0] != 3) {
					queue.offer(queue.poll());
				}
				south = queue.poll()[1];
				east = queue.poll()[1];
				queue.poll();
				west = queue.poll()[1];
				north = queue.poll()[1];
				
				area = (east * south) - (west * north);
			}
		}
		
		System.out.println(N * area);
	}
}
