import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
//        boolean[] primes = new boolean[200];
//        Arrays.fill(primes, true);
//
//        for(int i = 2; i < 200; i++) {
//            if (primes[i]) {
//                int d = 2;
//
//                while (d * i < 200) {
//                    primes[d * i] = false;
//                    d += 1;
//                }
//            }
//        }
//
//        for(int i = 2; i < 200; i++) {
//            if(primes[i])
//                System.out.println(i);
//        }

        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59,
                61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137,
                139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199};

        for(int i = 0; i < 45; i++){
            if(primes[i] * primes[i + 1] > N){
                System.out.println(primes[i] * primes[i + 1]);
                break;
            }
        }
    }
}