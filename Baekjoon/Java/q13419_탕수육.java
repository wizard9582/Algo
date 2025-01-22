import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            int sl = s.length();

            StringBuilder a = new StringBuilder();
            StringBuilder b = new StringBuilder();

            if(sl % 2 == 0){
                for(int j = 0; j < sl; j++){
                    if(j % 2 == 0)
                        a.append(s.charAt(j));
                    else
                        b.append(s.charAt(j));
                }

            }else{

                for(int j = 0; j < sl; j++) {
                    a.append(s.charAt(j * 2 % sl));
                    b.append(s.charAt((j * 2 + 1) % sl));
                }
            }

            sb.append(a).append("\n");
            sb.append(b).append("\n");
        }

        System.out.print(sb);
    }
}
