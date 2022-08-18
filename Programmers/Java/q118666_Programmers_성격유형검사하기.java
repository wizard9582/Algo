package programmers;

public class q118666_Programmers_성격유형검사하기 {
	public static void main(String[] args) {
		
		String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
		int[] choices = {5, 3, 2, 7, 5};
		
		Solution sol = new Solution();
		System.out.println(sol.solution(survey, choices));
		
	}
	
	public static class Solution {
	    public String solution(String[] survey, int[] choices) {
	        StringBuilder answer = new StringBuilder();
	        int[] point = new int[26];

			for (int i = 0; i < survey.length; i++) {
				int negative = survey[i].charAt(0) - 'A';
				int positive = survey[i].charAt(1) - 'A';

				if (choices[i] < 4) {
					point[negative] += 4 - choices[i];
				} else {
					point[positive] += choices[i] - 4;
				}
			}
			
		    if(point['R' - 'A'] < point[ 'T' - 'A']) {
		    	answer.append('T');
		    }
		    else {
		    	answer.append('R');
		    }

		    if(point['C' - 'A'] < point[ 'F' - 'A']) {
		    	answer.append('F');
		    }
		    else {
		    	answer.append('C');
		    }
		    
		    if(point['J' - 'A'] < point[ 'M' - 'A']) {
		    	answer.append('M');
		    }
		    else {
		    	answer.append('J');
		    }
		    
		    if(point['A' - 'A'] < point[ 'N' - 'A']) {
		    	answer.append('N');
		    }
		    else {
		    	answer.append('A');
		    }
			
	        return answer.toString();
	    }
	}
}
