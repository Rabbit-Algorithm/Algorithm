package 문제풀이.DP._1로만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_홍창모 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 0;

        for( int i = 2; i <=n; i++ ) {

            dp[i] = dp[i-1] + 1;

            if( i % 3 == 0 ) {
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            }

            if ( i % 2 == 0 ) {
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }
        }

        System.out.println(dp[n]);
    }
}
