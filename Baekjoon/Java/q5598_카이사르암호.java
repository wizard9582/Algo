import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q5598_BOJ_카이사르암호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] msg = br.readLine().toCharArray();

		for(int i = 0; i < msg.length; i++){
			int c = (int) msg[i] - 3;

			if(c < 65){
				c += 26;
			}
			msg[i] = (char) c;
		}

		System.out.println(msg);
	}
}