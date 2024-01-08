package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q3778_BOJ_애너그램거리 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int n = 0; n < N; n++) {
            char[] st1 = br.readLine().toCharArray();
            char[] st2 = br.readLine().toCharArray();
            int[] s1 = new int[26];
            int[] s2 = new int[26];

            for (int i = 0; i < st1.length; i++) {
                s1[(int)st1[i] - 97]++;
            }
            for (int i = 0; i < st2.length; i++) {
                s2[(int)st2[i] - 97]++;
            }
            int dis = 0;

            for (int i = 0; i < 26; i++) {
                dis += Math.abs(s1[i] - s2[i]);
            }
            sb.append("Case #").append(n + 1).append(": ").append(dis).append("\n");
        }
        System.out.println(sb);
    }
}