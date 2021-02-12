package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q16120 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int size = 0;
		int l = str.length();
		char[] PPAP = new char [l];
		
		for(int i = 0; i < l; i++) {
			PPAP[size] = str.charAt(i);
			size ++;
			
			if(3 < size && PPAP[size-1] == 'P') {
				if(PPAP[size-2] == 'A' && PPAP[size-3] == 'P' && PPAP[size-4] == 'P') {
					size -= 4;
					PPAP[size] = 'P';
					size ++;
				}
			}
		}
		
		
		if(size == 1 && PPAP[0] == 'P') {
			System.out.println("PPAP");
		}else {
			System.out.println("NP");
		}
	}
}

