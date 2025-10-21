package _8주차_DP._123더하기3_15988;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_홍창모 {
    static int T;
    static final int MOD = 1_000_000_009;
    static long[] dp = new long[1_000_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 기본값 설정
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        // 미리 전체 dp 계산
        for (int i = 4; i <= 1_000_000; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append('\n');
        }

        System.out.print(sb);
    }
}
