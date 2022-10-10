package programmers;

public class q131130_혼자놀기의달인 {
	class Solution {
	    public int solution(int[] cards) {
	        int answer1 = -1;
	        int answer2 = -1;
	        
	        for(int i = 0; i < cards.length; i++){
	            if(cards[i] == 0)
	                continue;
	            
	            int box = cards[i] - 1;
	            int nbox = -1;
	            int count = 1;
	            cards[i] = 0;
	            
	            while(true){
	                if(cards[box] == 0){
	                    if(count >= answer1){
	                        answer2 = answer1;
	                        answer1 = count;
	                    }else if(count > answer2){
	                        answer2 = count;
	                    }
	                    break;
	                }
	                
	                nbox = cards[box] - 1;
	                count ++;
	                cards[box] = 0;
	                box = nbox;
	            }
	            
	        }
	        
	        if(answer1 * answer2 < 0){
	            return 0;
	        }
	        
	        return answer1 * answer2;
	    }
	}
}
