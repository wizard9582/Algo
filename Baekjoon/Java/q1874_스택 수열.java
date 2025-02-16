package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1874 {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] stack = new int[N];
		int max = 0;
		int size = 0;
		boolean flag = false;
		StringBuilder sb = new StringBuilder();

		for (int n = 0; n < N; n++) {
			int x = Integer.parseInt(br.readLine());
			if (max < x) {
				for (int i = max +1; i < x+1; i++) {
					stack[size] = i;
					sb.append("+\n");
					size++;
				}
				max = x;
			} else if(stack[size -1] != x){
				flag = true;
				break;
			}
			size--;
			sb.append("-\n");
		}
		if (flag) {
			System.out.println("NO");
		} else {
			System.out.println(sb);
		}
	}
}
