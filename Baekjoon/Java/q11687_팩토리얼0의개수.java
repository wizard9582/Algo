import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q11687_BOJ_팩토리얼0의개수 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int l = 0, r = m * 5, answer = -1;

        while (l <= r) {
            int center = (l + r) / 2;
            int c = countZero(center);

            if(c == m){
                answer = makeFive(center);
                break;
            }else if(c < m){
                l = center + 1;
            }else{
                r = center - 1;
            }
        }

        System.out.println(answer);
    }

    private static int makeFive(int n) {
        return (n / 5) * 5;
    }

    private static int countZero(int n) {
        int r = 0;
        while (n > 0) {
            n /= 5;
            r += n;
        }
        return r;
    }
}



