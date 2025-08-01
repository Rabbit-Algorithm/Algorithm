package 바킹독_과제._4주차_백트래킹.로또_6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_이태균 {

    private static int K;
    private static int[] S;
    private static int[] LOTTO;
    private static StringBuilder SB;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            SB = new StringBuilder();
            StringTokenizer st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());

            if (K == 0) {
                break;
            }

            S = new int[K];
            LOTTO = new int[6];

            for (int i = 0; i < K; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(S);

            backtracking(0, 0);
            System.out.println(SB);
        }

    }

    private static void backtracking(int start, int depth) {
        if (depth == 6) {
            for (int lotto : LOTTO) {
                SB.append(lotto).append(" ");
            }
            SB.append("\n");
            return;
        }

        for (int i = start; i < K; i++) {
            LOTTO[depth] = S[i];
            backtracking(i + 1, depth + 1);
        }
    }

}