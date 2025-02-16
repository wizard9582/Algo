package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1935 {
	static double[] stack = new double[100];
	static int idx = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[] arr = br.readLine().toCharArray();
		double[] num = new double[N];
		
		for(int n = 0; n <N; n++) {
			num[n] = Double.parseDouble(br.readLine());
		}
		
		for(int i = 0; i < arr.length; i++) {
			char c = arr[i];
			if('A' <= c && c <= 'Z') {
				push(num[c - 'A']);
			}
			else if(arr[i] == '+' || arr[i] == '-' || arr[i] == '*' || arr[i] == '/') {
				double n2 = pop();
				double n1 = pop();
				
				switch (arr[i]) {
				case '+':
					push(n1 + n2);
					break;
				case '-':
					push(n1 - n2);
					break;
				case '*':
					push(n1 * n2);
					break;
				case '/':
					push(n1 / n2);
					break;
				default:
					break;
				}
			}
		}
		
		System.out.printf("%.2f",stack[idx-1]);
		
	}
	
	static double pop() {
		double d = stack[idx-1];
		idx--;
		 return d;
	}
	static void push(double d) {
		stack[idx] = d;
		idx ++;
	}
}
