import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class q8979_올림픽 {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] medal = new int[N][4];

        for(int i = 0; i < N; i ++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 4; j++){
                medal[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(medal, (e1, e2) -> {
            if(e2[1] != e1[1]){
                return e2[1] - e1[1];
            }
            if(e2[2] != e1[2]){
                return e2[2] - e1[2];
            }
            return e2[3] - e1[3];
        });

        int t = 0;
        for(int i = 0; i < N; i ++){
            if(medal[i][0] == K) {
                t = i;
                break;
            }
        }

        while(t > 0){
            if(medal[t][1] == medal[t - 1][1] && medal[t][2] == medal[t - 1][2] && medal[t][3] == medal[t - 1][3]){
                t--;
            }
            else{
                break;
            }
        }
        System.out.println(t + 1);
    }
}
