package 문제풀이.DP.RGB거리_1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_이승환 {

    static int N;
    static int[][] dp;
    static int[][] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //비용을 저장할 배열과 DP 테이블 dp 생성
        dp = new int[N+1][3];
        cost = new int[N+1][3];

        //각 집의 색칠 비용 입력 받기
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken()); //RED
            cost[i][1] = Integer.parseInt(st.nextToken()); //GREEN
            cost[i][2] = Integer.parseInt(st.nextToken()); //BLUE

        }

        // 1. 초기값 설정
        dp[1][0] = cost[1][0];
        dp[1][1] = cost[1][1];
        dp[1][2] = cost[1][2];

        // 2. 점화식을 이용해 DP 테이블 채우기
        for(int i=2; i<=N; i++){
            //i번쨰 집을 빨강으로 칠하는 경우
            dp[i][0] = cost[i][0] + Math.min(dp[i-1][1],dp[i-1][2]);
            //i번쨰 집을 초록으로 칠하는 경우
            dp[i][1] = cost[i][1] + Math.min(dp[i-1][0],dp[i-1][2]);
            //i번쨰 집을 파랑으로 칠하는 경우
            dp[i][2] = cost[i][2] + Math.min(dp[i-1][0],dp[i-1][1]);
        }

        // 3. 최종 답 구하기(N번쨰 집까지 칠한 후의 세 가지 경우 중 최소값)
        int result = Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2]));

        System.out.println(result);


    }
}
