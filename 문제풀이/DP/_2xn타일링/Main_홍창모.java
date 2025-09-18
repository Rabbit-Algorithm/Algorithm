package 문제풀이.DP._2xn타일링;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_홍창모 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        long[] dp = new long[N+1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10_007;
        }

        System.out.println(dp[N]);
    }
}
