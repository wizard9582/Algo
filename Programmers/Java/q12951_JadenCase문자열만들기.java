package programmers;

public class q12951_JadenCase문자열만들기 {
	class Solution {
	    public String solution(String s) {
	    	char[] cArr = s.toCharArray();
	    	boolean flag = false;
	    	for(int i = 0; i < cArr.length; i++) {
	    		if(!flag && 97 <= (int)cArr[i] && (int)cArr[i] <= 122) {
	    			cArr[i] = (char)((int)cArr[i] - 32);
	    		}else if(flag && 65 <= (int)cArr[i] && (int)cArr[i] <= 90) {
	    			cArr[i] = (char)((int)cArr[i] + 32);
	    		}
	    		
	    		if(cArr[i] == ' ') {
	    			flag = false;
	    		}else {
	    			flag = true;
	    		}
	    	}
	    	
	    	return new String(cArr);
	    }
	}
}
