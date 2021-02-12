 package swex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

	public class q1289 {
	    public static void main(String[] args) throws NumberFormatException, IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int T = Integer.parseInt(br.readLine());
	 
	        for (int tc = 1; tc <= T; tc++) {
	            int count = 0;
	            String str = br.readLine();
	            boolean flag = false;
	 
	            for (int s = 0; s < str.length(); s++) {
	                if (flag) {
	                    if (str.charAt(s) == '0') {
	                        count++;
	                        flag = false;
	                    }
	                } else {
	                    if (str.charAt(s) == '1') {
	                        count++;
	                        flag = true;
	                    }
	                }
	            }
	            System.out.printf("#%d %d\n", tc, count);
	        }
	    }
	}
