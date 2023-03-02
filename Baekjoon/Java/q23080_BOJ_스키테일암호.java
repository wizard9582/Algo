import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q23080_BOJ_스키테일암호 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();
        String answer = "";

        for(int i = 0; i < input.length; i += K){
            answer += input[i];
        }

        System.out.println(answer);

    }
}

