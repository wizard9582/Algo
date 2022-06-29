package backjun;

import java.util.Scanner;

public class q1110 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		int a = num/10;
		int b = num%10;
		int newA,newB,count = 0;
		
		do{
			newA = b;
			newB= (a+b)%10;
			
			a = newA;
			b = newB;
			
			count ++;
			
		}while((a*10)+b != num);
		
		System.out.println(count);
		
		
	}

}
