package 문제풀이.DP.RGB거리_1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_홍창모 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[][] house = new int[N+1][3];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());

            house[i][0] = red;
            house[i][1] = green;
            house[i][2] = blue;
        }

        int[][] dp = new int[N+1][3];

        for (int i = 1; i <= N; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + house[i][0]; // 빨강
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + house[i][1]; // 초록
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + house[i][2]; // 파랑
        }

        int answer = Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2]));

        System.out.println(answer);
    }

}
