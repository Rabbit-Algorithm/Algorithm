package _8주차_DP._123더하기3_15988;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 황병수 {

    static final int MOD = 1000000009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int target = Integer.parseInt(br.readLine());
            calcCase(target);
        }
    }

    private static void calcCase(int target) {

        long[] dp = new long[Math.max(4, target + 1)];  // ✅ int 배열

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= target; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD;;
        }
        System.out.println(dp[target]);
    }
}
