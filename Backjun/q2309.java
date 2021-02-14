package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class q2309 {
	static int[] dwarf = new int[9];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int n = 0; n < 9; n++) {
			dwarf[n] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(dwarf);
		
		int sum = 0;
		for (int n = 0; n < 9; n++) {
			sum += dwarf[n];
		}
		
		loop : for(int i =0; i<8; i++) {
			for(int j = i+1; j < 9; j++) {
				if(sum - dwarf[i] - dwarf[j] == 100) {
					answer(i,j);
					break loop;
				}
			}
		}

	}
	static void answer(int i, int j) {
		
		for(int a =0; a <9; a++) {
			if(a != i && a != j) {
				System.out.println(dwarf[a]);
			}
		}
	}
}
