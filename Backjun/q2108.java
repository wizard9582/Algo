package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q2108 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[8001];
		int sum = 0, max = -5000, min = 5000, many = 0, center = 0, count = 0, flag = 0, manynum = 0, counterflag = 0;
		int[] answer = new int[4];

		for (int i = 0; i < N; i++) {
			int n =Integer.parseInt(br.readLine());
			num[n+4000]++;
			if (n<min) { 
				min = n;
			}
			if (n>max) { 
				max = n;
			}
		}

		for (int i = 0; i < 8001; i++) {
			if (num[i] != 0) {
				count += num[i];
				if (count > N / 2 && counterflag == 0) {
					center = i - 4000;
					counterflag++;
				}
				sum += (i - 4000) * num[i];
				if (num[i] == many) {
					flag++;
				}
				if (num[i] > many) {
					many = num[i];
					flag = 0;
					manynum = i - 4000;
				}
			}
		}

		answer[0] = (int) Math.round((double) sum / N);
		answer[1] = center;
		answer[3] = max - min;

		if (flag == 0)
			answer[2] = manynum;
		else {
			flag = 0;
			for (int i = 0; i < 8001; i++) {
				if (num[i] == many) {
					if (flag == 0) {
						flag = 1;
					} else {
						answer[2] = i - 4000;
						break;
					}
				}
			}
		}

		System.out.printf("%d\n%d\n%d\n%d", answer[0], answer[1], answer[2],answer[3]);
	}
}
