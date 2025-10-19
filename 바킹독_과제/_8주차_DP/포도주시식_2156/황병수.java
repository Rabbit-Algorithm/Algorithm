package _8주차_DP.포도주시식_2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 황병수 {

    static int[] wine;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        wine = new int[N];
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            wine[i] = Integer.parseInt(br.readLine());;
        }

        if (N == 1) {
            System.out.println(wine[0]);
            return;
        }

        dp[0] = wine[0];
        dp[1] = wine[0] + wine[1];

        if (N > 2) {
            dp[2] = Math.max(wine[0] + wine[2], Math.max(wine[1] + wine[2], dp[1]));
        }


        for (int i = 3; i < N; i++) {
            // 1. 현재 인덱스 안마실 때
            int case1 = dp[i - 1];

            // 2. 현재 인덱스 마시고, 이전 잔 안마실 때
            int case2 = dp[i-2] + wine[i];

            // 3. 현재랑 이전 마시고, 전전잔 안마실 때
            int case3 = dp[i-3] + wine[i-1] + wine[i];

            // case 중에 가장 큰 값으로 할당
            dp[i] = Math.max(case1, Math.max(case2, case3));
        }

        System.out.println(dp[N-1]);
    }
}
