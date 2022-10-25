package programmers;

import java.util.*;

public class q12941_최솟값만들기 {

	class Solution
	{
	    public int solution(int []A, int []B)
	    {
	        int answer = 0;

	        Arrays.sort(A);
	        Arrays.sort(B);
	        
	        for(int i = 0; i < A.length; i++){
	            answer += A[i] * B[B.length - i - 1];
	        }

	        return answer;
	    }
	}
}
