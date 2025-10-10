package 문제풀이.DP._123더하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_이승환 {

    static int N;

    static int[] numbers;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[11];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4; i<=10; i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];

        }

        numbers = new int[N];
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(br.readLine());
            sb.append(dp[num]).append('\n');
        }
        System.out.println(sb);


    }
}
