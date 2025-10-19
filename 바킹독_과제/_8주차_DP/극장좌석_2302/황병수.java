package _8주차_DP.극장좌석_2302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 황병수 {

    static int[] seats;
    static int[] dp;
    static int[] calcList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        seats = new int[M];
        calcList = new int[M + 1];
        dp = new int[N + 1];

        for (int i = 0; i < M; i++) {
            seats[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(seats); // 고정석 좌석 정렬

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            // 여기에서 각 개수마다 경우의 수 구하기
            dp[i] = dp[i-1] + dp[i-2];
        }

        Arrays.sort(seats);

        int nowCnt = 0;
        for (int i = 0; i < M; i++) {
            int seat = seats[i];
            calcList[i] = seat - nowCnt - 1;  // 현재 구간 길이
            nowCnt = seat;
        }

        calcList[M] = N - nowCnt;


        long result = 1L;
        for (int i = 0; i <= M; i++) {
            result *= dp[calcList[i]];
        }

        System.out.println(result);
    }
}
