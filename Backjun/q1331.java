package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q1331 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[][] map = new boolean[6][6];
		boolean flag = true;

		String str = br.readLine();
		int nowX, nowY;
		int startX = str.charAt(0) - 'A';
		int startY = str.charAt(1) - '1';
		int pastX = startX;
		int pastY = startY;
		map[pastX][pastY] = true;

		for (int i = 1; i < 36; i++) {
			str = br.readLine();
			nowX = str.charAt(0) - 'A';
			nowY = str.charAt(1) - '1';
			
			if(nowX < 0 || 5<nowX || nowY<0 || 5<nowY) {
				flag = false;
				break;
			}
			
			if(!map[nowX][nowY] && ((Math.abs(pastX-nowX)==2 && Math.abs(pastY-nowY) == 1) || (Math.abs(pastX-nowX)==1 && Math.abs(pastY-nowY) == 2))) {
				pastX = nowX;
				pastY = nowY;
				map[pastX][pastY] = true;
				
			}else {
				flag = false;
				break;
			}
			
		}
		
		if(flag) {
			if((Math.abs(pastX-startX)==2 && Math.abs(pastY-startY) == 1) || (Math.abs(pastX-startX)==1 && Math.abs(pastY-startY) == 2)){
			}else {
				flag = false;
			}
		}

		if (flag) {
			System.out.println("Valid");
		} else {
			System.out.println("Invalid");
		}
	}
}
