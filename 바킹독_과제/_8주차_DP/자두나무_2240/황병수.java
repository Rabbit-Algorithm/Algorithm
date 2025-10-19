package _8주차_DP.자두나무_2240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 황병수 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] fruits = new int[T + 1];

        // 자두가 떨어지는 나무 번호 입력
        for (int i = 1; i <= T; i++) {
            fruits[i] = Integer.parseInt(br.readLine());
        }

        // dp[시간][이동횟수][위치(1 or 2)]
        int[][][] dp = new int[T + 1][W + 1][3];

        for (int t = 1; t <= T; t++) {
            for (int w = 0; w <= W; w++) {
                // 1번 나무에 있는 경우
                int get1 = (fruits[t] == 1)? 1: 0;
                // 이전에도 1번 나무에 있었던 경우 (이동 안함)
                dp[t][w][1] = dp[t - 1][w][1] + get1;
                // 2번 나무에서 1번 나무로 이동한 경우
                if (w > 0) {
                    dp[t][w][1] = Math.max(dp[t][w][1], dp[t-1][w - 1][2] + get1);
                }

                // 2번 나무의 있는 경우
                int get2 = (fruits[t] == 2)? 1: 0;

                dp[t][w][2] = dp[t - 1][w][2] + get2;  // 이동 안함

                // 1번 나무에서 2번 나무로 이동한 경우
                if (w > 0) {
                    dp[t][w][2] = Math.max(dp[t][w][2], dp[t - 1][w - 1][1] + get2);  // 이동함
                }
            }
        }

        int answer = 0;
        for (int w = 0; w <= W; w++) {
            answer = Math.max(answer, Math.max(dp[T][w][1], dp[T][w][2]));
        }

        System.out.println(answer);
    }
}
