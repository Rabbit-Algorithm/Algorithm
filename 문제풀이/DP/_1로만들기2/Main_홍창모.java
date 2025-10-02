package 문제풀이.DP._1로만들기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main_홍창모 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        long[] dp = new long[N+1];
        int[] prev = new int[N+1];

        dp[0] = 0;
        dp[1] = 0;

        for( int i = 2; i <= N; i++ ) {
            dp[i] = dp[i-1] + 1;
            prev[i] = i - 1;

            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) {
                dp[i] = dp[i / 2] + 1;
                prev[i] = i / 2;
            }
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) {
                dp[i] = dp[i / 3] + 1;
                prev[i] = i / 3;
            }
        }

        List<Integer> arr = new ArrayList<>();
        for( int i = N; i > 0; i = prev[i] ) {
            arr.add(i);
        }


        for (int num : arr) {
            sb.append(num).append(" ");
        }

        System.out.println(dp[N]);
        System.out.print(sb);

    }
}
