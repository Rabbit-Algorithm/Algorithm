package 문제풀이.DP._123더하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_홍창모 {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for( int i = 0; i < T; i++ ) {
            int value = Integer.parseInt(br.readLine());

            int count = dp(value);

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    private static int dp(int value) {

        int[] dp = new int[value+1];

        dp[0] = 1;

        for( int i = 1; i <= value; i++ ) {
            if( i - 1 >= 0 ) dp[i] += dp[i-1];
            if( i - 2 >= 0 ) dp[i] += dp[i-2];
            if( i - 3 >= 0 ) dp[i] += dp[i-3];
        }

        return dp[value];
    }
}
