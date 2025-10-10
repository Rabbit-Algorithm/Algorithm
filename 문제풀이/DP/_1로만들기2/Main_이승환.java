package 문제풀이.DP._1로만들기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_이승환 {

    static int N;
    static int[] dp;

    static int[] prev;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //dp[i]는 i를 1로 만드는 데 최소 연산 횟수를 저장할 배열
        dp = new int[N+1];
        // prev[i]: i의 최적 경로에서 i 이전의 숫자를 저장
        prev = new int[N+1];


        dp[1] = 0;


        for(int i=2; i<=N; i++) {
            //1. 기본적으로 1을 빼는 경우로 초기화
            dp[i] = dp[i-1] + 1;
            prev[i] = i-1;

            //2. 2로 나누는 것이 더 빠르다면 갱신
            if(i%2 == 0 && dp[i] > dp[i/2] +1 ){
                dp[i] = dp[i/2] + 1;
                prev[i] = i/2;
            }

            //3. 3으로 나누는 것이 빠르다면 갱신
            if(i%3 == 0 && dp[i] > dp[i/3] + 1){
                dp[i] = dp[i/3] + 1;
                prev[i] = i/3;
            }

        }

        //1. 최소 연산 횟수 출력
        System.out.println(dp[N]);


        //2. 경로 역추적 및 출력
        StringBuilder sb = new StringBuilder();
        int current = N;
        while (current > 0){
            sb.append(current).append(" ");
            current = prev[current];
        }

        System.out.println(sb);

    }
}
