package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q4949 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] stack = new int[100];
		int size = 0;
		String str;
		String[] strArr;
		StringBuilder sb = new StringBuilder();
		boolean flag;

		while (true) {
			str = br.readLine();
			if (str.equals("."))
				break;
			strArr = str.split("");
			flag = false;
			size = 0;
			for (int i = 0; i < strArr.length; i++) {
				switch (strArr[i]) {
				case "(":
					stack[size] = 1;
					size++;
					break;
				case ")":
					if(0<size && stack[size-1] == 1)
						size--;
					else
						flag = true;
					break;
				case "[":
					stack[size] = 2;
					size++;
					break;
				case "]":
					if(0<size && stack[size-1] == 2)
						size--;
					else
						flag = true;
					break;

				default:
					break;
				}
				if (flag)
					break;
			}
			if (flag == false && size ==0)
				sb.append("yes\n");
			else
				sb.append("no\n");
		}
		System.out.println(sb);
	}
}
