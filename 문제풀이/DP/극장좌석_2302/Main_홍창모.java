package 문제풀이.DP.극장좌석_2302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_홍창모 {

    static int N, VIP;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+2];
        boolean[] isVIP = new boolean[N+1];

        VIP = Integer.parseInt(br.readLine());

        for (int i = 0; i < VIP; i++) {
            int target = Integer.parseInt(br.readLine());
            isVIP[target] = true;
        }

        dp[0] = 1;
        dp[1] = 1;
        for( int i = 2; i <= N; i++ ) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        int cal = 1;
        int latestTarget = 0;

        for (int i = 1; i <= N; i++) {
            if( isVIP[i] ) {
                cal *= dp[latestTarget];
                latestTarget = 0;
            } else {
                latestTarget++;
            }
        }

        // vip로 안끝나는 경우도 마지막 좌석까지 처리
        cal *= dp[latestTarget];

        System.out.println(cal);
    }
}
