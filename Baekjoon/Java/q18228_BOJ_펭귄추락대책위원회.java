import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q18228_BOJ_펭귄추락대책위원회 {
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int idx = 0, l = Integer.MAX_VALUE, r = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());

        while(idx < N){
            int n = Integer.parseInt(st.nextToken());
            idx ++;
            if(n == -1){
                break;
            }
            l = Math.min(l, n);
        }
        while(idx < N){
            int n = Integer.parseInt(st.nextToken());
            r = Math.min(r, n);
            idx ++;
        }

        System.out.println(l + r);
    }
}

