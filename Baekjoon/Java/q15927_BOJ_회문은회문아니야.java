import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q15927_BOJ_회문은회문아니야 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] msg = br.readLine().toCharArray();
        int N = msg.length;
//        int answer = -1;
//
//        for(int n = 0; n < N - 1; n++){
//            int g = N - n - 1;
//            for(int m = 0; m + g < N; m++){
//                if(msg[m] != msg[m + g]){
//                    answer = g + 1;
//                    break;
//                }
//            }
//            if(answer != -1){
//                break;
//            }
//        }
//        System.out.println(answer);

        int answer = -1;
        char f = msg[0];
        for(int n = 1; n < N; n++){
            if(msg[n] != f){
                answer = 0;
                break;
            }
        }
        if(answer != -1){
            boolean flag = true;

            int l = 0, r = N - 1;

            while (l < r){
                if(msg[l] != msg[r]){
                    flag = false;
                    break;
                }
                l += 1;
                r -= 1;
            }


            if(flag){
                System.out.println(N - 1);
            }else{
                System.out.println(N);
            }
        }else {
            System.out.println(answer);
        }
    }
}

