package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class q18258 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		LinkedList<Integer> queue = new LinkedList<>();
		String str;
		
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			str = st.nextToken();
			
			if(str.equals("push")) {
				queue.add(Integer.parseInt(st.nextToken()));
				
			}else if(str.equals("pop")) {
				if(queue.isEmpty()) {
					sb.append("-1").append("\n");
				}else {
					sb.append(queue.get(0)).append("\n");
					queue.remove(0);
				}
				
			}else if(str.equals("size")) {
					sb.append(queue.size()).append("\n");

			}else if(str.equals("empty")) {
				if(queue.isEmpty()) {
					sb.append("1").append("\n");
				}else {
					sb.append("0").append("\n");
				}
				
			}else if(str.equals("front")) {
				if(queue.isEmpty()) {
					sb.append("-1").append("\n");
				}else {
					sb.append(queue.get(0)).append("\n");
				}
				
			}else if(str.equals("back")) {
				if(queue.isEmpty()) {
					sb.append("-1").append("\n");
				}else {
					sb.append(queue.get(queue.size()-1)).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}
