package _4주차_백트래킹.로또_6603;

import java.io.*;
import java.util.*;

public class Main_홍창모 {

    static int[] LOTTO = new int[6];
    static int[] TEST_ARR;
    static StringBuilder SB = new StringBuilder();
    static int LENGTH;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            TEST_ARR = new int[k];
            for (int i = 0; i < k; i++) {
                TEST_ARR[i] = Integer.parseInt(st.nextToken());
            }
            LENGTH = k;

            Arrays.sort(TEST_ARR);

            backtracking(0, 0);
            SB.append("\n");
        }

        System.out.print(SB);
    }

    private static void backtracking(int curr, int depth) {
        if (depth == 6) {
            for (int i = 0; i < 6; i++) {
                SB.append(TEST_ARR[LOTTO[i]]).append(" ");
            }
            SB.append("\n");
            return;
        }

        for (int i = curr; i < LENGTH; i++) {
            LOTTO[depth] = i;
            backtracking(i + 1, depth + 1);
        }
    }
}
