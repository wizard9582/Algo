package backjun;

import java.text.DecimalFormat;
import java.util.Scanner;

public class q4344 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DecimalFormat form = new DecimalFormat();
		form.applyLocalizedPattern("0.000");


		int T = Integer.parseInt(sc.nextLine());
		
		for(int i = 0 ; i < T ; i ++) {
			String str = sc.nextLine();
			String[] strArray = str.split(" ");
			int num = Integer.parseInt(strArray[0]);
			int sum = 0;
			
			for(int j = 1; j < num+1 ; j ++) {
				sum += Integer.parseInt(strArray[j]);
			}
			
			double average = ((double)sum / (double)num);
			sum = 0;
			
			for(int j = 1; j < num+1 ; j ++) {
				if(Integer.parseInt(strArray[j]) > average) {
					sum ++;
				}
			}
			double answer = ((double)sum / (double)num) * 100;

			System.out.print(form.format(answer));
			System.out.println("%");
		}
	}
}
