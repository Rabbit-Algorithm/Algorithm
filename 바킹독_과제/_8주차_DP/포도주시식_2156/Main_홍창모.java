package _8주차_DP.포도주시식_2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_홍창모 {

    static int N;
    static int[] WINE;
    static int[] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        WINE = new int[N+1];
        DP = new int[N+1];

        for (int i = 1; i <= N; i++) {
            WINE[i] = Integer.parseInt(br.readLine());
        }

        DP[0] = 0;
        DP[1] = WINE[1];

        if( N > 1 ) {
            DP[2] = WINE[1] + WINE[2];
        }

        for (int i = 3; i <= N; i++) {
            // 1. 현재 잔을 마시는 경우
            // 1-1. 현재 잔을 마시고 이전 잔을 안마시는 경우
            int drinkCase1 = DP[i-2] + WINE[i];

            // 1-2. 현재 잔과 이전 잔을 마시고 전전 잔을 안마시는 경우
            int drinkCase2 = DP[i-3] + WINE[i-1] + WINE[i];

            // 2. 현재 잔을 안마시는 경우
            int noDrink = DP[i-1];

            DP[i] = Math.max(drinkCase1, Math.max(drinkCase2, noDrink));
        }

        System.out.println(DP[N]);
    }
}
