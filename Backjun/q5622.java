package backjun;

import java.util.Scanner;

public class q5622 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		String[] strArray = str.split("");
		int sum = 0;
		
		for(int i = 0 ; i < strArray.length; i++) {
			if(strArray[i].equals("A") || strArray[i].equals("B") || strArray[i].equals("C"))sum+=3;
			if(strArray[i].equals("D") || strArray[i].equals("E") || strArray[i].equals("F"))sum+=4;
			if(strArray[i].equals("G") || strArray[i].equals("H") || strArray[i].equals("I"))sum+=5;
			if(strArray[i].equals("J") || strArray[i].equals("K") || strArray[i].equals("L"))sum+=6;
			if(strArray[i].equals("M") || strArray[i].equals("N") || strArray[i].equals("O"))sum+=7;
			if(strArray[i].equals("P") || strArray[i].equals("Q") || strArray[i].equals("R")|| strArray[i].equals("S"))sum+=8;
			if(strArray[i].equals("T") || strArray[i].equals("U") || strArray[i].equals("V"))sum+=9;
			if(strArray[i].equals("W") || strArray[i].equals("X") || strArray[i].equals("Y")|| strArray[i].equals("Z"))sum+=10;
		}
		System.out.println(sum);
	}
}