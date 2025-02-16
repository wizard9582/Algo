import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q3216_BOJ_다운로드 {
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int t = 0, c = 0;

        for(int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if(v > c) {
                t += v - c;
                c = 0;
            }else{
                c -= v;
            }
            c += d;
        }

        System.out.println(t);
    }
}

