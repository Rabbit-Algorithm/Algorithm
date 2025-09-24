package 문제풀이.DP.파도반수열_9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_홍창모 {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 테스트 케이스
        T = Integer.parseInt(br.readLine());

        long[] dp = new long[101];
        dp[0] = 0;
        dp[1] = 1;

        for( int i = 2; i <= 100; i++ ) {
            if( i - 3 > 0 ) dp[i] = dp[i-2] + dp[i-3];
            else dp[i] = dp[i-1];
        }

        for( int i = 0; i < T; i++ ) {
            int n = Integer.parseInt(br.readLine());

            sb.append(dp[n]).append("\n");
        }

        System.out.print(sb);
    }
}
