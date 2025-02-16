import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q2082_BOJ_시계 {

    static StringTokenizer st;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][][] number = new boolean[4][5][3];
        boolean[][][] exc = new boolean[10][5][3];

        String[] input = {"###  ..#  ###  ###  #.#  ###  ###  ###  ###  ###",
                "#.#  ..#  ..#  ..#  #.#  #..  #..  ..#  #.#  #.#",
                "#.#  ..#  ###  ###  ###  ###  ###  ..#  ###  ###",
                "#.#  ..#  #..  ..#  ..#  ..#  #.#  ..#  #.#  ..#",
                "###  ..#  ###  ###  ..#  ###  ###  ..#  ###  ###"};

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                String t = st.nextToken();
                for (int k = 0; k < 3; k++) {
                    if (t.charAt(k) == '#') {
                        number[j][i][k] = true;
                    }
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(input[i]);
            for (int j = 0; j < 10; j++) {
                String t = st.nextToken();
                for (int k = 0; k < 3; k++) {
                    if (t.charAt(k) == '.') {
                        exc[j][i][k] = true;
                    }
                }
            }
        }
        char[] answer = {'0','0',':','0','0'};
        for (int i = 0; i < 4; i++) {
            for(int n = 0; n < 10; n++){
                boolean flag = true;
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 3; k++) {
                        if(exc[n][j][k]){
                            if(number[i][j][k]){
                                flag = false;
                            }
                        }
                    }
                }
                if(flag){
                    int ta = (i < 2) ? i : i + 1;
                    answer[ta] = (char) (n + (int) '0');
                    break;
                }
            }
        }

        System.out.println(answer);

    }
}