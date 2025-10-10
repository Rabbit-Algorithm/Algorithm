package 문제풀이.DP._2xn타일링;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_이승환 {

    static int N;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];

        // N=1 이면 dp[1]만 출력하고 바로 종료
        if (N == 1) {
            System.out.println(1);
            return; // main 함수 종료
        }

        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=N; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        System.out.println(dp[N]);


    }
}
