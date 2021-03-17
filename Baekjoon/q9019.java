package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q9019 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static boolean[] map;
	
	static class calcul{
		String order;
		int num;
		
		calcul(int a, String str){
			this.num = a;
			this.order = str;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int n = 0; n < N; n++) {
			map = new boolean[10000];
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int target = Integer.parseInt(st.nextToken());
			
			Queue<calcul> queue = new LinkedList<>();
			queue.offer(new calcul(start, ""));
			map[start] = true;
			
			while(true) {
				calcul c = queue.poll();
				int num = c.num;
				
				if(num == target) {
					sb.append(c.order.toString()).append("\n");
					break;
				}
				
				int num1 = (num*2)%10000;
				if(!map[num1]) {
					map[num1] = true;
					queue.offer(new calcul(num1, c.order + "D"));
				}
				
				int num2 = num-1;
				if(num2 == -1) {
					num2 = 9999;
				}
				if(!map[num2]) {
					map[num2] = true;
					queue.offer(new calcul(num2, c.order + "S"));
				}
				
				int num3 = left(num);
				if(!map[num3]) {
					map[num3] = true;
					queue.offer(new calcul(num3, c.order + "L"));
				}
				
				int num4 = right(num);
				if(!map[num4]) {
					map[num4] = true;
					queue.offer(new calcul(num4, c.order + "R"));
				}
			}
		}
		System.out.println(sb);
	}
	
	static int left(int n) {
		int one = n/1000;
		n = (n%1000) * 10;
		
		return n + one;
	}
	static int right(int n) {
		int one = n%10;
		n = n/10;
		
		return (one*1000) + n;
	}
}
