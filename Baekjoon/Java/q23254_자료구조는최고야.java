import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q23254_BOJ_자료구조는최고야 {
    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        st.nextToken();
        int M = Integer.parseInt(st.nextToken());
        boolean flag = true;

        loop: for(int m = 0; m < M; m++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int b1 = 200_001;

            for(int n = 0; n < N; n++){
                int b2 = Integer.parseInt(st.nextToken());
                if(b1 < b2){
                    flag = false;
                    break loop;
                }else{
                    b1 = b2;
                }
            }
        }

        if(flag){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}

