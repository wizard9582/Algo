import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q14584_BOJ_암호해독 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] msg = br.readLine().toCharArray();
		int N = Integer.parseInt(br.readLine());
		String[] key = new String[N];

		for(int n = 0; n < N; n++){
			key[n] = br.readLine();
		}

		for(int i = 0; i < 26; i++) {
			for(int j = 0; j < msg.length; j++){
				int c = (int) msg[j] - 1;
				if(c < 97){
					c += 26;
				}
				msg[j] = (char) c;
			}
			String cipher = new String(msg);

			for(int n = 0; n < N; n++){
				if(cipher.contains(key[n])){
					System.out.println(cipher);
					return;
				}
			}
		}
	}
}