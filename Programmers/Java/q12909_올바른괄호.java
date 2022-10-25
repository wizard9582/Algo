package programmers;

public class q12909_올바른괄호 {
	class Solution {
	    boolean solution(String s) {
	        boolean answer = true;
	        
	        char[] cArr = s.toCharArray();
	        int count = 0;
	        
	        
	        for(int i = 0; i < cArr.length; i++){
	            if(cArr[i] == '(') {
	            	count += 1;
	            }else {
	            	count -= 1;
	            }
	            
	            if(count < 0) {
	            	answer = false;
	            	break;
	            }
	        }
	        
	        if(count != 0) {
	        	answer = false;
	        }

	        return answer;
	    }
	}
}
